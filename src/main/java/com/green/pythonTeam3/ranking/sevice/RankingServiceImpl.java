package com.green.pythonTeam3.ranking.sevice;

import com.green.pythonTeam3.ranking.vo.FirePlaceVO;
import com.green.pythonTeam3.total.vo.FireStartPlaceVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rankingService")
public class RankingServiceImpl implements RankingService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    // 메인화면 top3 조회
    //1. 발화장소 - 대분류명
    @Override
    public List<FireStartPlaceVO> mainPlaceTop1(FireStartPlaceVO fireStartPlaceVO) {
        return sqlSession.selectList("placeMapper.mainPlaceTop1", fireStartPlaceVO);
    }
    //2. 발화장소 - 중분류명
    @Override
    public List<FireStartPlaceVO> mainPlaceTop2(FireStartPlaceVO fireStartPlaceVO) {
        return sqlSession.selectList("placeMapper.mainPlaceTop2", fireStartPlaceVO);
    }
    //3. 화재장소
    @Override
    public List<FirePlaceVO> mainPlaceTop3(FirePlaceVO FirePlaceVO) {
        return sqlSession.selectList("placeMapper.mainPlaceTop3", FirePlaceVO);
    }

}
