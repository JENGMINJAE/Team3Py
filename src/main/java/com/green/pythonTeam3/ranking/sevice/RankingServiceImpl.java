package com.green.pythonTeam3.ranking.sevice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rankingService")
public class RankingServiceImpl implements RankingService{
    @Autowired
    private SqlSessionTemplate sqlSession;



}
