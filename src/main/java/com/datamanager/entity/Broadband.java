package com.datamanager.entity;

import java.util.Date;

/**
 * 家宽集客数据表
 */
public class Broadband {

    //   1集团客户数
    public int groupAll;

    //    2数据专线
    public int dataLine;

    //    3语音专线
    public int voiceLine;

    //    4GPRS专线
    public int gprsLine;

    //    5电路出租
    public int rentLine;

    //    6集团短信
    public int groupMsg;

    //    7校讯通
    public int schoolLine;

    //    8家庭客户数
    public int familyAll;

    //    9一线通
    public int oneLine;

    //    10光纤到户
    public int opticalLine;

    //    11一线通新增
    public int oneAdd;

    //    12光纤到户新增
    public int opticalAdd;

    //    13提供日期
    public String summitTime;

    @Override
    public String toString() {
        return "Broadband{" +
                "groupAll=" + groupAll +
                ", dataLine=" + dataLine +
                ", voiceLine=" + voiceLine +
                ", gprsLine=" + gprsLine +
                ", rentLine=" + rentLine +
                ", groupMsg=" + groupMsg +
                ", schoolLine=" + schoolLine +
                ", familyAll=" + familyAll +
                ", oneLine=" + oneLine +
                ", opticalLine=" + opticalLine +
                ", oneAdd=" + oneAdd +
                ", opticalAdd=" + opticalAdd +
                ", summitTime=" + summitTime +
                '}';
    }

    public int getGroupAll() {
        return groupAll;
    }

    public void setGroupAll(int groupAll) {
        this.groupAll = groupAll;
    }

    public int getDataLine() {
        return dataLine;
    }

    public void setDataLine(int dataLine) {
        this.dataLine = dataLine;
    }

    public int getVoiceLine() {
        return voiceLine;
    }

    public void setVoiceLine(int voiceLine) {
        this.voiceLine = voiceLine;
    }

    public int getGprsLine() {
        return gprsLine;
    }

    public void setGprsLine(int gprsLine) {
        this.gprsLine = gprsLine;
    }

    public int getRentLine() {
        return rentLine;
    }

    public void setRentLine(int rentLine) {
        this.rentLine = rentLine;
    }

    public int getGroupMsg() {
        return groupMsg;
    }

    public void setGroupMsg(int groupMsg) {
        this.groupMsg = groupMsg;
    }

    public int getSchoolLine() {
        return schoolLine;
    }

    public void setSchoolLine(int schoolLine) {
        this.schoolLine = schoolLine;
    }

    public int getFamilyAll() {
        return familyAll;
    }

    public void setFamilyAll(int familyAll) {
        this.familyAll = familyAll;
    }

    public int getOneLine() {
        return oneLine;
    }

    public void setOneLine(int oneLine) {
        this.oneLine = oneLine;
    }

    public int getOpticalLine() {
        return opticalLine;
    }

    public void setOpticalLine(int opticalLine) {
        this.opticalLine = opticalLine;
    }

    public int getOneAdd() {
        return oneAdd;
    }

    public void setOneAdd(int oneAdd) {
        this.oneAdd = oneAdd;
    }

    public int getOpticalAdd() {
        return opticalAdd;
    }

    public void setOpticalAdd(int opticalAdd) {
        this.opticalAdd = opticalAdd;
    }

    public String getSummitTime() {
        return summitTime;
    }

    public void setSummitTime(String summitTime) {
        this.summitTime = summitTime;
    }
}
