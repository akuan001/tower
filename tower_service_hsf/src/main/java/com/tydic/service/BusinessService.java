package com.tydic.service;

import java.util.List;
import java.util.Map;

import com.tydic.base.vo.JSONResult;
import com.tydic.bo.MenuBO;
import com.tydic.bo.NodeBO;
import com.tydic.bo.NodeParamBO;
import com.tydic.bo.SensorBO;
import com.tydic.bo.SensorDailyCunsumpBO;
import com.tydic.bo.SensorDailyCunsumpParamBO;
import com.tydic.bo.SensorParamBO;
import com.tydic.bo.SensorValuesDailyShowBO;
import com.tydic.bo.SensorValuesParamBO;
import com.tydic.bo.SensorValuesShowBO;
import com.tydic.bo.TelOperatorBO;
import com.tydic.bo.TelOperatorParamBO;

public interface BusinessService {

    public JSONResult<List<NodeBO>> queryNodeList(NodeParamBO nodeParamBO);

    public JSONResult<List<SensorBO>> querySensorList(SensorParamBO sensorParamBO);

    public JSONResult<List<TelOperatorBO>> queryTeloperatorList(TelOperatorParamBO telOperatorParamBO);

    public JSONResult<MenuBO> queryMenu();

    // 计算实时电量表
    public JSONResult<SensorValuesShowBO> queryChartSensorValueShow(SensorValuesParamBO sensorValuesParamBO);

    // 计算日电量统计表
    public JSONResult<SensorValuesDailyShowBO> queryChartSensorValueDailyShow(
            SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

    // 计算日电量统计表(有分页)
    public JSONResult<List<SensorDailyCunsumpBO>> queryChartSensorValueDailyByParam(
            SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

    public JSONResult<Map<NodeBO, Map<TelOperatorBO, Double>>> queryNodeMap(SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO);

}
