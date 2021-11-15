package com.xjb_villager.mapper;

import com.xjb_villager.model.entity.XjbUserEntity;
import com.xjb_villager.model.vo.DataInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 村民用户表
 * @author 图灵
 * @date 2021/01/29
 */
@Mapper
@Repository
public interface XjbUserMapper {

    /**
     * [新增]
     * @author 图灵
     * @date 2021/01/29
     **/
    int insert(XjbUserEntity xjbUser);

    /**
     * [刪除]
     * @author 图灵
     * @date 2021/01/29
     **/
    int delete(int id);

    /**
     * [更新]
     * @author 图灵
     * @date 2021/01/29
     **/
    int update(XjbUserEntity xjbUser);

    /**
     * [查询] 根据主键 id 查询
     * @author 图灵
     * @date 2021/01/29
     **/
    XjbUserEntity load(int id);

    /**
     * [查询] 分页查询
     * @author 图灵
     * @date 2021/01/29
     **/
    List<XjbUserEntity> pageList(int offset, int pagesize);

    /**
     * [查询] 分页查询 count
     * @author 图灵
     * @date 2021/01/29
     **/
    int pageListCount(int offset,int pagesize);

    List<XjbUserEntity> findUserList();

    int pageListCount();

    List<DataInfoVO>  selectCountManAndWomen();

    List<DataInfoVO>  selectCountsixtyFiveManAndWomen();

    int selectCountsixtyFivePeople();


}
