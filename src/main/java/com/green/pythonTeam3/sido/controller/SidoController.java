package com.green.pythonTeam3.sido.controller;

import com.green.pythonTeam3.sido.service.SidoServiceImpl;
import com.green.pythonTeam3.sido.vo.Python4VO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/sido")
@Controller
public class SidoController {

    @Resource(name = "sidoService")
    private SidoServiceImpl sidoService;

    // 시도별 2021~20323 화재피해액 데이터
    @GetMapping("/sidoFirst")
    public String sidoFirst(Model model){
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
        System.out.println(totalProperty);
        return "/content/sido/sido_property";
    }


    // 각 시도의 월별 2021~2023 화재피해액 데이터
    @GetMapping("/sidoMonth")
    public String sidoMonth(@RequestParam(name ="sidoNm") String sidoNm, Model model){
        // 시도명(버튼)
        List<Python4VO> sidoNameList  = sidoService.selectSido();
        model.addAttribute("sidoNameList", sidoNameList);

        List<Python4VO> monthPro2021  = sidoService.monthPro2021(sidoNm);
        model.addAttribute("monthPro2021", monthPro2021);
        System.out.println(monthPro2021);
        List<Python4VO> monthPro2022  = sidoService.monthPro2022(sidoNm);
        model.addAttribute("monthPro2022", monthPro2022);

        List<Python4VO> monthPro2023  = sidoService.monthPro2023(sidoNm);
        model.addAttribute("monthPro2023", monthPro2023);
        return "/content/sido/sido_month_property";
    }


}
