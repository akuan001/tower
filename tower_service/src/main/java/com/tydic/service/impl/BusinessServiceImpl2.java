//package com.tydic.service.impl;
//
//import java.lang.reflect.Method;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.BeanUtils;
//
//import com.tydic.base.feature.orm.mybatis.Page;
//import com.tydic.base.util.DateUtils;
//import com.tydic.base.vo.JSONResult;
//import com.tydic.bo.MenuBO;
//import com.tydic.bo.NodeBO;
//import com.tydic.bo.NodeParamBO;
//import com.tydic.bo.SensorBO;
//import com.tydic.bo.SensorValuesParamBO;
//import com.tydic.bo.SensorValuesShowBO;
//import com.tydic.bo.TelOperatorBO;
//import com.tydic.bo.TelOperatorParamBO;
//import com.tydic.dao.NodeMapper;
//import com.tydic.dao.SensorMapper;
//import com.tydic.dao.SensorValuesMapper;
//import com.tydic.dao.TelOperatorMapper;
//import com.tydic.po.Node;
//import com.tydic.po.NodeEx;
//import com.tydic.po.NodeExample;
//import com.tydic.po.Sensor;
//import com.tydic.po.SensorExample;
//import com.tydic.po.SensorValues;
//import com.tydic.po.SensorValuesExample;
//import com.tydic.po.TelOperator;
//import com.tydic.service.BusinessService;
//
//public class BusinessServiceImpl2 implements BusinessService {
//    private final Log logger = LogFactory.getLog(this.getClass());
//    private NodeMapper nodeMapper;
//    private SensorMapper sensorMapper;
//    private TelOperatorMapper telOperatorMapper;
//    private SensorValuesMapper sensorValuesMapper;
//
//    @Override
//    public JSONResult<List<NodeBO>> queryNodeList(NodeParamBO nodeParamBO) {
//        logger.info("service:queryNodeList--------------------start");
//        JSONResult<List<NodeBO>> json = new JSONResult<List<NodeBO>>();
//        List<NodeBO> nodeBOList = new ArrayList<NodeBO>();
//        Page<NodeEx> page = new Page<NodeEx>(nodeParamBO.getPageIndex(), nodeParamBO.getPageSize());
//        List<NodeEx> nodeExList = nodeMapper.selectByParam(page, nodeParamBO);
//        for (NodeEx nodeEx : nodeExList) {
//            NodeBO nodeBO = new NodeBO();
//            BeanUtils.copyProperties(nodeEx, nodeBO);
//            nodeBOList.add(nodeBO);
//        }
//        json.setData(nodeBOList);
//        logger.info("service:queryNodeList--------------------end");
//        return json;
//    }
//
//    @Override
//    public JSONResult<MenuBO> queryMenu() {
//        JSONResult<MenuBO> json = new JSONResult<>();
//        MenuBO menuBO = new MenuBO();
//        List<NodeBO> nodeBOList = new ArrayList<NodeBO>();
//        NodeExample example = new NodeExample();
//
//        // 查询总共有多少基站节点
//        List<Node> nodeList = nodeMapper.selectByExample(example);
//        for (Node node : nodeList) {
//            NodeBO nodeBO = new NodeBO();
//            TelOperatorParamBO telOperatorParamBO = new TelOperatorParamBO();
//            telOperatorParamBO.setNodecode(node.getNodecode());
//
//            // 查询指定基站节点下有多少运营商
//            List<TelOperator> telOperatorList = telOperatorMapper.selectTelOperatorByParam(telOperatorParamBO);
//            List<TelOperatorBO> telOperatorBOList = new ArrayList<TelOperatorBO>();
//            for (TelOperator telOperator : telOperatorList) {
//                TelOperatorBO telOperatorBO = new TelOperatorBO();
//                SensorExample sensorExample = new SensorExample();
//                sensorExample.createCriteria().andNodecodeEqualTo(node.getNodecode())
//                        .andTeloperatoridEqualTo(telOperator.getId());
//
//                // 查询指定基站节点下的指定运营商有多少传感器
//                List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
//                List<SensorBO> sensorBOList = new ArrayList<SensorBO>();
//                for (Sensor sensor : sensorList) {
//                    SensorBO sensorBO = new SensorBO();
//                    BeanUtils.copyProperties(sensor, sensorBO);
//                    sensorBOList.add(sensorBO);
//                }
//                telOperatorBO.setSensorBOList(sensorBOList);
//                BeanUtils.copyProperties(telOperator, telOperatorBO);
//                telOperatorBOList.add(telOperatorBO);
//            }
//            nodeBO.setTelOperatorBOList(telOperatorBOList);
//            BeanUtils.copyProperties(node, nodeBO);
//            nodeBOList.add(nodeBO);
//        }
//        menuBO.setNodeBOList(nodeBOList);
//        json.setData(menuBO);
//        return json;
//    }
//
//    @Override
//    public JSONResult<SensorValuesShowBO> queryChartSensorValueShow(SensorValuesParamBO sensorValuesParamBO) {
//        JSONResult<SensorValuesShowBO> json = new JSONResult<SensorValuesShowBO>();
//        SensorValuesShowBO sensorValuesShowBO = new SensorValuesShowBO();
//        List<String> chartHourList = new ArrayList<String>();
//        List<Double> chartElectricityList = new ArrayList<Double>();
//        
//        SensorValuesExample example = new SensorValuesExample();
//        example.createCriteria()
//                .andUploadtimeBetween(sensorValuesParamBO.getStartTime(), sensorValuesParamBO.getEndTime())
//                .andNodecodeEqualTo(sensorValuesParamBO.getNodecode());
//        example.setOrderByClause("UploadTime");
//        List<SensorValues> sensorValuesList = sensorValuesMapper.selectByExample(example);
//
//        // 查询当前传感器的model
//        SensorExample sensorExample = new SensorExample();
//        sensorExample.createCriteria().andNodecodeEqualTo(sensorValuesParamBO.getNodecode())
//                .andSensornameEqualTo(sensorValuesParamBO.getSensorname());
//        List<Sensor> sensorList = sensorMapper.selectByExample(sensorExample);
//        Integer model = sensorList.get(0).getModel();
//        BigDecimal b1 = new BigDecimal(Double.toString(model));
//        BigDecimal b2 = new BigDecimal(Double.toString(5));
//        BigDecimal b3 = new BigDecimal(Double.toString(54));
//        for (SensorValues sensorValues : sensorValuesList) {
//            Double sensorValue = (Double)getFieldValueByName(sensorValuesParamBO.getSensorname(), sensorValues);
//            BigDecimal b4 = new BigDecimal(Double.toString(sensorValue));
//            BigDecimal power = b1.multiply(b4).divide(b2).multiply(b3);
//            
//            Date startTime = sensorValues.getUploadtime();
//            String endTimeStr = DateUtils.getDateFormat(startTime, DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
//            String startTimeStr = endTimeStr.substring(0, endTimeStr.indexOf(" ")) + " 00:00:00:000";
//            BigDecimal hour = DateUtils.getHourBetwen(startTimeStr, endTimeStr, DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
//            double electricity = power.multiply(hour).doubleValue();
//            
//            chartHourList.add(endTimeStr);
//            chartElectricityList.add(electricity);
//        }
//        sensorValuesShowBO.setChartHourList(chartHourList);
//        sensorValuesShowBO.setChartElectricityList(chartElectricityList);
//        json.setData(sensorValuesShowBO);
//        return json;
//    }
//
//    public void setNodeMapper(NodeMapper nodeMapper) {
//        this.nodeMapper = nodeMapper;
//    }
//
//    public void setSensorMapper(SensorMapper sensorMapper) {
//        this.sensorMapper = sensorMapper;
//    }
//
//    public void setTelOperatorMapper(TelOperatorMapper telOperatorMapper) {
//        this.telOperatorMapper = telOperatorMapper;
//    }
//
//    public void setSensorValuesMapper(SensorValuesMapper sensorValuesMapper) {
//        this.sensorValuesMapper = sensorValuesMapper;
//    }
//    
//    private Object getFieldValueByName(String fieldName, Object o) {  
//        try {    
//            String firstLetter = fieldName.substring(0, 1).toUpperCase();    
//            String getter = "get" + firstLetter + fieldName.substring(1);    
//            Method method = o.getClass().getMethod(getter, new Class[] {});    
//            Object value = method.invoke(o, new Object[] {});    
//            return value;    
//        } catch (Exception e) {    
//            return null;    
//        }    
//    } 
//
//}
