package com.datamanager.dto;

/**
 * 2018-06-07-17:14 Author By AgainP
 */
public class SuccessLogin<T> {

    private T data;

    private boolean success;

    private String error;

    public SuccessLogin(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public SuccessLogin(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
