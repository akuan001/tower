package com.tydic.dao;

import com.tydic.po.SensorValues;
import com.tydic.po.SensorValuesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorValuesMapper extends SensorValuesExMapper {
    int countByExample(SensorValuesExample example);

    int deleteByExample(SensorValuesExample example);

    int insert(SensorValues record);

    int insertSelective(SensorValues record);

    List<SensorValues> selectByExample(SensorValuesExample example);

    int updateByExampleSelective(@Param("record") SensorValues record, @Param("example") SensorValuesExample example);

    int updateByExample(@Param("record") SensorValues record, @Param("example") SensorValuesExample example);
}