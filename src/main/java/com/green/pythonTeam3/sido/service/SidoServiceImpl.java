package com.green.pythonTeam3.sido.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sidoService")
public class SidoServiceImpl implements SidoService {

    @Autowired
    private SqlSessionTemplate sqlSession;
}
