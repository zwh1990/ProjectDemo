package com.example.admin.openwpsdemo.biz;

import java.util.List;

/**
 * Created by harbor on 2017/7/26.
 */

public class AnalysisChartBean {
    private String qTitle; //题目
    private List<String> qOption;//选项  X轴
    private List<String> qAnswer; //答案 Y轴
    private List<String> qPercetnum; // 百分比

    private int color;
    private String unit = "";


    public void setqPercetnum(List<String> qPercetnum) {
        this.qPercetnum = qPercetnum;
    }

    public List<String> getqPercetnum() {
        return qPercetnum;
    }

    public List<String> getqOption() {
        return qOption;
    }

    public void setqOption(List<String> qOption) {
        this.qOption = qOption;
    }

    public List<String> getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(List<String> qAnswer) {
        this.qAnswer = qAnswer;
    }

    public String getqTitle() {

        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "AnalysisChartBean{" +
                "qTitle='" + qTitle + '\'' +
                ", qOption=" + qOption +
                ", qAnswer=" + qAnswer +
                ", qPercetnum=" + qPercetnum +
                ", color=" + color +
                ", unit='" + unit + '\'' +
                '}';
    }
}
