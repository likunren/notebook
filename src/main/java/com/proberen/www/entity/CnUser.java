package com.proberen.www.entity;

import java.io.Serializable;

public class CnUser implements Serializable {
    private String cnUserId;
    private String cnUserName;
    private String cnUserPassword;
    private String cnUserToken;
    private String cnUserDesc;

    public String getCnUserId() {
        return cnUserId;
    }

    public void setCnUserId(String cnUserId) {
        this.cnUserId = cnUserId;
    }

    public String getCnUserName() {
        return cnUserName;
    }

    public void setCnUserName(String cnUserName) {
        this.cnUserName = cnUserName;
    }

    public String getCnUserPassword() {
        return cnUserPassword;
    }

    public void setCnUserPassword(String cnUserPassword) {
        this.cnUserPassword = cnUserPassword;
    }

    public String getCnUserToken() {
        return cnUserToken;
    }

    public void setCnUserToken(String cnUserToken) {
        this.cnUserToken = cnUserToken;
    }

    public String getCnUserDesc() {
        return cnUserDesc;
    }

    public void setCnUserDesc(String cnUserDesc) {
        this.cnUserDesc = cnUserDesc;
    }
}
