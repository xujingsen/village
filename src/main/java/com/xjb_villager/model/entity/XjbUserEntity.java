package com.xjb_villager.model.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;


/**
 *  村民用户表
 * @author 图灵 2021-01-29
 */
@ApiModel(value = "用户表")
@Data
public class XjbUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户名",name ="userName")
    private String userName;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别",name ="sex")
    private Integer sex;

    /**
     * 出生年月日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    /**
     * 手机
     */
    private String phone;

    /**
     * 身份证
     */
    private String card;

    /**
     * 学历
     */
    private Integer education;

    /**
     * 现居住地
     */
    private String address;

    /**
     * 家庭编号
     */
    private Integer familyNumber;

    /**
     * 属于哪一组 1:一组； 2：二组；
     */
    private Integer organize;

    /**
     * 用户图片
     */
    private String imagUrl;

    /**
     * 迁移他地的人，应该是关联表
     */
    private Integer immigrantId;

    /**
     * 去世标志 0：去世 1：活着
     */
    private Integer death;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 常年在外人员
     */
    private Integer permanentPersonnel;

    /**
     * 这条数据的创建人
     */
    private String founder;

    /**
     * 家庭内父编号
     */
    private String homeNumPid;

    /**
     * 家庭内子编号
     */
    private String homeNumSubid;

    /**
     * 病故时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deathTime;

    public XjbUserEntity() {
    }

}
