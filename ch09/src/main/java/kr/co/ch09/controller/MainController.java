package kr.co.ch09.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "/index";
    }

    @GetMapping("/user1/list")
    public String user1List(){
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String user1Register(){
        return "/user1/register";
    }

    @GetMapping("/user1/modify")
    public String user1Modify(){
        return "/user1/modify";
    }

    @GetMapping("/user2/list")
    public String user2List(){
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String user2Register(){
        return "/user2/register";
    }

    @GetMapping("/user2/modify")
    public String user2Modify(){
        return "/user2/modify";
    }
}
