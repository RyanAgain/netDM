package com.datamanager.dto;

import com.datamanager.entity.Userinfo;
import com.datamanager.enums.LoginEnums;

/**
 * 2018-06-07-17:29 Author By AgainP
 */
public class LoginResult {

    private int userId;

    private int state;

    private String userName;

    private String stateInfo;

    public LoginResult(int userId, LoginEnums loginEnums) {
        this.userId = userId;
        this.state = loginEnums.getState();
        this.stateInfo = loginEnums.getStateInfo();
    }

    public LoginResult(String userName, LoginEnums loginEnums) {
        this.userName = userName;
        this.state =loginEnums.getState();
        this.stateInfo = loginEnums.getStateInfo();
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
