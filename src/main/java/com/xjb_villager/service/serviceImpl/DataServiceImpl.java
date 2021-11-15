package com.xjb_villager.service.serviceImpl;

import com.xjb_villager.mapper.XjbUserMapper;
import com.xjb_villager.model.entity.XjbUserEntity;
import com.xjb_villager.model.vo.DataInfoVO;
import com.xjb_villager.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private XjbUserMapper xjbUserMapper;

    @Override
    public DataInfoVO getDataInfo() {
        DataInfoVO infoVO = new DataInfoVO();
        //全村总人数
      int allPeople =  xjbUserMapper.pageListCount();
      infoVO.setAllPeople(allPeople);

        //全村男女各多少
      List<DataInfoVO>  list = xjbUserMapper.selectCountManAndWomen();
        for(DataInfoVO people : list){
          if(people.getSex()==0){
              infoVO.setAllWoman(people.getNumPeople());
          }else {
              infoVO.setAllMan(people.getNumPeople());
          }
      }
        Float num2 = (float)(infoVO.getAllMan())/(infoVO.getAllWoman());
        DecimalFormat df = new DecimalFormat("0.00%");//格式化小数 ， 其实这里还可以这样写 DecimalFormat("0.00%");   这样就不用在最后输出时还要加。
        String format = df.format(num2);
        infoVO.setSexRatio(format);

        //全村65岁以上的人有多少
        int  sixtyFiveCoutnt =  xjbUserMapper.selectCountsixtyFivePeople();
        infoVO.setSixtyFivePeople(sixtyFiveCoutnt);

        //全村65岁以上男女各多少
        List<DataInfoVO>  list2 = xjbUserMapper.selectCountsixtyFiveManAndWomen();
        for(DataInfoVO people : list2){
            if(people.getSex()==0){
                infoVO.setSixtyFiveMan(people.getNumPeople());
            }else {
                infoVO.setSixtyFiveWoman(people.getNumPeople());
            }
        }
        Float num3 = (float)(infoVO.getSixtyFiveMan())/(infoVO.getSixtyFiveWoman());
        DecimalFormat dft = new DecimalFormat("0.00%");//格式化小数 ， 其实这里还可以这样写 DecimalFormat("0.00%");   这样就不用在最后输出时还要加。
        String format2 = dft.format(num3);
        infoVO.setSixtyFiveSexRatio(format2);

        //年龄老龄化比例
        Float num4 = (float)(infoVO.getSixtyFivePeople())/(infoVO.getAllPeople());
        DecimalFormat dft4 = new DecimalFormat("0.00%");
        String format4 = dft4.format(num4);
        System.out.println("------------------------------"+format4);
        infoVO.setAgingSexRatio(format4);

        //老年人与年轻人比例
        Float num5 =  (float)(infoVO.getSixtyFivePeople())/(infoVO.getAllPeople()-infoVO.getSixtyFivePeople());
        DecimalFormat dft5 = new DecimalFormat("0.00%");
        String format5 = dft5.format(num5);
        System.out.println("------------------------------"+format5);
        infoVO.setOldRatioYoung(format5);
        return infoVO;
    }
}
