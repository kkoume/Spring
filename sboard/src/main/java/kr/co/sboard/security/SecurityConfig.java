package kr.co.sboard.security;

import kr.co.sboard.oauth2.OAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final OAuth2UserService oauth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // 인증 설정(로그인)
        httpSecurity.formLogin(login -> login
                                        .loginPage("/user/login")
                                        .defaultSuccessUrl("/")
                                        .failureUrl("/user/login?success=100")
                                        .usernameParameter("uid")
                                        .passwordParameter("pass"));

        // 로그아웃 설정
        httpSecurity.logout(logout -> logout
                                        .invalidateHttpSession(true)
                                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                                        .logoutSuccessUrl("/user/login?success=300"));

        //OAuth 설정
        httpSecurity.oauth2Login(oauth -> oauth
                                        .loginPage("/user/login")
                                        .defaultSuccessUrl("/")
                                        .userInfoEndpoint(userInfo -> userInfo.userService(oauth2UserService)));


        /*
            인가 설정
             - Spring Security는 존재하지 않는 요청 주소에 대해 기본적으로 login 페이지로 redirect를 수행
             - 자원 요청의 추가 인가 처리 확장과 redirect 기본 해제를 위해 마지막에 .anyRequest().permitAll() 설정
         */
        httpSecurity.authorizeHttpRequests(authorize -> authorize
                                                        .requestMatchers("/").authenticated()
                                                        .requestMatchers("/article/**").permitAll()
                                                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                                                        .requestMatchers("/manager/**").hasAnyAuthority("ADMIN", "MANAGER")
                                                        .anyRequest().permitAll());

        // 사이트 위변조 방지 설정
        httpSecurity.csrf(CsrfConfigurer::disable);

        return httpSecurity.build();
    }

    // Security 인증 암호화 인코더 설정
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
