package com.proberen.www.service.impl;
import com.proberen.www.dao.CnNoteDaoMapper;
import com.proberen.www.entity.CnNote;
import com.proberen.www.service.CnNoteService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class CnNoteServiceImpl implements CnNoteService{
    @Resource(name="cnNoteDao")
    private CnNoteDaoMapper cnNoteDao;
    @Override
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
}
