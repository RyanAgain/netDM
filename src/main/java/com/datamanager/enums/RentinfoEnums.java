package com.datamanager.enums;

/**
 * 2018-05-16-16:58 Author By AgainP
 */
public enum  RentinfoEnums {
    SUCCESS(1,"借卡成功"),
    REPEAT(0,"重复借卡"),
    INNER_ERROR(-1,"系统异常"),
    DATA_REWRITE(-2,"数据篡改");

    private int state;

    private String stateInfo;

    RentinfoEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static RentinfoEnums stateOf(int index){
        for(RentinfoEnums state : values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }

}
