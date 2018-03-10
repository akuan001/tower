package com.tydic.po;

import java.util.Date;

public class SensorDailyCunsump {
    private String nodecode;

    private Integer id;

    private String sensorname;

    private Date chargeday;

    private Integer teloperatorid;

    private Float elcunsump;

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

    public Integer getTeloperatorid() {
        return teloperatorid;
    }

    public void setTeloperatorid(Integer teloperatorid) {
        this.teloperatorid = teloperatorid;
    }

    public Float getElcunsump() {
        return elcunsump;
    }

    public void setElcunsump(Float elcunsump) {
        this.elcunsump = elcunsump;
    }
}