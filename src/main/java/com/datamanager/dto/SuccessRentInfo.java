package com.datamanager.dto;

import com.datamanager.entity.Rentinfo;
import com.datamanager.enums.RentinfoEnums;

/**
 * 2018-05-16-15:11 Author By AgainP
 */
public class SuccessRentInfo {


    private long cardId;

    private int state;

    private String stateInfo;

    private Rentinfo rentinfo;

    public SuccessRentInfo(long cardId, RentinfoEnums rentinfoEnums, Rentinfo rentinfo) {
        this.cardId = cardId;
        this.state = rentinfoEnums.getState();
        this.stateInfo = rentinfoEnums.getStateInfo();
        this.rentinfo = rentinfo;
    }

    public SuccessRentInfo(long cardId, RentinfoEnums rentinfoEnums) {
        this.cardId = cardId;
        this.state = rentinfoEnums.getState();
        this.stateInfo = rentinfoEnums.getStateInfo();
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Rentinfo getRentinfo() {
        return rentinfo;
    }

    public void setRentinfo(Rentinfo rentinfo) {
        this.rentinfo = rentinfo;
    }
}
