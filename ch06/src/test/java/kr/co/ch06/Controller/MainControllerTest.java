package kr.co.ch06.controller;



import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {

    /*
     * MockMvc는 웹 어플리케이션을 서버에 배포하지 않고
     * Spring MVC의 동작을 재현하여 테스트 할 수 있는 클래스
     */
    // MVC 테스트를 위한 가상 mvc 객체
    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll ...");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach ...");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("AfterAll ...");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("AfterEach ...");
    }


    public void index() throws Exception {
        mockMvc
                .perform(get("/index"))				// index 요청 테스트
                .andExpect(status().isOk())			// 요청 결과 상태 테스트
                .andExpect(view().name("/index"))	// 반환되는 View 이름 테스트
                .andDo(print());					// 요청 테스트 결과 출력
    }

    @Test
    // MainController에 getParam() 요청 메서드 정의
    public void getParam() throws Exception {
        mockMvc
                .perform(get("/getParam")
                        .param("name", "홍길동")
                        .param("age", "23"))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/index"))
                .andDo(print());

        /*
        for(int i=0 ; i<1000 ; i++) {
            mockMvc
                .perform(get("/getParam")
                        .param("name", "홍길동")
                        .param("age", "23"))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/index"))
                .andDo(print());
        }
        */
    }




    // MainController에 postParam() 요청 메서드 정의
    public void postParam() throws Exception {
        mockMvc
                .perform(post("/postParam")
                        .param("uid", "p101")
                        .param("name", "김유신"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"))
                .andDo(print());
    }
}