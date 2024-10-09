package com.proberen.www.dao;

import com.proberen.www.entity.CnNote;
import com.proberen.www.entity.CnNotebook;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("cnNoteDao")
public interface CnNoteDaoMapper {
    public List<CnNote> findNoteByBookId(String bookId);

}
