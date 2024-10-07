package com.proberen.www.entity;

import java.io.Serializable;
import java.util.Date;

public class CnNotebook implements Serializable {
    private String cnNotebookId;
    private String cnUserId;
    private String cnNotebookTypeId;
    private String cnNotebookName;
    private String cnNotebookDesc;
    private Date cnNotebookCreatetime;
    private static final long serialVersionUID = 1L;

    public String getCnNotebookId() {
        return cnNotebookId;
    }

    public void setCnNotebookId(String cnNotebookId) {
        this.cnNotebookId = cnNotebookId;
    }

    public String getCnUserId() {
        return cnUserId;
    }

    public void setCnUserId(String cnUserId) {
        this.cnUserId = cnUserId;
    }

    public String getCnNotebookTypeId() {
        return cnNotebookTypeId;
    }

    public void setCnNotebookTypeId(String cnNotebookTypeId) {
        this.cnNotebookTypeId = cnNotebookTypeId;
    }

    public String getCnNotebookName() {
        return cnNotebookName;
    }

    public void setCnNotebookName(String cnNotebookName) {
        this.cnNotebookName = cnNotebookName;
    }

    public String getCnNotebookDesc() {
        return cnNotebookDesc;
    }

    public void setCnNotebookDesc(String cnNotebookDesc) {
        this.cnNotebookDesc = cnNotebookDesc;
    }

    public Date getCnNotebookCreatetime() {
        return cnNotebookCreatetime;
    }

    public void setCnNotebookCreatetime(Date cnNotebookCreatetime) {
        this.cnNotebookCreatetime = cnNotebookCreatetime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "CnNotebook{" +
                "cnNotebookId='" + cnNotebookId + '\'' +
                ", cnUserId='" + cnUserId + '\'' +
                ", cnNotebookTypeId='" + cnNotebookTypeId + '\'' +
                ", cnNotebookName='" + cnNotebookName + '\'' +
                ", cnNotebookDesc='" + cnNotebookDesc + '\'' +
                ", cnNotebookCreatetime=" + cnNotebookCreatetime +
                '}';
    }
}