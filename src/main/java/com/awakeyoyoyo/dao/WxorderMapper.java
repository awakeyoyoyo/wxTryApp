package com.awakeyoyoyo.dao;

import com.awakeyoyoyo.entity.Wxorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxorderMapper {
    int deleteByPrimaryKey(Long orderNo);

    int insert(Wxorder record);

    int insertSelective(Wxorder record);

    Wxorder selectByPrimaryKey(Long orderNo);

    int updateByPrimaryKeySelective(Wxorder record);

    int updateByPrimaryKeyWithBLOBs(Wxorder record);

    int updateByPrimaryKey(Wxorder record);

    int checkOrderByUserIdOrderNo(@Param("userId") Integer userId,@Param("orderNo") Long orderNo);

    List<Wxorder> selectByStatus(Integer status);

    List<Wxorder> selectByUserId(Integer userId);

    List<Wxorder> selectByDUserId(Integer duserId);
    List<Wxorder> selectByType(Integer type);

}