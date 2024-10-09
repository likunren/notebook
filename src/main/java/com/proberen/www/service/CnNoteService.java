package com.proberen.www.service;

import com.proberen.www.entity.CnNote;
import com.proberen.www.util.ResultData;

import java.util.List;

public interface CnNoteService {
    public ResultData<List<CnNote>> findBookNotes(String bookId);

}
