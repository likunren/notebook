package com.proberen.www.dao;

import com.proberen.www.entity.CnNotebook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cnNoteBookDao")
public interface CnNotebookDaoMapper{
    public List<CnNotebook> findbooksByUserId(String userId);
}
