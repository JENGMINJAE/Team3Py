package com.green.pythonTeam3.ranking.sevice;

import com.green.pythonTeam3.ranking.vo.FirePlaceVO;
import com.green.pythonTeam3.total.vo.FireStartPlaceVO;

import java.util.List;

public interface RankingService {
    // 메인화면 top3 조회
    //1. 발화장소 - 대분류명
    List<FireStartPlaceVO> mainPlaceTop1(FireStartPlaceVO fireStartPlaceVO);
    //2. 발화장소 - 중분류명
    List<FireStartPlaceVO> mainPlaceTop2(FireStartPlaceVO fireStartPlaceVO);
    //3. 화재장소
    List<FirePlaceVO> mainPlaceTop3(FirePlaceVO firePlaceVO);

}
