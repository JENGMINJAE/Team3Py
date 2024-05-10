package com.green.pythonTeam3.dmg.controller;

import com.green.pythonTeam3.dmg.service.DmgServiceImpl;
import com.green.pythonTeam3.dmg.vo.FiveVO;
import com.green.pythonTeam3.dmg.vo.SixVO;
import jakarta.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dmg")
public class DmgController {
    @Resource(name = "dmgService")
    private DmgServiceImpl dmgService;

    @GetMapping("/dmgList")
    public String dmgList(Model model){
        model.addAttribute("totalIjd",dmgService.totalIjd());
        model.addAttribute("totalMoney",dmgService.totalMoney());
        model.addAttribute("yearIjd",dmgService.ijdPp());
        model.addAttribute("yearMoney",dmgService.moneyDmg());
        return "/content/dmg/dmg_list";
    }
    @ResponseBody
    @PostMapping("/fetchInjPp")
    public List<FiveVO> fetchInjPp(){
        return dmgService.ijdPp();
    }
    @ResponseBody
    @PostMapping("/fetchMoneyDmg")
    public List<SixVO> fetchMoneyDmg(){
        return dmgService.moneyDmg();
    }
}
