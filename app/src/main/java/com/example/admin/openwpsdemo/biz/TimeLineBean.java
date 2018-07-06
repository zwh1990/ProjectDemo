package com.example.admin.openwpsdemo.biz;

import com.google.gson.annotations.SerializedName;

/**
 * @Created by zwh.
 * @description：时间轴bean
 * @date 2018/5/24 14:42
 * @邮箱：zhaowh@zgjzd.cn
 */

public class TimeLineBean {

    //进展名称
    @SerializedName("")
    private String progressName;

    //进展时间
    @SerializedName("")
    private String progressTime;

    //承办人
    @SerializedName("")
    private String progressPerson;

    //进展过程
    @SerializedName("")
    private String progress;


    public TimeLineBean(String progressName, String progressTime,
                        String progressPerson, String progress) {
        this.progressName = progressName;
        this.progressTime = progressTime;
        this.progressPerson = progressPerson;
        this.progress = progress;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    public String getProgressTime() {
        return progressTime;
    }

    public void setProgressTime(String progressTime) {
        this.progressTime = progressTime;
    }

    public String getProgressPerson() {
        return progressPerson;
    }

    public void setProgressPerson(String progressPerson) {
        this.progressPerson = progressPerson;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "TimeLineBean{" +
                "progressName='" + progressName + '\'' +
                ", progressTime='" + progressTime + '\'' +
                ", progressPerson='" + progressPerson + '\'' +
                ", progress='" + progress + '\'' +
                '}';
    }
}
