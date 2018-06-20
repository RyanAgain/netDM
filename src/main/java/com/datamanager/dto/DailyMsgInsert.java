package com.datamanager.dto;

import com.datamanager.entity.*;
import com.datamanager.enums.DailyMsgEnums;

/**
 * 2018-05-28-16:59 Author By AgainP
 */
public class DailyMsgInsert {

    private int state;

    private String stateInfo;

    private Broadband broadband;

    private Core core;

    private Optimization optimization;

    private Transfer transfer;

    private Wireless wireless;

    public DailyMsgInsert(DailyMsgEnums dailyMsgEnums) {
        this.state = dailyMsgEnums.getState();
        this.stateInfo = dailyMsgEnums.getStateInfo();
    }

    public DailyMsgInsert(DailyMsgEnums dailyMsgEnums, Transfer transfer){
        this.state = dailyMsgEnums.getState();
        this.stateInfo = dailyMsgEnums.getStateInfo();
        this.transfer = transfer;
    }

    public DailyMsgInsert(DailyMsgEnums dailyMsgEnums, Broadband broadband) {
        this.state = dailyMsgEnums.getState();
        this.stateInfo = dailyMsgEnums.getStateInfo();
        this.broadband = broadband;
    }

    public DailyMsgInsert(DailyMsgEnums dailyMsgEnums, Core core) {
        this.state = dailyMsgEnums.getState();
        this.stateInfo = dailyMsgEnums.getStateInfo();
        this.core = core;
    }

    public DailyMsgInsert(DailyMsgEnums dailyMsgEnums, Optimization optimization) {
        this.state = dailyMsgEnums.getState();
        this.stateInfo = dailyMsgEnums.getStateInfo();
        this.optimization = optimization;
    }

    public DailyMsgInsert(DailyMsgEnums dailyMsgEnums, Wireless wireless) {
        this.state = dailyMsgEnums.getState();
        this.stateInfo = dailyMsgEnums.getStateInfo();
        this.wireless = wireless;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public Broadband getBroadband() {
        return broadband;
    }

    public Core getCore() {
        return core;
    }

    public Optimization getOptimization() {
        return optimization;
    }

    public Wireless getWireless() {
        return wireless;
    }
}
