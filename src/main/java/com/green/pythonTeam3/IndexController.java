package com.green.pythonTeam3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String mainPage(){
        return "/main";
    }
}
