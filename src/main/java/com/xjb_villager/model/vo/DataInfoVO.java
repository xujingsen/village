package com.xjb_villager.model.vo;

import lombok.Data;

@Data
public class DataInfoVO {
    /**
     * 全村人数
     */
    private  int allPeople;


    /**
     * 全村男人数
     */
    private  int allMan;

    /**
     * 全村女人数
     */
    private  int allWoman;


    /**
     * 全村男女人比列
     */
    private  String sexRatio;

    /**
     * 全村65岁以上人数
     */
    private  int sixtyFivePeople;

    /**
     * 全村65岁以上男人数
     */
    private  int sixtyFiveMan;

    /**
     * 全村65岁以上女人数
     */
    private  int sixtyFiveWoman;

    /**
     * 全村65岁以上男女人数比例
     */
    private  String sixtyFiveSexRatio;

    /**
     * 年龄老龄化比例
     */
    private  String agingSexRatio;


    /**
     * 老年人与年轻人比例
     */
    private  String oldRatioYoung;
    /**
     * 性别
     */
    private  int sex;

    /**
     * 人数
     */
    private  int numPeople;

}
