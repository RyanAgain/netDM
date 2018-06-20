package com.datamanager.dto;

/**
 * 2018-05-29-14:57 Author By AgainP
 */
public class InsertDailyMsgResult<T> {

    private boolean success;

    private T data;

    private String error;

    public InsertDailyMsgResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public InsertDailyMsgResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }


    public boolean isSuccess() {
        return success;
    }


    public T getData() {
        return data;
    }


    public String getError() {
        return error;
    }

}
