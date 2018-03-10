package com.tydic.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tydic.base.util.DateUtils;
import com.tydic.base.vo.JSONResult;
import com.tydic.bo.MenuBO;
import com.tydic.bo.SensorValuesBO;
import com.tydic.bo.SensorValuesParamBO;
import com.tydic.service.BusinessService;
import com.tydic.util.ManageUtils;
import com.tydic.vo.SensorValuesParamVO;

@Controller
@RequestMapping("/common")
public class CommonController {
    private BusinessService businessService;

    @RequestMapping("/menu")
    public MenuBO getMenu(Long selectMenuNo) {
        JSONResult<MenuBO> json = businessService.queryMenu();
        System.out.println(json.getData());
        return json.getData();
    }

    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<MenuBO> getAcct(HttpServletRequest request) {
        JSONResult<MenuBO> jsonResult = new JSONResult<MenuBO>();
        MenuBO menu = (MenuBO) ManageUtils.getSessionValue("menu");
        jsonResult.setData(menu);
        return jsonResult;
    }

    @RequestMapping(value = "/querySensorValues", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<List<SensorValuesBO>> querySensorValues(SensorValuesParamVO sensorValuesParamVO,
            HttpServletRequest request) {
        Date startTime = DateUtils.formatDate(sensorValuesParamVO.getStartTimeStr(), DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
        Date endTime = DateUtils.formatDate(sensorValuesParamVO.getEndTimeStr(), DateUtils.DATETIME_DEFAULT_FORMAT_SMALL);
        SensorValuesParamBO sensorValuesParamBO = new SensorValuesParamBO();
        sensorValuesParamBO.setStartTime(startTime);
        sensorValuesParamBO.setEndTime(endTime);
        
        
        return null;
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

}
