package com.tydic.dao;

import com.tydic.po.SensorDailyCunsump;
import com.tydic.po.SensorDailyCunsumpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorDailyCunsumpMapper extends SensorDailyCunsumpExMapper {
    int countByExample(SensorDailyCunsumpExample example);

    int deleteByExample(SensorDailyCunsumpExample example);

    int deleteByPrimaryKey(String nodecode);

    int insert(SensorDailyCunsump record);

    int insertSelective(SensorDailyCunsump record);

    List<SensorDailyCunsump> selectByExample(SensorDailyCunsumpExample example);

    SensorDailyCunsump selectByPrimaryKey(String nodecode);

    int updateByExampleSelective(@Param("record") SensorDailyCunsump record, @Param("example") SensorDailyCunsumpExample example);

    int updateByExample(@Param("record") SensorDailyCunsump record, @Param("example") SensorDailyCunsumpExample example);

    int updateByPrimaryKeySelective(SensorDailyCunsump record);

    int updateByPrimaryKey(SensorDailyCunsump record);
}