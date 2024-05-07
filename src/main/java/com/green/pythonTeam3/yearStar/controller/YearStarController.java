package com.green.pythonTeam3.yearStar.controller;

import com.green.pythonTeam3.yearStar.service.YearStarServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yearStar")
public class YearStarController {
    @Resource(name = "yearStarService")
    private YearStarServiceImpl yearStarService;

}
