package com.green.pythonTeam3.graph.controller;

import com.green.pythonTeam3.graph.service.GraphServiceImpl;
import com.green.pythonTeam3.graph.vo.GraphVO;
import com.green.pythonTeam3.ranking.vo.FirePlaceVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/graph")
public class GraphController {
    @Resource(name = "graphService")
    private GraphServiceImpl graphService;

    @ResponseBody
    @PostMapping("/graphFetch")
    public GraphVO graphFetch(){
        GraphVO graphVO = new GraphVO();
        int[] arr = new int[12];
        List<FirePlaceVO> a = graphService.totalCnt();
        for(int i = 0 ; i < a.size() ; i++){
            arr[i] = a.get(i).getCount();
        }
        graphVO.setLabel("화재발생");
        graphVO.setType("bar");
        graphVO.setBackgroundColor("rgba(246,187,67,1)");
        graphVO.setData(arr);
        return graphVO;
    }

}
