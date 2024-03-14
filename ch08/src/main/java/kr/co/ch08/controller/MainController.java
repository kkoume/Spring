package kr.co.ch08.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "/index";
    }

    @GetMapping("/admin/index")
    public String adminIndex(){
        return "/admin/index";
    }

    @GetMapping("/manager/index")
    public String managerIndex(){
        return "/manager/index";
    }

}
