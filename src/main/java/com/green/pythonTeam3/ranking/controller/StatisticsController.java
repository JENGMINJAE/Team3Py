package com.green.pythonTeam3.ranking.controller;

import com.green.pythonTeam3.ranking.sevice.RankingServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource(name = "rankingService")
    private RankingServiceImpl rankingService;

    //화재통계 상세페이지 메인
    @GetMapping("statisticsFirst")
    public String statisticsFirst(){

        return "/content/statistics/statistics";
    }


}
