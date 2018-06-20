package com.datamanager.entity;

import java.util.Date;

/**
 * 核心提供表格
 */
public class Core {

    //    GSM登记数
    public float gsmNum;

    //    LTE登记数
    public float lteNum;

    //    Volte登记数
    public float volteNum;

    //    Volte话务量
    public float volteErl;

    //    4G驻留比
    public float lteRatio;

    //    提供日期
    public String summitTime;

    @Override
    public String toString() {
        return "Core{" +
                "gsmNum=" + gsmNum +
                ", lteNum=" + lteNum +
                ", volteNum=" + volteNum +
                ", volteErl=" + volteErl +
                ", lteRatio=" + lteRatio +
                ", summitTime=" + summitTime +
                '}';
    }

    public float getGsmNum() {
        return gsmNum;
    }

    public void setGsmNum(float gsmNum) {
        this.gsmNum = gsmNum;
    }

    public float getLteNum() {
        return lteNum;
    }

    public void setLteNum(float lteNum) {
        this.lteNum = lteNum;
    }

    public float getVolteNum() {
        return volteNum;
    }

    public void setVolteNum(float volteNum) {
        this.volteNum = volteNum;
    }

    public float getVolteErl() {
        return volteErl;
    }

    public void setVolteErl(float volteErl) {
        this.volteErl = volteErl;
    }

    public float getLteRatio() {
        return lteRatio;
    }

    public void setLteRatio(float lteRatio) {
        this.lteRatio = lteRatio;
    }

    public String getSummitTime() {
        return summitTime;
    }

    public void setSummitTime(String summitTime) {
        this.summitTime = summitTime;
    }
}
