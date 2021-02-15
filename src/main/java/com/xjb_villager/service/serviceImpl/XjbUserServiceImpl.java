package com.xjb_villager.service.serviceImpl;


import com.xjb_villager.mapper.XjbUserMapper;
import com.xjb_villager.model.entity.XjbUserEntity;
import com.xjb_villager.service.XjbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 村民用户表
 * @author 图灵
 * @date 2021/01/29
 */
@Service
public class XjbUserServiceImpl implements XjbUserService {
    @Autowired
    private XjbUserMapper xjbUserMapper;

    @Override
    public XjbUserEntity load(int id) {
        return null;
    }


    @Override
    public Map<String,Object> pageList(int offset, int pagesize) {

        List<XjbUserEntity> pageList = xjbUserMapper.pageList(offset, pagesize);
        int totalCount = xjbUserMapper.pageListCount(offset, pagesize);

        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return result;
    }

    @Override
    public List<XjbUserEntity> findUserList() {
        return xjbUserMapper.findUserList();
    }
}
