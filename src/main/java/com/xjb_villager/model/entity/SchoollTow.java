package com.xjb_villager.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lifei
 * @version 1.0.0
 * @ClassName SchoollTow.java
 * @Description
 * @createTime 2021年09月20日 19:54:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoollTow {
    private int id;
    private String scholName;
    private String address;
    private Double measure;
    private String area;
    private  int age;
    private  String manoy;

}
