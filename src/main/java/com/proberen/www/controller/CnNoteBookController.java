package com.proberen.www.controller;

import com.proberen.www.entity.CnNotebook;
import com.proberen.www.service.CnNotebookService;
import com.proberen.www.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/book")
public class CnNoteBookController {
    @Resource(name="cnNotebookServiceImpl")
    private CnNotebookService cnNotebookService;

    @RequestMapping("/loadBooks")
    @ResponseBody
    public ResultData<List<CnNotebook>> loadBooks(HttpServletRequest request, HttpServletResponse response){
        String userId=request.getParameter("userId");
        ResultData<List<CnNotebook>> resultDate=cnNotebookService.loadUserBooks(userId);
        return resultDate;
    }
    @RequestMapping("/add")
    @ResponseBody
    public ResultData<CnNotebook> addNoteBook(HttpServletRequest request, HttpServletResponse response){
        String userId=request.getParameter("cnUserId");
        String noteBookName=request.getParameter("noteBookName");
        ResultData<CnNotebook> resultDate=cnNotebookService.createNoteBook(userId,noteBookName);
        return resultDate;
    }
}
