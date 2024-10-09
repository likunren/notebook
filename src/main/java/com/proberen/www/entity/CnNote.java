package com.proberen.www.entity;

import java.io.Serializable;



public class CnNote implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cnNoteId;
    private String cnNotebookId;
    private String cnUserId;
    private String cnNoteStatusId;
    private String cnNoteTypeId;
    private String cnNoteTitle;
    private String cnNoteBody;
    private Long cnNoteCreateTime;
    private Long cnNoteLastModifyTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCnNoteId() {
        return cnNoteId;
    }

    public void setCnNoteId(String cnNoteId) {
        this.cnNoteId = cnNoteId;
    }

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

    public String getCnNoteStatusId() {
        return cnNoteStatusId;
    }

    public void setCnNoteStatusId(String cnNoteStatusId) {
        this.cnNoteStatusId = cnNoteStatusId;
    }

    public String getCnNoteTypeId() {
        return cnNoteTypeId;
    }

    public void setCnNoteTypeId(String cnNoteTypeId) {
        this.cnNoteTypeId = cnNoteTypeId;
    }

    public String getCnNoteTitle() {
        return cnNoteTitle;
    }

    public void setCnNoteTitle(String cnNoteTitle) {
        this.cnNoteTitle = cnNoteTitle;
    }

    public String getCnNoteBody() {
        return cnNoteBody;
    }

    public void setCnNoteBody(String cnNoteBody) {
        this.cnNoteBody = cnNoteBody;
    }

    public Long getCnNoteCreateTime() {
        return cnNoteCreateTime;
    }

    public void setCnNoteCreateTime(Long cnNoteCreateTime) {
        this.cnNoteCreateTime = cnNoteCreateTime;
    }

    public Long getCnNoteLastModifyTime() {
        return cnNoteLastModifyTime;
    }

    public void setCnNoteLastModifyTime(Long cnNoteLastModifyTime) {
        this.cnNoteLastModifyTime = cnNoteLastModifyTime;
    }

    @Override
    public String toString() {
        return "CnNote{" +
                "cnNoteId='" + cnNoteId + '\'' +
                ", cnNotebookId='" + cnNotebookId + '\'' +
                ", cnUserId='" + cnUserId + '\'' +
                ", cnNoteStatusId='" + cnNoteStatusId + '\'' +
                ", cnNoteTypeId='" + cnNoteTypeId + '\'' +
                ", cnNoteTitle='" + cnNoteTitle + '\'' +
                ", cnNoteBody='" + cnNoteBody + '\'' +
                ", cnNoteCreateTime=" + cnNoteCreateTime +
                ", cnNoteLastModifyTime=" + cnNoteLastModifyTime +
                '}';
    }
}