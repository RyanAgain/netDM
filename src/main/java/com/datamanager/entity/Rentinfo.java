package com.datamanager.entity;

import java.util.Date;

/**
 * 2018-04-11-23:46 Author By AgainP
 */
public class Rentinfo {

    private long cardId;

    private String rentName;

    private long rentPhone;

    private String rentReason;

    private String roomNum;

    private String ydInterface;

    private Date startTime;

    private Date endTime;

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public long getRentPhone() {
        return rentPhone;
    }

    public void setRentPhone(long rentPhone) {
        this.rentPhone = rentPhone;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRentReason() {
        return rentReason;
    }

    public void setRentReason(String rentReason) {
        this.rentReason = rentReason;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getYdInterface() {
        return ydInterface;
    }

    public void setYdInterface(String ydInterface) {
        this.ydInterface = ydInterface;
    }

    @Override
    public String toString() {
        return "Rentinfo{" +
                "cardId=" + cardId +
                ", rentName='" + rentName + '\'' +
                ", rentPhone=" + rentPhone +
                ", rentReason='" + rentReason + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", ydInterface='" + ydInterface + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
