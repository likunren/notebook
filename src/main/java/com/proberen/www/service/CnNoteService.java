package com.proberen.www.service;

import com.proberen.www.entity.CnNote;
import com.proberen.www.entity.CnNotebook;
import com.proberen.www.util.ResultData;

import java.util.List;

public interface CnNoteService {
    public ResultData<List<CnNote>> findBookNotes(String bookId);
    public ResultData<CnNote> loadNote(String noteId);
    public ResultData<String> updateNote(CnNote cnNote);
    public ResultData<CnNote> addNote(CnNote cnNote);
 }
