package com.tydic.bo;

import java.util.Date;

public class SensorValuesBO {
    private Integer id;

    private String nodecode;

    private String ip;

    private Double sensor01;

    private Double sensor02;

    private Double sensor03;

    private Double sensor04;

    private Double sensor05;

    private Double sensor06;

    private Double sensor07;

    private Double sensor08;

    private Double sensor09;

    private Double sensor10;

    private Double sensor11;

    private Double sensor12;

    private Double sensor13;

    private Double sensor14;

    private Double sensor15;

    private Double sensor16;

    private Date uploadtime;

    private Date startTime;

    private Date endTime;
    
    private Integer model;
    
    private double electricity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodecode() {
        return nodecode;
    }

    public void setNodecode(String nodecode) {
        this.nodecode = nodecode == null ? null : nodecode.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Double getSensor01() {
        return sensor01;
    }

    public void setSensor01(Double sensor01) {
        this.sensor01 = sensor01;
    }

    public Double getSensor02() {
        return sensor02;
    }

    public void setSensor02(Double sensor02) {
        this.sensor02 = sensor02;
    }

    public Double getSensor03() {
        return sensor03;
    }

    public void setSensor03(Double sensor03) {
        this.sensor03 = sensor03;
    }

    public Double getSensor04() {
        return sensor04;
    }

    public void setSensor04(Double sensor04) {
        this.sensor04 = sensor04;
    }

    public Double getSensor05() {
        return sensor05;
    }

    public void setSensor05(Double sensor05) {
        this.sensor05 = sensor05;
    }

    public Double getSensor06() {
        return sensor06;
    }

    public void setSensor06(Double sensor06) {
        this.sensor06 = sensor06;
    }

    public Double getSensor07() {
        return sensor07;
    }

    public void setSensor07(Double sensor07) {
        this.sensor07 = sensor07;
    }

    public Double getSensor08() {
        return sensor08;
    }

    public void setSensor08(Double sensor08) {
        this.sensor08 = sensor08;
    }

    public Double getSensor09() {
        return sensor09;
    }

    public void setSensor09(Double sensor09) {
        this.sensor09 = sensor09;
    }

    public Double getSensor10() {
        return sensor10;
    }

    public void setSensor10(Double sensor10) {
        this.sensor10 = sensor10;
    }

    public Double getSensor11() {
        return sensor11;
    }

    public void setSensor11(Double sensor11) {
        this.sensor11 = sensor11;
    }

    public Double getSensor12() {
        return sensor12;
    }

    public void setSensor12(Double sensor12) {
        this.sensor12 = sensor12;
    }

    public Double getSensor13() {
        return sensor13;
    }

    public void setSensor13(Double sensor13) {
        this.sensor13 = sensor13;
    }

    public Double getSensor14() {
        return sensor14;
    }

    public void setSensor14(Double sensor14) {
        this.sensor14 = sensor14;
    }

    public Double getSensor15() {
        return sensor15;
    }

    public void setSensor15(Double sensor15) {
        this.sensor15 = sensor15;
    }

    public Double getSensor16() {
        return sensor16;
    }

    public void setSensor16(Double sensor16) {
        this.sensor16 = sensor16;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
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

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }
    
}