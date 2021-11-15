package com.xjb_villager.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lifei
 * @version 1.0.0
 * @ClassName School.java
 * @Description 学校信息
 * @createTime 2021年09月20日 09:18:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private int id;
    private String scholName;
    private String address;
    private Double measure;
    private List<ClassGrade> classGradeList;
}
