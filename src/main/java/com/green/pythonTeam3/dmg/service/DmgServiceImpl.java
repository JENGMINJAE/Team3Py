package com.green.pythonTeam3.dmg.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dmgService")
public class DmgServiceImpl implements DmgService{
    @Autowired
    private SqlSessionTemplate sqlSession;
}
