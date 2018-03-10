package com.tydic.bo;

import java.util.List;

public class TelOperatorBO {
    private Integer id;

    private String name;

    private List<SensorBO> sensorBOList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<SensorBO> getSensorBOList() {
        return sensorBOList;
    }

    public void setSensorBOList(List<SensorBO> sensorBOList) {
        this.sensorBOList = sensorBOList;
    }

}