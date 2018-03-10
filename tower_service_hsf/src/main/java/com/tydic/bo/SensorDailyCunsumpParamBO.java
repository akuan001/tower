package com.tydic.bo;

import java.util.Date;

public class SensorDailyCunsumpParamBO {
    private String sensorname;

    private Date chargeday;

    private String nodecode;

    private Integer id;

    private Integer teloperatorid;

    private Double elcunsump;

    private Date startTime;

    private Date endTime;

    private String startTimeStr;

    private String endTimeStr;
    
    private Integer pageIndex;

    private Integer pageSize;
    
    private String calTimeStr;

    public String getSensorname() {
        return sensorname;
    }

    public void setSensorname(String sensorname) {
        this.sensorname = sensorname == null ? null : sensorname.trim();
    }

    public Date getChargeday() {
        return chargeday;
    }

    public void setChargeday(Date chargeday) {
        this.chargeday = chargeday;
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode == null ? null : nodecode.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeloperatorid() {
        return teloperatorid;
    }

    public void setTeloperatorid(Integer teloperatorid) {
        this.teloperatorid = teloperatorid;
    }

    public Double getElcunsump() {
        return elcunsump;
    }

    public void setElcunsump(Double elcunsump) {
        this.elcunsump = elcunsump;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getCalTimeStr() {
        return calTimeStr;
    }

    public void setCalTimeStr(String calTimeStr) {
        this.calTimeStr = calTimeStr;
    }

}