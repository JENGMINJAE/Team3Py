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

    // 시도별 2021~20323 화재피해액 데이터
    @GetMapping("/sidoFirst")
    public String sidoFirst(){
        return "/content/sido/sido_property";
    }


    // 각 시도의 월별 2021~2023 화재피애액 데이터
    @GetMapping("/sidoMonth")
    public String sidoMonth(){

        return "/content/sido/sido_month_property";
    }


}
