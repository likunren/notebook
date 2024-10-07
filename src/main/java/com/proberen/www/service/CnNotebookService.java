package com.proberen.www.service;

import com.proberen.www.entity.CnNotebook;
import com.proberen.www.util.ResultData;

import java.util.List;

public interface CnNotebookService {
    public ResultData<List<CnNotebook>> loadUserBooks(String userId);
}
