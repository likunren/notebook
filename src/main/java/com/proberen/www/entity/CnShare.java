package com.proberen.www.entity;

import java.io.Serializable;

public class CnShare implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cnShareId;
    private String cnShareTitle;
    private String cnShareBody;
    private String cnNoteId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCnShareId() {
        return cnShareId;
    }

    public void setCnShareId(String cnShareId) {
        this.cnShareId = cnShareId;
    }

    public String getCnShareTitle() {
        return cnShareTitle;
    }

    public void setCnShareTitle(String cnShareTitle) {
        this.cnShareTitle = cnShareTitle;
    }

    public String getCnShareBody() {
        return cnShareBody;
    }

    public void setCnShareBody(String cnShareBody) {
        this.cnShareBody = cnShareBody;
    }

    public String getCnNoteId() {
        return cnNoteId;
    }

    public void setCnNoteId(String cnNoteId) {
        this.cnNoteId = cnNoteId;
    }
}