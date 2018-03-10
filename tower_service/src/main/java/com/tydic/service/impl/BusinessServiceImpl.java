package com.tydic.service.impl;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.tydic.base.feature.orm.mybatis.Page;
import com.tydic.base.util.DateUtils;
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
import com.tydic.dao.NodeMapper;
import com.tydic.dao.SensorDailyCunsumpMapper;
import com.tydic.dao.SensorMapper;
import com.tydic.dao.SensorValuesMapper;
import com.tydic.dao.TelOperatorMapper;
import com.tydic.po.Node;
import com.tydic.po.NodeEx;
import com.tydic.po.NodeExample;
import com.tydic.po.Sensor;
import com.tydic.po.SensorDailyCunsumpEx;
import com.tydic.po.SensorExample;
import com.tydic.po.SensorValues;
import com.tydic.po.SensorValuesExample;
import com.tydic.po.TelOperator;
import com.tydic.po.TelOperatorExample;
import com.tydic.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private NodeMapper nodeMapper;
    private SensorMapper sensorMapper;
    private TelOperatorMapper telOperatorMapper;
    private SensorValuesMapper sensorValuesMapper;
    private SensorDailyCunsumpMapper sensorDailyCunsumpMapper;

    @Override
    public JSONResult<List<NodeBO>> queryNodeList(NodeParamBO nodeParamBO) {
        logger.info("service:queryNodeList--------------------start");
        JSONResult<List<NodeBO>> json = new JSONResult<List<NodeBO>>();
        List<NodeBO> nodeBOList = new ArrayList<NodeBO>();
        Page<NodeEx> page = new Page<NodeEx>(nodeParamBO.getPageIndex(), nodeParamBO.getPageSize());
        List<NodeEx> nodeExList = nodeMapper.selectByParam(page, nodeParamBO);
        for (NodeEx nodeEx : nodeExList) {
            NodeBO nodeBO = new NodeBO();
            BeanUtils.copyProperties(nodeEx, nodeBO);
            nodeBOList.add(nodeBO);
        }
        json.setData(nodeBOList);
        logger.info("service:queryNodeList--------------------end");
        return json;
    }

    @Override
    public JSONResult<List<SensorBO>> querySensorList(SensorParamBO sensorParamBO) {
        JSONResult<List<SensorBO>> json = new JSONResult<List<SensorBO>>();
        List<SensorBO> sensorBOList = new ArrayList<SensorBO>();
        SensorExample example = new SensorExample();
        example.createCriteria().andUsableEqualTo("Y").andSensornameEqualTo(sensorParamBO.getSensorname());
        List<Sensor> sensorList = sensorMapper.selectByExample(example);
        for (Sensor sensor : sensorList) {
            SensorBO sensorBO = new SensorBO();
            BeanUtils.copyProperties(sensor, sensorBO);
            sensorBOList.add(sensorBO);
        }
        json.setData(sensorBOList);
        return json;
    }

    @Override
    public JSONResult<List<TelOperatorBO>> queryTeloperatorList(TelOperatorParamBO telOperatorParamBO) {
        JSONResult<List<TelOperatorBO>> json = new JSONResult<List<TelOperatorBO>>();
        List<TelOperatorBO> telOperatorBOList = new ArrayList<TelOperatorBO>();
        TelOperatorExample example = new TelOperatorExample();
        example.createCriteria().andIdEqualTo(telOperatorParamBO.getTeloperatorId());
        List<TelOperator> telOperatorList = telOperatorMapper.selectByExample(example);
        for (TelOperator telOperator : telOperatorList) {
            TelOperatorBO telOperatorBO = new TelOperatorBO();
            BeanUtils.copyProperties(telOperator, telOperatorBO);
            telOperatorBOList.add(telOperatorBO);
        }
        json.setData(telOperatorBOList);
        return json;
    }

    @Override
    public JSONResult<MenuBO> queryMenu() {
        JSONResult<MenuBO> json = new JSONResult<>();
        MenuBO menuBO = new MenuBO();
        List<NodeBO> nodeBOList = new ArrayList<NodeBO>();
        NodeExample example = new NodeExample();

        // 查询总共有多少基站节点
        List<Node> nodeList = nodeMapper.selectByExample(example);
        for (Node node : nodeList) {
            NodeBO nodeBO = new NodeBO();
            TelOperatorParamBO telOperatorParamBO = new TelOperatorParamBO();
            telOperatorParamBO.setNodecode(node.getNodecode());

            // 查询指定基站节点下有多少运营商
            List<TelOperator> telOperatorList = telOperatorMapper.selectTelOperatorByParam(telOperatorParamBO);
            List<TelOperatorBO> telOperatorBOList = new ArrayList<TelOperatorBO>();
            for (TelOperator telOperator : telOperatorList) {
                TelOperatorBO telOperatorBO = new TelOperatorBO();
                SensorExample sensorExample = new SensorExample();
                sensorExample.createCriteria().andUsableEqualTo("Y").andNodecodeEqualTo(node.getNodecode())
                        .andTeloperatoridEqualTo(telOperator.getId());

                // 查询指定基站节点下的指定运营商有多少传感器
                List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
                List<SensorBO> sensorBOList = new ArrayList<SensorBO>();
                for (Sensor sensor : sensorList) {
                    SensorBO sensorBO = new SensorBO();
                    BeanUtils.copyProperties(sensor, sensorBO);
                    sensorBOList.add(sensorBO);
                }
                telOperatorBO.setSensorBOList(sensorBOList);
                BeanUtils.copyProperties(telOperator, telOperatorBO);
                telOperatorBOList.add(telOperatorBO);
            }
            nodeBO.setTelOperatorBOList(telOperatorBOList);
            BeanUtils.copyProperties(node, nodeBO);
            nodeBOList.add(nodeBO);
        }
        menuBO.setNodeBOList(nodeBOList);
        json.setData(menuBO);
        return json;
    }

    @Override
    public JSONResult<SensorValuesShowBO> queryChartSensorValueShow(SensorValuesParamBO sensorValuesParamBO) {
        JSONResult<SensorValuesShowBO> json = new JSONResult<SensorValuesShowBO>();
        SensorValuesShowBO sensorValuesShowBO = new SensorValuesShowBO();
        List<String> chartHourList = new ArrayList<String>();
        List<Double> chartElectricityList = new ArrayList<Double>();

        SensorValuesExample example = new SensorValuesExample();
        example.createCriteria()
                .andUploadtimeBetween(sensorValuesParamBO.getStartTime(), sensorValuesParamBO.getEndTime())
                .andNodecodeEqualTo(sensorValuesParamBO.getNodecode());
        example.setOrderByClause("UploadTime");
        List<SensorValues> sensorValuesList = sensorValuesMapper.selectByExample(example);

        // 查询当前传感器的model
        SensorExample sensorExample = new SensorExample();
        sensorExample.createCriteria().andUsableEqualTo("Y").andNodecodeEqualTo(sensorValuesParamBO.getNodecode())
                .andSensornameEqualTo(sensorValuesParamBO.getSensorname());
        List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
        Integer model = sensorList.get(0).getModel();
        BigDecimal b1 = new BigDecimal(Double.toString(model));
        BigDecimal b2 = new BigDecimal(Double.toString(5));
        BigDecimal b3 = new BigDecimal(Double.toString(54));
        String tempHourStr = "00";
        int tempHour = 0;
        boolean nextHourFlag = true;
        double electricitySum = 0;
        String startTimeStr = "";
        DecimalFormat df=new DecimalFormat(".##");  
        for (int i = 0; i < sensorValuesList.size(); i++) {
            SensorValues sensorValues = sensorValuesList.get(i);
            Date uploadtime = sensorValues.getUploadtime();
            if (i == 0) {
                startTimeStr = DateUtils.getDateFormat(uploadtime, DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
                tempHourStr = startTimeStr.substring(startTimeStr.indexOf(" ") + 1, startTimeStr.indexOf(":"));
                tempHour = Integer.parseInt(tempHourStr);
                continue;
            }
            
            String endTimeStr = DateUtils.getDateFormat(uploadtime, DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
            BigDecimal hour = DateUtils.getHourBetwen(startTimeStr, endTimeStr,
                    DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
            startTimeStr = endTimeStr;
            
            Double sensorValue = (Double) getFieldValueByName(sensorValuesParamBO.getSensorname(), sensorValues);
            BigDecimal b4 = new BigDecimal(Double.toString(sensorValue));
            BigDecimal power = b1.multiply(b4).divide(b2).multiply(b3);
            BigDecimal electricitySumTemp = new BigDecimal(electricitySum);
            electricitySum = power.multiply(hour).add(electricitySumTemp).doubleValue();
            String hourStr = endTimeStr.substring(endTimeStr.indexOf(" ") + 1, endTimeStr.indexOf(":"));
            if (nextHourFlag && hourStr.equals(tempHourStr)) {
                chartHourList.add(hourStr);
                chartElectricityList.add(Double.parseDouble(df.format(electricitySum)));

                tempHour = tempHour + 1;
                if (tempHour < 10) {
                    tempHourStr = "0" + tempHour;
                } else {
                    tempHourStr = tempHour + "";
                }
                nextHourFlag = false;
            } else {
                nextHourFlag = true;
            }

        }
        sensorValuesShowBO.setChartHourList(chartHourList);
        sensorValuesShowBO.setChartElectricityList(chartElectricityList);
        json.setData(sensorValuesShowBO);
        return json;
    }

    @Override
    public JSONResult<SensorValuesDailyShowBO> queryChartSensorValueDailyShow(
            SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO) {
        JSONResult<SensorValuesDailyShowBO> json = new JSONResult<SensorValuesDailyShowBO>();
        SensorValuesDailyShowBO sensorValuesDailyShowBO = new SensorValuesDailyShowBO();
        List<String> chartDayList = new ArrayList<String>();
        List<Double> chartElecDianList = new ArrayList<Double>();
        List<Double> chartElecLianList = new ArrayList<Double>();
        List<Double> chartElecYiList = new ArrayList<Double>();

        List<SensorDailyCunsumpEx> sensorValuesExList = sensorDailyCunsumpMapper
                .selectDensorDailyByParam(sensorDailyCunsumpParamBO);
        String tempStr = "";
        for (SensorDailyCunsumpEx sunsorDailyCunsumpEx : sensorValuesExList) {
            String chargeDayStr = DateUtils.getDateFormat(sunsorDailyCunsumpEx.getChargeday(),
                    DateUtils.DATE_DEFAULT_FORMAT);
            BigDecimal sumElectTemp = new BigDecimal(Double.toString(sunsorDailyCunsumpEx.getSumelect()));
            double sumElect = sumElectTemp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (!tempStr.equals(chargeDayStr)) {
                chartDayList.add(chargeDayStr);
                tempStr = chargeDayStr;
            }
            if (sunsorDailyCunsumpEx.getTeloperatorid() == 1) {
                chartElecDianList.add(sumElect);
            } else if (sunsorDailyCunsumpEx.getTeloperatorid() == 2) {
                chartElecLianList.add(sumElect);
            } else if (sunsorDailyCunsumpEx.getTeloperatorid() == 3) {
                chartElecYiList.add(sumElect);
            }
        }
        sensorValuesDailyShowBO.setChartDayList(chartDayList);
        sensorValuesDailyShowBO.setChartElecDianList(chartElecDianList);
        sensorValuesDailyShowBO.setChartElecLianList(chartElecLianList);
        sensorValuesDailyShowBO.setChartElecYiList(chartElecYiList);

        // 计算个运营商总电量
        List<SensorDailyCunsumpEx> sensorValuesExSumList = sensorDailyCunsumpMapper
                .selectDensorDailySumByParam(sensorDailyCunsumpParamBO);
        for (SensorDailyCunsumpEx sunsorDailyCunsumpEx : sensorValuesExSumList) {
            BigDecimal sumElectTemp = new BigDecimal(Double.toString(sunsorDailyCunsumpEx.getSumelect()));
            double sumElect = sumElectTemp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (sunsorDailyCunsumpEx.getTeloperatorid() == 1) {
                sensorValuesDailyShowBO.setChartElecDianSum(sumElect);
            } else if (sunsorDailyCunsumpEx.getTeloperatorid() == 2) {
                sensorValuesDailyShowBO.setChartElecLianSum(sumElect);
            } else if (sunsorDailyCunsumpEx.getTeloperatorid() == 3) {
                sensorValuesDailyShowBO.setChartElecYiSum(sumElect);
            }
        }

        // 总量
        Double sumElcList = sensorDailyCunsumpMapper.selectSumElCunsumpByParam(sensorDailyCunsumpParamBO);
        BigDecimal elcunsump = new BigDecimal(Double.toString(sumElcList == null ? 0.00 : sumElcList));
        double sumElect = elcunsump.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        sensorValuesDailyShowBO.setElecSum(sumElect);
        json.setData(sensorValuesDailyShowBO);
        return json;
    }

    @Override
    public JSONResult<List<SensorDailyCunsumpBO>> queryChartSensorValueDailyByParam(
            SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO) {
        JSONResult<List<SensorDailyCunsumpBO>> json = new JSONResult<List<SensorDailyCunsumpBO>>();
        List<SensorDailyCunsumpBO> sensorDailyCunsumpBOList = new ArrayList<SensorDailyCunsumpBO>();

        Page<SensorDailyCunsumpEx> page = new Page<SensorDailyCunsumpEx>(sensorDailyCunsumpParamBO.getPageIndex(),
                sensorDailyCunsumpParamBO.getPageSize());
        List<SensorDailyCunsumpEx> productExList = sensorDailyCunsumpMapper.selectByParam(page,
                sensorDailyCunsumpParamBO);
        for (SensorDailyCunsumpEx sensorDailyCunsumpEx : productExList) {
            SensorDailyCunsumpBO sensorDailyCunsumpBO = new SensorDailyCunsumpBO();
            BeanUtils.copyProperties(sensorDailyCunsumpEx, sensorDailyCunsumpBO);
            BigDecimal elcunsump = new BigDecimal(Double.toString(sensorDailyCunsumpBO.getElcunsump()));
            double sumElect = elcunsump.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            sensorDailyCunsumpBO.setElcunsump(sumElect);
            sensorDailyCunsumpBOList.add(sensorDailyCunsumpBO);
        }
        json.setData(sensorDailyCunsumpBOList);
        json.setRecordsTotal(page.getTotalCount());
        json.setRecordsFiltered(page.getTotalCount());
        return json;
    }

    @Override
    public JSONResult<Map<NodeBO, Map<TelOperatorBO, Double>>> queryNodeMap(
            SensorDailyCunsumpParamBO sensorDailyCunsumpParamBO) {
        JSONResult<Map<NodeBO, Map<TelOperatorBO, Double>>> json = new JSONResult<Map<NodeBO, Map<TelOperatorBO, Double>>>();
        Map<NodeBO, Map<TelOperatorBO, Double>> nodeMap = new LinkedHashMap<NodeBO, Map<TelOperatorBO, Double>>();
        List<SensorDailyCunsumpEx> nodeList = sensorDailyCunsumpMapper
                .selectStatisticsByNode(sensorDailyCunsumpParamBO);
        for (SensorDailyCunsumpEx sensorNode : nodeList) {
            NodeBO node = new NodeBO();
            node.setNodecode(sensorNode.getNodecode());
            node.setNodename(sensorNode.getNodename());
            Map<TelOperatorBO, Double> telMap = new LinkedHashMap<TelOperatorBO, Double>();
            sensorDailyCunsumpParamBO.setNodecode(sensorNode.getNodecode());
            List<SensorDailyCunsumpEx> sensorDailyCunsumpExList = sensorDailyCunsumpMapper
                    .selectStatisticsByTel(sensorDailyCunsumpParamBO);
            for (SensorDailyCunsumpEx sensorDailyCunsumpEx : sensorDailyCunsumpExList) {
                TelOperatorBO telOperatorBO = new TelOperatorBO();
                telOperatorBO.setId(sensorDailyCunsumpEx.getTeloperatorid());
                telOperatorBO.setName(sensorDailyCunsumpEx.getTeloperatorname());
                BigDecimal sumElectTemp = new BigDecimal(Double.toString(sensorDailyCunsumpEx.getSumelect()));
                double sumElect = sumElectTemp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                telMap.put(telOperatorBO, sumElect);
            }
            nodeMap.put(node, telMap);
        }
        json.setData(nodeMap);
        return json;
    }

    public void setNodeMapper(NodeMapper nodeMapper) {
        this.nodeMapper = nodeMapper;
    }

    public void setSensorMapper(SensorMapper sensorMapper) {
        this.sensorMapper = sensorMapper;
    }

    public void setTelOperatorMapper(TelOperatorMapper telOperatorMapper) {
        this.telOperatorMapper = telOperatorMapper;
    }

    public void setSensorValuesMapper(SensorValuesMapper sensorValuesMapper) {
        this.sensorValuesMapper = sensorValuesMapper;
    }

    public void setSensorDailyCunsumpMapper(SensorDailyCunsumpMapper sensorDailyCunsumpMapper) {
        this.sensorDailyCunsumpMapper = sensorDailyCunsumpMapper;
    }

    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

}
