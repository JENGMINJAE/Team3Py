package com.green.pythonTeam3.ranking.sevice;

import com.green.pythonTeam3.sido.vo.Python3VO;
import com.green.pythonTeam3.sido.vo.Python4VO;
import com.green.pythonTeam3.total.vo.FireStartPlaceVO;

import java.util.List;

public interface StatisticsService {
    //주요 화재통계
    //1. 3개년 전체 발생건수 & 피해금액, 각 연도별 발생건수 & 피해금액
    Python4VO totalOccAndProperty();

    //2. 3개년 전체 인명피해
    Python3VO totalLifeDmg();

    //3. 지역별 화재피해
    List<Python3VO> totalLocalDmg();

    // 주제별 화재 통계
    //1. 화재 장소
    //1-1. 3개년 데이터(막대 그래프)
    List<FireStartPlaceVO> totalFirePlace();
    //1-1. 3개년 데이터 토탈
    FireStartPlaceVO realTotalFirePlace();
    //1-2. 2021~2023년 화재 장소(원형 그래프)
    List<FireStartPlaceVO> firePlace2021();
    List<FireStartPlaceVO> firePlace2022();
    List<FireStartPlaceVO> firePlace2023();



}
