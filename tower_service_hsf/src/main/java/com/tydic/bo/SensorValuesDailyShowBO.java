package com.tydic.bo;

import java.util.List;

public class SensorValuesDailyShowBO {
    private List<String> chartDayList;
    private List<Double> chartElecDianList;
    private List<Double> chartElecLianList;
    private List<Double> chartElecYiList;
    
    private Double chartElecDianSum;
    private Double chartElecLianSum;
    private Double chartElecYiSum;
    
    private Double ElecSum;

    public List<String> getChartDayList() {
        return chartDayList;
    }

    public void setChartDayList(List<String> chartDayList) {
        this.chartDayList = chartDayList;
    }

    public List<Double> getChartElecDianList() {
        return chartElecDianList;
    }

    public void setChartElecDianList(List<Double> chartElecDianList) {
        this.chartElecDianList = chartElecDianList;
    }

    public List<Double> getChartElecLianList() {
        return chartElecLianList;
    }

    public void setChartElecLianList(List<Double> chartElecLianList) {
        this.chartElecLianList = chartElecLianList;
    }

    public List<Double> getChartElecYiList() {
        return chartElecYiList;
    }

    public void setChartElecYiList(List<Double> chartElecYiList) {
        this.chartElecYiList = chartElecYiList;
    }

    public Double getChartElecDianSum() {
        return chartElecDianSum;
    }

    public void setChartElecDianSum(Double chartElecDianSum) {
        this.chartElecDianSum = chartElecDianSum;
    }

    public Double getChartElecLianSum() {
        return chartElecLianSum;
    }

    public void setChartElecLianSum(Double chartElecLianSum) {
        this.chartElecLianSum = chartElecLianSum;
    }

    public Double getChartElecYiSum() {
        return chartElecYiSum;
    }

    public void setChartElecYiSum(Double chartElecYiSum) {
        this.chartElecYiSum = chartElecYiSum;
    }

    public Double getElecSum() {
        return ElecSum;
    }

    public void setElecSum(Double elecSum) {
        ElecSum = elecSum;
    }

}