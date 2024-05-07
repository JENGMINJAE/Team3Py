package com.green.pythonTeam3.yearStar.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("yearStarService")
public class YearStarServiceImpl implements YearStarService{
    @Autowired
    private SqlSessionTemplate sqlSession;
}
