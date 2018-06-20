package com.datamanager.entity;

/**
 * 2018-06-01-15:52 Author By AgainP
 */
public class Transfer {

    //top1基站
    private String firstUse;

    //top1基站利用率
    private float firstUsage;

    private String secUse;

    private float secUsage;

    private String thirdUse;

    private float thirdUsage;

    private String forthUse;

    private float forthUsage;

    private String fifthUse;

    private float fifthUsage;

    private String summitTime;

    @Override
    public String toString() {
        return "Transfer{" +
                "firstUse='" + firstUse + '\'' +
                ", firstUsage=" + firstUsage +
                ", secUse='" + secUse + '\'' +
                ", secUsage=" + secUsage +
                ", thirdUse='" + thirdUse + '\'' +
                ", thirdUsage=" + thirdUsage +
                ", forthUse='" + forthUse + '\'' +
                ", forthUsage=" + forthUsage +
                ", fifthUse='" + fifthUse + '\'' +
                ", fifthUsage=" + fifthUsage +
                ", summitTime='" + summitTime + '\'' +
                '}';
    }

    public String getSummitTime() {
        return summitTime;
    }

    public void setSummitTime(String summitTime) {
        this.summitTime = summitTime;
    }

    public String getFirstUse() {
        return firstUse;
    }

    public void setFirstUse(String firstUse) {
        this.firstUse = firstUse;
    }

    public float getFirstUsage() {
        return firstUsage;
    }

    public void setFirstUsage(float firstUsage) {
        this.firstUsage = firstUsage;
    }

    public String getSecUse() {
        return secUse;
    }

    public void setSecUse(String secUse) {
        this.secUse = secUse;
    }

    public float getSecUsage() {
        return secUsage;
    }

    public void setSecUsage(float secUsage) {
        this.secUsage = secUsage;
    }

    public String getThirdUse() {
        return thirdUse;
    }

    public void setThirdUse(String thirdUse) {
        this.thirdUse = thirdUse;
    }

    public float getThirdUsage() {
        return thirdUsage;
    }

    public void setThirdUsage(float thirdUsage) {
        this.thirdUsage = thirdUsage;
    }

    public String getForthUse() {
        return forthUse;
    }

    public void setForthUse(String forthUse) {
        this.forthUse = forthUse;
    }

    public float getForthUsage() {
        return forthUsage;
    }

    public void setForthUsage(float forthUsage) {
        this.forthUsage = forthUsage;
    }

    public String getFifthUse() {
        return fifthUse;
    }

    public void setFifthUse(String fifthUse) {
        this.fifthUse = fifthUse;
    }

    public float getFifthUsage() {
        return fifthUsage;
    }

    public void setFifthUsage(float fifthUsage) {
        this.fifthUsage = fifthUsage;
    }
}
