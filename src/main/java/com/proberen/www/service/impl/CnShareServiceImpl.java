package com.proberen.www.service.impl;

import com.proberen.www.dao.CnNoteDaoMapper;
import com.proberen.www.dao.CnShareDaoMapper;
import com.proberen.www.entity.CnNote;
import com.proberen.www.entity.CnShare;
import com.proberen.www.service.CnShareService;
import com.proberen.www.util.ResultData;
import com.proberen.www.util.Status;
import com.proberen.www.util.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class CnShareServiceImpl implements CnShareService{
    @Resource(name="cnNoteDao")
    private CnNoteDaoMapper cnNoteDao;
    @Resource(name="cnShareDao")
    private CnShareDaoMapper cnShareDao;

    @Transactional
    public ResultData<CnShare> addSchare(String noteId) {
        ResultData<CnShare> resultData=new ResultData<CnShare>();
        CnShare cnShare=new CnShare();
        cnShare.setCnShareId(Utils.get_UUID());
        cnShare.setCnNoteId(noteId);
        CnNote cnNote=cnNoteDao.findNoteByNoteId(noteId);
        cnShare.setCnShareTitle(cnNote.getCnNoteTitle());
        cnShare.setCnShareBody(cnNote.getCnNoteBody());
        cnShareDao.saveShare(cnShare);
        resultData.setStatusCode(Status.SUCCESS);
        resultData.setMsg("es wurde Erfolg geteilt");
        resultData.setObjectData(cnShare);
        return resultData;
    }
}
