package com.datamanager.enums;

/**
 * 2018-06-07-17:30 Author By AgainP
 */
public enum LoginEnums {

    SUCCESS(1,"登录成功"),
    EMPTY(0,"尚未注册"),
    PWD_ERROR(-1,"密码错误"),
    DATA_REWRITE(-2,"数据篡改");

    private int state;

    private String stateInfo;

    LoginEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static LoginEnums stateOf(int index){
        for(LoginEnums state : values()){
            if (state.getState() == index){
                return state;
            }
        }
        return null;
    }


}
