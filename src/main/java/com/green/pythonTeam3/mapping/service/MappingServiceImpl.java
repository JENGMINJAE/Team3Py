package com.green.pythonTeam3.mapping.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mappingService")
public class MappingServiceImpl implements MappingService{

    @Autowired
    private SqlSessionTemplate sqlSession;

}
