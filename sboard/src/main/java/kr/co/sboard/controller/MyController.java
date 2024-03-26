package kr.co.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {


    @GetMapping("/my/setting")
    public String setting(){
        return "/my/setting";
    }

}