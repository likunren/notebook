package com.proberen.www.dao;

import com.proberen.www.entity.CnNotebook;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("cnNoteBookDao")
public interface CnNotebookDaoMapper{
    public List<CnNotebook> findbooksByUserId(String userId);
    public CnNotebook findBooksByName(Map<String,String> parameters);
    public void insertNoteBook(CnNotebook cnNotebook);
}
