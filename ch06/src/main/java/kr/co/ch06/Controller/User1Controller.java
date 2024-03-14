package kr.co.ch06.Controller;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.service.User1Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Controller
public class User1Controller {

    // @AllArgsConstructor 선언으로 생성자 주입 -> 따로 생성자 정의 필요 없음
    public final User1Service service;


    @GetMapping("/user1/list")
    public String list(Model model){
        List<User1DTO> users = service.selectUser1s();
        log.info(users.toString());
        model.addAttribute("users", users);
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        log.info(user1DTO.toString());
        service.insertUser1(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){ // Spring Boot는 @RequestParam 선언 안해도 됨
        log.info("modify : " + uid);
        User1DTO user1DTO = service.selectUser1(uid);
        log.info(user1DTO.toString());
        model.addAttribute(user1DTO);
        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        log.info(user1DTO.toString());
        service.updateUser1(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid){ // Spring Boot는 @RequestParam 선언 안해도 됨
        log.info("delete : " + uid);
        service.deleteUser1(uid);
        return "redirect:/user1/list";
    }
}
