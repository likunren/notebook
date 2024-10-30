package com.proberen.www.service.impl;
import com.proberen.www.dao.CnNoteDaoMapper;
import com.proberen.www.entity.CnNote;
import com.proberen.www.entity.CnNotebook;
import com.proberen.www.service.CnNoteService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import com.proberen.www.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class CnNoteServiceImpl implements CnNoteService{
    @Resource(name="cnNoteDao")
    private CnNoteDaoMapper cnNoteDao;
    @Transactional
    public ResultData<List<CnNote>> findBookNotes(String bookId) {
        ResultData<List<CnNote>> resultData=new  ResultData<List<CnNote>>();
        List<CnNote> cnNotes=cnNoteDao.findNoteByBookId(bookId);
        if(cnNotes!=null&& cnNotes.size()!=0) {
            resultData.setStatusCode(Status.SUCCESS);
            resultData.setMsg("es hat shon erfolgreich gefundeng");
            resultData.setObjectData(cnNotes);
        }else{
            resultData.setStatusCode(Status.NOTE_BOOK_EMPTY);
            resultData.setMsg("es gibt keine Daten");
        }
        return resultData;
    }

    @Transactional
    public ResultData<CnNote> loadNote(String noteId) {
        ResultData<CnNote> resultData=new ResultData<CnNote>();
        CnNote cnNote=cnNoteDao.findNoteByNoteId(noteId);
        resultData.setStatusCode(Status.SUCCESS);
        resultData.setMsg("es wurde Erfolg gefunden");
        resultData.setObjectData(cnNote);
        return resultData;
    }

    @Transactional
    public ResultData<String> updateNote(CnNote cnNote) {
        ResultData<String> resultData=new ResultData();
        cnNoteDao.modifyNote(cnNote);
        resultData.setStatusCode(Status.SUCCESS);
        resultData.setObjectData(cnNote.getCnNoteTitle());
        resultData.setMsg("es wurde Erfolg erneuert");
        return resultData;
    }

    @Transactional
    public ResultData<CnNote> addNote(CnNote cnNote) {
        ResultData<CnNote> resultData=new ResultData<CnNote>();
        cnNote.setCnNoteId(Utils.get_UUID());
        cnNote.setCnNoteStatusId("1");
        cnNote.setCnNoteTypeId("1");
        cnNote.setCnNoteBody("");
        Long createTime=System.currentTimeMillis();
        cnNote.setCnNoteCreateTime(createTime);
        cnNote.setCnNoteLastModifyTime(createTime);
        cnNoteDao.saveNote(cnNote);
        resultData.setStatusCode(Status.SUCCESS);
        resultData.setObjectData(cnNote);
        resultData.setMsg("es wurde Erfolg erstellt");
        return resultData;
    }
}
