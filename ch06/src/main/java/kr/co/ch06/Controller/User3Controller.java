package kr.co.ch06.Controller;

import kr.co.ch06.service.User3Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Slf4j
@Controller
public class User3Controller {

    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(){
        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(){
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(){
        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(){
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(){
        return "redirect:/user3/list";
    }

}
