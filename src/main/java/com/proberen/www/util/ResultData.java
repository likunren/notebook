package com.proberen.www.util;

public class ResultData<T> {
    private int statusCode;
    private String msg;
    private T objectData;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObjectData() {
        return objectData;
    }

    public void setObjectData(T objectData) {
        this.objectData = objectData;
    }
}
