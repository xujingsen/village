package com.xjb_villager.controller.dataStatisticController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjb_villager.model.entity.ClassGrade;
import com.xjb_villager.model.entity.School;
import com.xjb_villager.model.entity.SchoollTow;
import com.xjb_villager.model.vo.DataInfoVO;
import com.xjb_villager.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = {"OA-数据统计信息"})
@RestController
@RequestMapping("/dataInfo")
@Slf4j
public class DataController {

   @Autowired
   private DataService dataService;

    @ApiOperation(value = "获取村民统计数据")
    @RequestMapping("/villagersInfo")
    public DataInfoVO getUserDataInfo(){
        DataInfoVO infoVO =dataService.getDataInfo();
        return  infoVO;
    }


 @PostMapping("/getSchool")
    public int getDate(@RequestBody JSONObject jsonObject){
     School school = new School();
     // 1:json直接转对象
     school = JSON.toJavaObject(jsonObject, School.class);
     System.out.println(school.getId());
     System.out.println(school.getAddress());
     //2:json获取字符串
 /*    String id = jsonObject.getString("id");
     String scholName = jsonObject.getString("scholName");
     这是错误的不能转的
     String classGradeList1 = jsonObject.getString("classGradeList");
     JSONObject jsonObject1 = JSONObject.parseObject(classGradeList1);
     ClassGrade classGrade = JSON.toJavaObject(jsonObject1, ClassGrade.class);
 */
    //4:这个字符串里是个json 的集合
     JSONArray classGradeList = jsonObject.getJSONArray("classGradeList");
     System.out.println(classGradeList);
     String s = JSONArray.toJSONString(classGradeList);
     System.out.println(s);
     //要用这个转，转成Java类型的集合
     List<ClassGrade> classGrades = JSONArray.parseArray(s, ClassGrade.class);
     classGrades.forEach(System.out::println);
     //school.setClassGradeList(classGrades);
     System.out.println(school);

     HashMap<String, String> map = new HashMap<>();
     map.put("a","1");
     map.put("b","2");
     map.put("c","3");
     //map转json字符串
     String s1 = JSON.toJSONString(map);
     System.out.println(s1);
     //把json字符传转真json对象
     JSONObject jsonObject1 = JSON.parseObject(s1);
     System.out.println(jsonObject1);
//把json对象转成map
     Map<String,String> map2 = JSONObject.toJavaObject(jsonObject1, Map.class);
   for(Map.Entry<String,String> m : map2.entrySet()){
       System.out.println("key"+m.getKey()+"value"+m.getValue());
   }
     //把json字符串转成map
     Map<String,String> map1 = JSONObject.parseObject(s1, Map.class);
     for (Map.Entry<String, String> m2 : map1.entrySet()) {
         System.out.println("key:" + m2.getKey() + " value:" + m2.getValue());
     }
     return 1;
 }
    @PostMapping("/getUser")
    public int getDate(@RequestBody School school) {
        SchoollTow schoollTow = new SchoollTow();
        BeanUtils.copyProperties(school,schoollTow);
        System.out.println(school);
        System.out.println(schoollTow);
        return 1;
    }
}
