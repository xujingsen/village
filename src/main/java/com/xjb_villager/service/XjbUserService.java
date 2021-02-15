package com.xjb_villager.service;

import com.xjb_villager.model.entity.XjbUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 村民用户表
 * @author 图灵
 * @date 2021/01/29
 */
public interface XjbUserService {



    /**
     * 根据主键 id 查询
     */
    public XjbUserEntity load(int id);

    /**
     * 分页查询
     */
    public Map<String,Object> pageList(int offset, int pagesize);


    List<XjbUserEntity> findUserList();

}
