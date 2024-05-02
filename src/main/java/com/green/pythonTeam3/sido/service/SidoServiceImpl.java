package com.green.pythonTeam3.sido.service;

import com.green.pythonTeam3.sido.vo.Python4VO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sidoService")
public class SidoServiceImpl implements SidoService {

    @Autowired
    private SqlSessionTemplate sqlSession;


    //  #################  년도별 조회 ###################
    @Override
    public List<Python4VO> property2021() {
        return sqlSession.selectList("sidoMapper.property2021");
    }

    @Override
    public List<Python4VO> property2022() {
        return sqlSession.selectList("sidoMapper.property2022");
    }

    @Override
    public List<Python4VO> property2023() {
        return sqlSession.selectList("sidoMapper.property2023");
    }


    //  #################  월별 조회 ###################
    @Override
    public List<Python4VO> monthPro2021(String sidoNm) {
        return sqlSession.selectList("sidoMapper.monthPro2021", sidoNm);
    }

    @Override
    public List<Python4VO> monthPro2022(String sidoNm) {
        return sqlSession.selectList("sidoMapper.monthPro2022", sidoNm);
    }

    @Override
    public List<Python4VO> monthPro2023(String sidoNm) {
        return sqlSession.selectList("sidoMapper.monthPro2023", sidoNm);
    }

    //  #################  시도명 조회 ###################
    @Override
    public List<Python4VO> selectSido() {
        return sqlSession.selectList("sidoMapper.selectSido");
    }
    //  #################  2021~2023년 총 발생건수 & 피해액 ###################
    @Override
    public List<Python4VO> totalProperty() {
        return sqlSession.selectList("sidoMapper.totalProperty");
    }
}
