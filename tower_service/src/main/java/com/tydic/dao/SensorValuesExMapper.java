package com.tydic.dao;

import java.util.List;

import com.tydic.bo.SensorValuesParamBO;
import com.tydic.po.SensorValues;

public interface SensorValuesExMapper {
    
    List<SensorValues> selectSensorValuesByParam(SensorValuesParamBO SensorValuesParamBO);
}