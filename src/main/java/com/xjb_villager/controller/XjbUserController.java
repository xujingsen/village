package com.xjb_villager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xjb_villager.lifei.common.ResultGenerator;
import com.xjb_villager.lifei.common.ResultLV;
import com.xjb_villager.lifei.config.exception.ServiceException;
import com.xjb_villager.lifei.enums.ResultCode;
import com.xjb_villager.lifei.util.HttpClientUtil;
import com.xjb_villager.model.entity.XjbUserEntity;
import com.xjb_villager.service.XjbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = {"OA-用户信息"})
@RestController
@RequestMapping("/user")
@Slf4j
public class XjbUserController {

    @Autowired
    private XjbUserService xjbUserService;
    @ApiOperation(value = "测试接口;参数可以没有")
    @RequestMapping("/getUserInfo")
    public ResultLV get(int a) {
        if (a != 10) {
            // return null;
            System.out.println(ResultCode.SUCCESS.getMesg());
            log.info("accation get:{}", a);
            // throw  new ServiceException(ResultCode.SUCCESS.getMesg());
            throw new ServiceException(ResultCode.SUCCESS, "失败了");
        }
        //无参数的调用
        //String url = "http://127.0.0.1:8081/user/teacher";
        //String s = HttpClientUtil.doGet(url);
       // System.out.println(s);
   /*     String str="{\"noticeType\": \"UNIFORM_SUBSCRIPTION\"," +
                " \"notice\": {" +
                " \"returnCode\": \"000000\"," +
                " \"description\": \"&½\"," +
                " \"orderId\": \"74f8ce8913d74969a725ef7c84f64b4b\"," +
                " \"productContent\": {" +
                " \"orderType\": \"1\"," +
                " \"productId\": \"9020500020090429000894\"," +
                " \"callNumber\": \"xxxxxxxxxxx\"," +
                " \"productPkgId\": \"00\"," +
                " \"contentId\": \"00\"," +
                " \"productName\": \"7000100301\"}}}";*/
        /*  Map map = (Map)JSON.parse(s);
        //System.out.println(map);
        for(Object key:map.keySet()){//keySet获取map集合key的集合  然后在遍历key即可
            String value = map.get(key).toString();//
            System.out.println("key:"+key+" vlaue:"+value);
        }*/
/*
        List<Map<String,String>> listObjectFir = (List<Map<String,String>>) JSONArray.parse(s);
        System.out.println("利用JSONArray中的parse方法来解析json数组字符串");
        for(Map<String,String> mapList : listObjectFir) {
            for (Map.Entry entry : mapList.entrySet()) {
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }

        }*/

        String url = "http://127.0.0.1:8081/user/tea";
        int id  = 1;
        Map<String, String> map2 = new HashMap<>();
        map2.put("id",String.valueOf(id));
        String s = HttpClientUtil.doGet(url,map2);
        System.out.println(s);
        Object parse = JSON.parse(s);

        return ResultGenerator.genSuccessResult(parse);
    }

    /**
     * [查询] 分页查询
     *
     * @author 图灵
     * @date 2021/01/29
     **/
    @ApiOperation(value = "测试")
    @RequestMapping("/pageList")
    public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int offset,
                                        @RequestParam(required = false, defaultValue = "10") int pagesize) {
        System.out.println(offset + pagesize);
        return xjbUserService.pageList(offset, pagesize);
    }

    @ApiOperation(value = "获取用户列表;参数可以没有，分页参数（不传则默认查询全部）")
    @RequestMapping("/userList")
    public ResultLV findUserList(int page,int size) {
        PageHelper.startPage(page,size);
        List<XjbUserEntity> userList = xjbUserService.findUserList();
        PageInfo<XjbUserEntity> pageInfoList = new PageInfo<>(userList);
        System.out.println(pageInfoList.getPages());
        System.out.println(pageInfoList.getPageSize());
        System.out.println(pageInfoList.getEndRow());
        System.out.println(pageInfoList.isHasNextPage());
        return ResultGenerator.genSuccessResult(pageInfoList);
    }


}
