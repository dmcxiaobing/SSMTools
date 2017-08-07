package com.qq986945193.ssmtools.generator.mapper;

import com.qq986945193.ssmtools.generator.po.MybatisOrders;
import com.qq986945193.ssmtools.generator.po.MybatisOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MybatisOrdersMapper {
    int countByExample(MybatisOrdersExample example);

    int deleteByExample(MybatisOrdersExample example);

    int insert(MybatisOrders record);

    int insertSelective(MybatisOrders record);

    List<MybatisOrders> selectByExample(MybatisOrdersExample example);

    int updateByExampleSelective(@Param("record") MybatisOrders record, @Param("example") MybatisOrdersExample example);

    int updateByExample(@Param("record") MybatisOrders record, @Param("example") MybatisOrdersExample example);
}