package com.green.pythonTeam3.total.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//10. 발화장소별 화재현황(민재)
public class FireStartPlaceVO {
    private String placeBigType; // 발화장소대분류명
    private String placeMediumType; // 발화장소중분류명
    private String dateOfIncident; // 발생일자
    private int injuredPeople; // 부상자인원수
    private int occurrences; // 발생건수
    private int propertyDamage; // 재산피해소계금액
}
