package com.datamanager.enums;

/**
 * 2018-05-28-16:55 Author By AgainP
 */
public enum DailyMsgEnums {

    SUCCESS(1,"填报成功"),
    REPEAT(0,"当日重复提交"),
    PERMISSION_ERROR(-1,"权限不足"),
    INNER_ERROR(-2,"内部错误");

    private int state;

    private String stateInfo;

    DailyMsgEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static DailyMsgEnums stateOf(int index){
        for(DailyMsgEnums state : values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
