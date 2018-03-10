package com.tydic.bo;

import java.util.List;

public class SensorValuesShowBO {
    private List<String> chartHourList;
    private List<Double> chartElectricityList;

    public List<String> getChartHourList() {
        return chartHourList;
    }

    public void setChartHourList(List<String> chartHourList) {
        this.chartHourList = chartHourList;
    }

    public List<Double> getChartElectricityList() {
        return chartElectricityList;
    }

    public void setChartElectricityList(List<Double> chartElectricityList) {
        this.chartElectricityList = chartElectricityList;
    }

}