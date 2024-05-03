package com.green.pythonTeam3.sido.controller;

import com.green.pythonTeam3.graph.vo.GraphVO;
import com.green.pythonTeam3.ranking.vo.FirePlaceVO;
import com.green.pythonTeam3.sido.service.SidoService;
import com.green.pythonTeam3.sido.service.SidoServiceImpl;
import com.green.pythonTeam3.sido.vo.Python3VO;
import com.green.pythonTeam3.sido.vo.Python4VO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sido")
@Controller
public class SidoController {

    @Resource(name = "sidoService")
    private SidoServiceImpl sidoService;

    // 시도별 2021~20323 화재피해액 데이터
    @GetMapping("/sidoFirst")
    public String sidoFirst(Model model){
        /////////////// 재산피해 데이터 ///////////////////
        // 시도명(버튼)
        List<Python4VO> sidoNameList  = sidoService.selectSido();
        model.addAttribute("sidoNameList", sidoNameList);
        // 2021
        List<Python4VO> property2021 =sidoService.property2021();
        model.addAttribute("property2021", property2021 );

        // 2022
        List<Python4VO> property2022 =sidoService.property2022();
        model.addAttribute("property2022", property2022 );
        // 2023
        List<Python4VO> property2023 =sidoService.property2023();
        model.addAttribute("property2023", property2023 );
        // 3년간 총 피해액 발생건
        List<Python4VO> totalProperty =sidoService.totalProperty();
        model.addAttribute("totalProperty", totalProperty );

        /////////////// 인명피해 데이터 ///////////////////
        // 3년간 총 피해인명수 발생건
        List<Python3VO> totalVictim =sidoService.totalVictim();
        model.addAttribute("totalVictim", totalVictim );

        return "/content/sido/sido_property";
    }


    // 각 시도의 월별 2021~2023 화재피해액 데이터
    @GetMapping("/sidoMonth")
    public String sidoMonth(@RequestParam(name ="sidoNm") String sidoNm, Model model){

        /////////////// 재산피해 데이터 ///////////////////
        // 2021
        List<Python4VO> monthPro2021  = sidoService.monthPro2021(sidoNm);
        model.addAttribute("monthPro2021", monthPro2021);
        // 2022
        System.out.println(monthPro2021);
        List<Python4VO> monthPro2022  = sidoService.monthPro2022(sidoNm);
        model.addAttribute("monthPro2022", monthPro2022);
        // 2023
        List<Python4VO> monthPro2023  = sidoService.monthPro2023(sidoNm);
        model.addAttribute("monthPro2023", monthPro2023);

        /////////////// 인명피해 데이터 ///////////////////

        return "/content/sido/sido_month_property";
    }


        //    메인 2023
        @ResponseBody
        @PostMapping("/sidoFetch2023")
        public List<Python4VO> sidoFetch2023(@RequestParam(name = "selectYear")int selectYear){
            List<Python4VO> selectYear2023 = sidoService.selectYear2023();
            System.out.println("555555555555" + selectYear2023);
            return selectYear2023;
        }



}
