package com.tydic.dao;

import com.tydic.po.TelOperator;
import com.tydic.po.TelOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TelOperatorMapper extends TelOperatorExMapper {
    int countByExample(TelOperatorExample example);

    int deleteByExample(TelOperatorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TelOperator record);

    int insertSelective(TelOperator record);

    List<TelOperator> selectByExample(TelOperatorExample example);

    TelOperator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TelOperator record, @Param("example") TelOperatorExample example);

    int updateByExample(@Param("record") TelOperator record, @Param("example") TelOperatorExample example);

    int updateByPrimaryKeySelective(TelOperator record);

    int updateByPrimaryKey(TelOperator record);
}