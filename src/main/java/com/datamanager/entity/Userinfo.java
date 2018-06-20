package com.datamanager.entity;

/**
 * 2018-05-28-18:35 Author By AgainP
 */
public class Userinfo {

    public int userId;

    public String userName;

    public String nickName;

    public String userPw;

    public int userRole;


    @Override
    public String toString() {
        return "Userinfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
