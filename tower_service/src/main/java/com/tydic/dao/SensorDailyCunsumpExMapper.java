package com.tydic.dao;

import java.util.List;

import com.tydic.base.feature.orm.mybatis.Page;
import com.tydic.bo.SensorDailyCunsumpParamBO;
import com.tydic.po.SensorDailyCunsumpEx;

public interface SensorDailyCunsumpExMapper {

    List<SensorDailyCunsumpEx> selectDensorDailyByParam(SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

    List<SensorDailyCunsumpEx> selectDensorDailySumByParam(SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

    List<SensorDailyCunsumpEx> selectByParam(Page<SensorDailyCunsumpEx> page,
            SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

    Double selectSumElCunsumpByParam(SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

    List<SensorDailyCunsumpEx> selectStatisticsByTel(SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);
    
    List<SensorDailyCunsumpEx> selectStatisticsByNode(SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);
}