package com.proberen.www.dao;

import com.proberen.www.entity.CnNote;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("cnNoteDao")
public interface CnNoteDaoMapper {
    public List<CnNote> findNoteByBookId(String bookId);
    public CnNote findNoteByNoteId(String noteId);
    public void modifyNote(CnNote cnNote);
    public void saveNote(CnNote cnNote);
    public void deleteNote(String noteId);

}
