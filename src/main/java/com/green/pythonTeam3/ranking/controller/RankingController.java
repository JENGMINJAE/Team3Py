package com.green.pythonTeam3.ranking.controller;

import com.green.pythonTeam3.ranking.sevice.RankingServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    @Resource(name = "rankingService")
    private RankingServiceImpl rankingService;

    //화재피해장소 페이지
    @GetMapping("/place")
    public String place(){
        return "/content/place/place";
    };

}
