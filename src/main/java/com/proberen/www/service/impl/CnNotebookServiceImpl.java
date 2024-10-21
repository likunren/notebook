package com.proberen.www.service.impl;

import com.proberen.www.dao.CnNotebookDaoMapper;
import com.proberen.www.entity.CnNotebook;;
import com.proberen.www.service.CnNotebookService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import com.proberen.www.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Transactional
    public ResultData<CnNotebook> createNoteBook(String userId,String noteBookName) {
        ResultData<CnNotebook> resultData=new ResultData<CnNotebook>();
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("cnNotebook",noteBookName);
        parameters.put("userId",userId);
        CnNotebook cnNotebookTemp=cnNoteBookDao.findBooksByName(parameters);
        if(cnNotebookTemp!=null){
            resultData.setStatusCode(Status.NOTE_BOOK_NAME);
            resultData.setMsg("Der Name ist shon existiert.");
            resultData.setObjectData(null);
        }else {
            CnNotebook cnNotebook=new CnNotebook();
            cnNotebook.setCnNotebookId(Utils.get_UUID());
            cnNotebook.setCnUserId(userId);
            cnNotebook.setCnNotebookName(noteBookName);
            cnNotebook.setCnNotebookTypeId("1");
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            cnNotebook.setCnNotebookCreatetime(new Date());
            cnNoteBookDao.insertNoteBook(cnNotebook);
            resultData.setStatusCode(Status.SUCCESS);
            resultData.setObjectData(cnNotebook);
            resultData.setMsg("der Notebook wurde Erfolg gespeichert");
        }
        return resultData;
    }

}
