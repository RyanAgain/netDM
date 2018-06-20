package com.datamanager.enums;

/**
 * 2018-05-17-18:04 Author By AgainP
 */
public enum  ReturnEums {
    SUCCESS(1,"还卡成功"),
    REPEAT(0,"重复还卡"),
    INNER_ERROR(-1,"系统异常"),
    DATA_REWRITE(-2,"数据篡改");

    private int state;

    private String stateInfo;

    ReturnEums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ReturnEums stateOf(int index){
        for(ReturnEums state : values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }

}
