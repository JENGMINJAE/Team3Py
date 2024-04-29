package com.green.pythonTeam3.sido.controller;

import com.green.pythonTeam3.sido.service.SidoServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sido")
@Controller
public class SidoController {

    @Resource(name = "sidoService")
    private SidoServiceImpl stuTestService;

    @GetMapping("/sidoFirst")
    public String sidoFirst(){
        return "/content/sido/sido_property";
    }
}
