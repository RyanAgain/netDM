package com.datamanager.entity;

import java.util.Date;

/**
 * 网优数据表
 */
public class Optimization {

    //    GSM全天话务量
    public float gsmAllvo;

    //    GSM最忙时话务量
    public float gsmBusyvo;

    //    GSM全天流量
    public float gsmAlldata;

    //    GSM最忙时流量
    public float gsmbusydata;

    //    gms无线利用率
    public float gsmUsage;

    //    gsm接通率
    public float gsmConnect;

    //    gsm掉话率
    public float gsmDrop;

    //    LTE全天流量
    public float lteAlldata;

    //    LTE最忙时流量
    public float lteBusy;

    //    LTE接通率
    public float lteConnect;

    //    LTE切换率
    public float lteSwitch;

    //    LTE掉线率
    public float lteDrop;

    //    提供日期
    public String summitTime;

    @Override
    public String toString() {
        return "Optimization{" +
                "gsmAllvo=" + gsmAllvo +
                ", gsmBusyvo=" + gsmBusyvo +
                ", gsmAlldata=" + gsmAlldata +
                ", gsmbusydata=" + gsmbusydata +
                ", gsmUsage=" + gsmUsage +
                ", gsmConnect=" + gsmConnect +
                ", gsmDrop=" + gsmDrop +
                ", lteAlldata=" + lteAlldata +
                ", lteBusy=" + lteBusy +
                ", lteConnect=" + lteConnect +
                ", lteSwitch=" + lteSwitch +
                ", lteDrop=" + lteDrop +
                ", summitTime=" + summitTime +
                '}';
    }

    public float getGsmAllvo() {
        return gsmAllvo;
    }

    public void setGsmAllvo(float gsmAllvo) {
        this.gsmAllvo = gsmAllvo;
    }

    public float getGsmBusyvo() {
        return gsmBusyvo;
    }

    public void setGsmBusyvo(float gsmBusyvo) {
        this.gsmBusyvo = gsmBusyvo;
    }

    public float getGsmAlldata() {
        return gsmAlldata;
    }

    public void setGsmAlldata(float gsmAlldata) {
        this.gsmAlldata = gsmAlldata;
    }

    public float getGsmbusydata() {
        return gsmbusydata;
    }

    public void setGsmbusydata(float gsmbusydata) {
        this.gsmbusydata = gsmbusydata;
    }

    public float getGsmUsage() {
        return gsmUsage;
    }

    public void setGsmUsage(float gsmUsage) {
        this.gsmUsage = gsmUsage;
    }

    public float getGsmConnect() {
        return gsmConnect;
    }

    public void setGsmConnect(float gsmConnect) {
        this.gsmConnect = gsmConnect;
    }

    public float getGsmDrop() {
        return gsmDrop;
    }

    public void setGsmDrop(float gsmDrop) {
        this.gsmDrop = gsmDrop;
    }

    public float getLteAlldata() {
        return lteAlldata;
    }

    public void setLteAlldata(float lteAlldata) {
        this.lteAlldata = lteAlldata;
    }

    public float getLteBusy() {
        return lteBusy;
    }

    public void setLteBusy(float lteBusy) {
        this.lteBusy = lteBusy;
    }

    public float getLteConnect() {
        return lteConnect;
    }

    public void setLteConnect(float lteConnect) {
        this.lteConnect = lteConnect;
    }

    public float getLteSwitch() {
        return lteSwitch;
    }

    public void setLteSwitch(float lteSwitch) {
        this.lteSwitch = lteSwitch;
    }

    public float getLteDrop() {
        return lteDrop;
    }

    public void setLteDrop(float lteDrop) {
        this.lteDrop = lteDrop;
    }

    public String getSummitTime() {
        return summitTime;
    }

    public void setSummitTime(String summitTime) {
        this.summitTime = summitTime;
    }
}
