package com.proberen.www.service;

import com.proberen.www.entity.CnShare;
import com.proberen.www.util.ResultData;


public interface CnShareService{
    public ResultData<CnShare> addSchare(String noteId);
}
