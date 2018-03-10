package com.tydic.po;

public class Sensor {
    private Integer id;

    private String sensorname;

    private Integer teloperatorid;

    private String nodecode;

    private String usable;

    private Integer model;

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

    public Integer getTeloperatorid() {
        return teloperatorid;
    }

    public void setTeloperatorid(Integer teloperatorid) {
        this.teloperatorid = teloperatorid;
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode == null ? null : nodecode.trim();
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable == null ? null : usable.trim();
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }
}