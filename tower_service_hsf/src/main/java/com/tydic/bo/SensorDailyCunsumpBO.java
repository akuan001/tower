package com.tydic.bo;

import java.util.Date;

public class SensorDailyCunsumpBO {
    private String sensorname;

    private Date chargeday;
    
    private String chargedayshow;

    private String nodecode;

    private Integer id;

    private Integer teloperatorid;

    private Double elcunsump;
    
    private String teloperatorname;
    
    private String nodename;

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

    public String getTeloperatorname() {
        return teloperatorname;
    }

    public void setTeloperatorname(String teloperatorname) {
        this.teloperatorname = teloperatorname;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getChargedayshow() {
        return chargedayshow;
    }

    public void setChargedayshow(String chargedayshow) {
        this.chargedayshow = chargedayshow;
    }
    
}