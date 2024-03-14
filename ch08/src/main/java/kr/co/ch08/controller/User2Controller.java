package kr.co.ch08.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class User2Controller {

    private final UserService service;


    @GetMapping("/user2/login")
    public String login(){
        return "/user2/login";
    }

    @PostMapping("/user2/login")
    public String login(HttpSession session, UserDTO userDTO){

        UserDTO user = service.selectUser(userDTO);
        log.info(""+user);

        if(user != null){
            log.info("here1");
            // 회원이 맞을 경우 세션 저장
            session.setAttribute("sessUser", user);

            log.info("here2");
            return "redirect:/user2/success";

        }else{
            // 회원이 아닌 경우
            log.info("here3");
            return "redirect:/user2/login?success=100";
        }
    }

    @GetMapping("/user2/success")
    public String success(HttpSession session, HttpServletResponse resp){

        UserDTO sessUser = (UserDTO) session.getAttribute("sessUser");

        // 쿠키생성
        Cookie cookie = new Cookie("username", sessUser.getUid());
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        resp.addCookie(cookie);

        return "/user2/success";
    }

    @GetMapping("/user2/result")
    public String result(@CookieValue("JSESSIONID") String jsession,
                         @CookieValue("username") String username,
                         Model model){
        log.info(""+username);
        model.addAttribute("jsessionid", jsession);
        model.addAttribute("username", username);
        return "/user2/result";
    }


    @GetMapping("/user2/logout")
    public String logout(HttpSession session){

        session.removeAttribute("sessUser");
        session.invalidate();

        return "redirect:/user2/login?success=200";
    }
}