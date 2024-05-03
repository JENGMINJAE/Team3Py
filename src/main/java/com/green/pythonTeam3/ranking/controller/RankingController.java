package com.green.pythonTeam3.ranking.controller;

import com.green.pythonTeam3.ranking.sevice.RankingServiceImpl;
import com.green.pythonTeam3.ranking.vo.FirePlaceVO;
import com.green.pythonTeam3.total.vo.FireStartPlaceVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ranking")
public class RankingController {

    @Resource(name = "rankingService")
    private RankingServiceImpl rankingService;

    //메인 페이지 top3 목록 조회 - 비동기
    @ResponseBody
    @RequestMapping("/mainRanking")
    public String mainTop3(FireStartPlaceVO fireStartPlaceVO, FirePlaceVO firePlaceVO, Model model){
        //1. 발화장소 - 대분류명
        List<FireStartPlaceVO> mainTopList1 = rankingService.mainPlaceTop1(fireStartPlaceVO);
        model.addAttribute("mainTopList1", mainTopList1);
        //2. 발화장소 - 중분류명
        List<FireStartPlaceVO> mainTopList2 = rankingService.mainPlaceTop2(fireStartPlaceVO);
        model.addAttribute("mainTopList2", mainTopList2);
        //3. 화재장소
        List<FirePlaceVO>mainTopList3 = rankingService.mainPlaceTop3(firePlaceVO);
        model.addAttribute("mainTopList3", mainTopList3);
        
        return "main/main";
    };

    //화재피해장소 페이지
    @GetMapping("/place")
    public String place(){
        return "/content/place/place";
    };



}
