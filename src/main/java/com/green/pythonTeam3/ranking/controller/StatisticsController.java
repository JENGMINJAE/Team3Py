package com.green.pythonTeam3.ranking.controller;

import com.green.pythonTeam3.ranking.sevice.RankingServiceImpl;
import com.green.pythonTeam3.ranking.sevice.StatisticsServiceImpl;
import com.green.pythonTeam3.sido.vo.Python3VO;
import com.green.pythonTeam3.sido.vo.Python4VO;
import com.green.pythonTeam3.total.vo.FireStartPlaceVO;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    @Resource(name = "statisticsService")
    private StatisticsServiceImpl statisticsService;

    //주요 화재통계
    @GetMapping("statisticsFirst")
    public String statisticsFirst(Model model){
        //1. 3개년 전체 발생건수 & 피해금액, 각 연도별 발생건수 & 피해금액
        Python4VO totalOccAndProperty = statisticsService.totalOccAndProperty();
        //피해금액 [단위: 억]으로 나누기
        totalOccAndProperty.setPropertyDamage2021(totalOccAndProperty.getPropertyDamage2021() / 100000);
        totalOccAndProperty.setPropertyDamage2022(totalOccAndProperty.getPropertyDamage2022() / 100000);
        totalOccAndProperty.setPropertyDamage2023(totalOccAndProperty.getPropertyDamage2023() / 100000);
        totalOccAndProperty.setTotalPropertyDamage(totalOccAndProperty.getTotalPropertyDamage() / 100000);
        model.addAttribute("totalOccAndProperty", totalOccAndProperty);

        //2. 3개년 전체 인명피해
        Python3VO totalLifeDmg = statisticsService.totalLifeDmg();
        model.addAttribute("totalLifeDmg", totalLifeDmg);

        //3. 지역별 화재피해
        List<Python3VO> totalLocalDmg = statisticsService.totalLocalDmg();
        model.addAttribute("totalLocalDmg", totalLocalDmg);
        System.out.println(totalLocalDmg);

        return "/content/statistics/statistics";
    }

    // 주제별 화재 통계
    //1. 화재 장소(막대 그래프)
    @ResponseBody
    @PostMapping("/detailFirePlaceFetch")
    public Map<String, Object> firePlace(){
        Map<String, Object> map = new HashMap<>();
        //1-1. 3개년 데이터
        List<FireStartPlaceVO> totalFirePlace = statisticsService.totalFirePlace();
        map.put("totalFirePlace", totalFirePlace);
        System.out.println(totalFirePlace);
        return map;
    }

    //1-2. 2021~2023년 화재 장소(원형 그래프)
    @ResponseBody
    @PostMapping("/firePlaceFetch")
    public Map<String, Object> fetchFirePlaceData() {
        Map<String, Object> map = new HashMap<>();
        //연도별 데이터
        List<FireStartPlaceVO> firePlace2021 = statisticsService.firePlace2021();
        List<FireStartPlaceVO> firePlace2022 = statisticsService.firePlace2022();
        List<FireStartPlaceVO> firePlace2023 = statisticsService.firePlace2023();
        map.put("firePlace2021", firePlace2021);
        map.put("firePlace2022", firePlace2022);
        map.put("firePlace2023", firePlace2023);
        return map;
    }


}
