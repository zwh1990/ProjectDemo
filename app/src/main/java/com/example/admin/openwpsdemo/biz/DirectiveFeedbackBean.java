package com.example.admin.openwpsdemo.biz;

import com.google.gson.annotations.SerializedName;

/**
 * @Created by zwh.
 * @description：指令反馈信息bean类
 * @date 2018/6/26 22:19
 * @邮箱：zhaowh@zgjzd.cn
 */
public class DirectiveFeedbackBean {

    //联系人
    @SerializedName("")
    private String contacts;

    //联系人电话(专线)
    @SerializedName("")
    private String contactsPhoneIn;

    //联系人电话(外线)
    @SerializedName("")
    private String contactsPhoneOut;

    //接收单位
    @SerializedName("")
    private String acceptDep;

    //反馈期限(天)
    @SerializedName("")
    private String feedbackDay;

    //工作要求
    @SerializedName("")
    private String workRequire;

    //指令类型
    @SerializedName("")
    private String directiveType;

    //转发文号
    @SerializedName("")
    private String transpondNumber;

    //是否自查
    @SerializedName("")
    private String isSelfInspection ;

    //指令状态
    @SerializedName("")
    private String directiveStatus ;

    //是否合格
    @SerializedName("")
    private String isQualified ;

    //操作
    private String operate = "详情";

    public DirectiveFeedbackBean(String contacts, String contactsPhoneIn, String contactsPhoneOut,
                                 String acceptDep, String feedbackDay, String workRequire,
                                 String directiveType, String transpondNumber, String isSelfInspection,
                                 String directiveStatus, String isQualified) {
        this.contacts = contacts;
        this.contactsPhoneIn = contactsPhoneIn;
        this.contactsPhoneOut = contactsPhoneOut;
        this.acceptDep = acceptDep;
        this.feedbackDay = feedbackDay;
        this.workRequire = workRequire;
        this.directiveType = directiveType;
        this.transpondNumber = transpondNumber;
        this.isSelfInspection = isSelfInspection;
        this.directiveStatus = directiveStatus;
        this.isQualified = isQualified;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsPhoneIn() {
        return contactsPhoneIn;
    }

    public void setContactsPhoneIn(String contactsPhoneIn) {
        this.contactsPhoneIn = contactsPhoneIn;
    }

    public String getContactsPhoneOut() {
        return contactsPhoneOut;
    }

    public void setContactsPhoneOut(String contactsPhoneOut) {
        this.contactsPhoneOut = contactsPhoneOut;
    }

    public String getAcceptDep() {
        return acceptDep;
    }

    public void setAcceptDep(String acceptDep) {
        this.acceptDep = acceptDep;
    }

    public String getFeedbackDay() {
        return feedbackDay;
    }

    public void setFeedbackDay(String feedbackDay) {
        this.feedbackDay = feedbackDay;
    }

    public String getWorkRequire() {
        return workRequire;
    }

    public void setWorkRequire(String workRequire) {
        this.workRequire = workRequire;
    }

    public String getDirectiveType() {
        return directiveType;
    }

    public void setDirectiveType(String directiveType) {
        this.directiveType = directiveType;
    }

    public String getTranspondNumber() {
        return transpondNumber;
    }

    public void setTranspondNumber(String transpondNumber) {
        this.transpondNumber = transpondNumber;
    }

    public String getIsSelfInspection() {
        return isSelfInspection;
    }

    public void setIsSelfInspection(String isSelfInspection) {
        this.isSelfInspection = isSelfInspection;
    }

    public String getDirectiveStatus() {
        return directiveStatus;
    }

    public void setDirectiveStatus(String directiveStatus) {
        this.directiveStatus = directiveStatus;
    }

    public String getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(String isQualified) {
        this.isQualified = isQualified;
    }

    public String getOperate() {
        return operate;
    }

    @Override
    public String toString() {
        return "DirectiveFeedbackBean{" +
                "contacts='" + contacts + '\'' +
                ", contactsPhoneIn='" + contactsPhoneIn + '\'' +
                ", contactsPhoneOut='" + contactsPhoneOut + '\'' +
                ", acceptDep='" + acceptDep + '\'' +
                ", feedbackDay='" + feedbackDay + '\'' +
                ", workRequire='" + workRequire + '\'' +
                ", directiveType='" + directiveType + '\'' +
                ", transpondNumber='" + transpondNumber + '\'' +
                ", isSelfInspection='" + isSelfInspection + '\'' +
                ", directiveStatus='" + directiveStatus + '\'' +
                ", isQualified='" + isQualified + '\'' +
                ", operate='" + operate + '\'' +
                '}';
    }
}
