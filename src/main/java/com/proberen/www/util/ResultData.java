package com.proberen.www.util;

public class ResultData<T> {
    private int staticCode;
    private String msg;
    private T objectData;

    public int getStaticCode() {
        return staticCode;
    }

    public void setStaticCode(int staticCode) {
        this.staticCode = staticCode;
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
