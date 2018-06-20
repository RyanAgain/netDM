package com.datamanager.entity;

import java.util.Date;

/**
 * 无线提供表格
 */
public class Wireless {

    //    Gsm基站数
    public int gsmAll;

    //    Gsm载波数
    public int gsmWave;

    //    Gsm未恢复
    public int gsmDead;

    //    直放站数
    public int rsAll;

    //    直放站未恢复
    public int rsDead;

    //    Lte基站数
    public int lteAll;

    //    Lte载波数
    public int lteWave;

    //    Lte未恢复数
    public int lteDead;

    //    wlanac个数
    public int wlanAc;

    //    wlan热点数
    public int wlanHot;

    //    wlanap数
    public int wlanAp;

    //    wlan总流量
    public float wlanAllvo;

    //    ap退服率
    public float wlanApdead;

    //    ap下线率
    public float wlanApdrop;

    //    数据提供日期
    public String summitTime;

    @Override
    public String toString() {
        return "Wireless{" +
                "gsmAll=" + gsmAll +
                ", gsmWave=" + gsmWave +
                ", gsmDead=" + gsmDead +
                ", rsAll=" + rsAll +
                ", rsDead=" + rsDead +
                ", lteAll=" + lteAll +
                ", lteWave=" + lteWave +
                ", lteDead=" + lteDead +
                ", wlanAc=" + wlanAc +
                ", wlanHot=" + wlanHot +
                ", wlanAp=" + wlanAp +
                ", wlanAllvo=" + wlanAllvo +
                ", wlanApdead=" + wlanApdead +
                ", wlanApdrop=" + wlanApdrop +
                ", summitTime=" + summitTime +
                '}';
    }

    public int getGsmAll() {
        return gsmAll;
    }

    public void setGsmAll(int gsmAll) {
        this.gsmAll = gsmAll;
    }

    public int getGsmWave() {
        return gsmWave;
    }

    public void setGsmWave(int gsmWave) {
        this.gsmWave = gsmWave;
    }

    public int getGsmDead() {
        return gsmDead;
    }

    public void setGsmDead(int gsmDead) {
        this.gsmDead = gsmDead;
    }

    public int getRsAll() {
        return rsAll;
    }

    public void setRsAll(int rsAll) {
        this.rsAll = rsAll;
    }

    public int getRsDead() {
        return rsDead;
    }

    public void setRsDead(int rsDead) {
        this.rsDead = rsDead;
    }

    public int getLteAll() {
        return lteAll;
    }

    public void setLteAll(int lteAll) {
        this.lteAll = lteAll;
    }

    public int getLteWave() {
        return lteWave;
    }

    public void setLteWave(int lteWave) {
        this.lteWave = lteWave;
    }

    public int getLteDead() {
        return lteDead;
    }

    public void setLteDead(int lteDead) {
        this.lteDead = lteDead;
    }

    public int getWlanAc() {
        return wlanAc;
    }

    public void setWlanAc(int wlanAc) {
        this.wlanAc = wlanAc;
    }

    public int getWlanHot() {
        return wlanHot;
    }

    public void setWlanHot(int wlanHot) {
        this.wlanHot = wlanHot;
    }

    public int getWlanAp() {
        return wlanAp;
    }

    public void setWlanAp(int wlanAp) {
        this.wlanAp = wlanAp;
    }

    public float getWlanAllvo() {
        return wlanAllvo;
    }

    public void setWlanAllvo(float wlanAllvo) {
        this.wlanAllvo = wlanAllvo;
    }

    public float getWlanApdead() {
        return wlanApdead;
    }

    public void setWlanApdead(float wlanApdead) {
        this.wlanApdead = wlanApdead;
    }

    public float getWlanApdrop() {
        return wlanApdrop;
    }

    public void setWlanApdrop(float wlanApdrop) {
        this.wlanApdrop = wlanApdrop;
    }

    public String getSummitTime() {
        return summitTime;
    }

    public void setSummitTime(String summitTime) {
        this.summitTime = summitTime;
    }
}
