package com.proberen.www.service.impl;

import com.proberen.www.dao.CnNotebookDaoMapper;
import com.proberen.www.entity.CnNotebook;;
import com.proberen.www.service.CnNotebookService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CnNotebookServiceImpl implements CnNotebookService {
    @Resource(name="cnNoteBookDao")
    private CnNotebookDaoMapper cnNoteBookDao;

    @Transactional
    public ResultData<List<CnNotebook>> loadUserBooks(String userId) {
        ResultData<List<CnNotebook>> resultData=new ResultData<List<CnNotebook>>();
        List<CnNotebook> books=cnNoteBookDao.findbooksByUserId(userId);
        if(books!=null&& books.size()!=0) {
            resultData.setStatusCode(Status.SUCCESS);
            resultData.setMsg("es hat shon erfolgreich gefundeng");
            resultData.setObjectData(books);
        }else{
            resultData.setStatusCode(Status.NOTE_BOOK_EMPTY);
            resultData.setMsg("es gibt keine Daten");
        }
        return resultData;
    }
}
