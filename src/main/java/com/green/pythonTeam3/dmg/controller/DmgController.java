package com.green.pythonTeam3.dmg.controller;

import com.green.pythonTeam3.dmg.service.DmgServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dmg")
public class DmgController {
    @Resource(name = "dmgService")
    private DmgServiceImpl dmgService;

    @GetMapping("/dmgList")
    public String dmgList(){
        return "/content/dmg/dmg_list";
    }
}
