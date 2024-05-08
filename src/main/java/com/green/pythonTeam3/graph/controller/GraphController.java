package com.green.pythonTeam3.graph.controller;

import com.green.pythonTeam3.graph.service.GraphServiceImpl;
import com.green.pythonTeam3.graph.vo.GraphVO;
import com.green.pythonTeam3.ranking.vo.FirePlaceVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/graph")
public class GraphController {
    @Resource(name = "graphService")
    private GraphServiceImpl graphService;

    @ResponseBody
    @PostMapping("/graphFetch")
    public List<GraphVO> graphFetch(@RequestParam(name = "selectYear")int selectYear){
        List<GraphVO> graphVOList = new ArrayList<>();
        GraphVO graphVO = new GraphVO();
        GraphVO graphVO2 = new GraphVO();
        int[] arr = new int[12];
        int[] arr2 = new int[12];
        List<FirePlaceVO> a = graphService.totalCnt(selectYear);
        List<FirePlaceVO> b = graphService.monthStarPropertyDamage(selectYear);
        for(int i = 0 ; i < a.size() ; i++){
            arr[i] = a.get(i).getCount();
        }
        for(int i = 0 ; i< b.size(); i++){
            arr2[i] = b.get(i).getPropertyDamage()/100000;
        }
        graphVO.setLabel("화재발생");
        graphVO2.setLabel("피해금액");
        graphVO.setType("bar");
        graphVO2.setType("line");
        graphVO.setBackgroundColor("rgba(246,187,67,1)");
        graphVO2.setBackgroundColor("rgba(246,93,33,1)");
        graphVO2.setBorderColor("rgba(246,93,33,1)");
        graphVO.setData(arr);
        graphVO2.setData(arr2);

        graphVOList.add(graphVO);
        graphVOList.add(graphVO2);

        return graphVOList;
    }

}
