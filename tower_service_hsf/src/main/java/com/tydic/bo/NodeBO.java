package com.tydic.bo;

import java.util.List;

public class NodeBO {
    private String nodecode;

    private Integer id;

    private String nodename;

    private String city;

    private List<TelOperatorBO> telOperatorBOList;

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

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename == null ? null : nodename.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public List<TelOperatorBO> getTelOperatorBOList() {
        return telOperatorBOList;
    }

    public void setTelOperatorBOList(List<TelOperatorBO> telOperatorBOList) {
        this.telOperatorBOList = telOperatorBOList;
    }
}