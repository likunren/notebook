package com.proberen.www.controller;

import com.proberen.www.entity.CnNote;
import com.proberen.www.service.CnNoteService;
import com.proberen.www.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/note")
public class CnNoteController {
    @Resource(name="cnNoteServiceImpl")
    private CnNoteService cnNoteService;
    @RequestMapping("/loadNotes")
    @ResponseBody
   public ResultData<List<CnNote>> loadBookNotes(HttpServletRequest request, HttpServletResponse response){
       String bookId= request.getParameter("bookId");
        ResultData<List<CnNote>> resultData=cnNoteService.findBookNotes(bookId);
        return resultData;
    }
    @RequestMapping("/loadNote")
    @ResponseBody
    public ResultData<CnNote> loadNote(HttpServletRequest request,HttpServletResponse response){
        String noteId=request.getParameter("noteId");
        ResultData<CnNote> resultData=cnNoteService.loadNote(noteId);
        return resultData;
    }
    @RequestMapping("/update")
    @ResponseBody
    public ResultData<String> updateNote(HttpServletRequest request,HttpServletResponse response){
        String noteId=request.getParameter("noteId");
        String noteTitle=request.getParameter("noteTitle");
        String noteBody=request.getParameter("noteBody");
        CnNote cnNote=new CnNote();
        cnNote.setCnNoteId(noteId);
        cnNote.setCnNoteTitle(noteTitle);
        cnNote.setCnNoteBody(noteBody);
        ResultData<String> resultData=cnNoteService.updateNote(cnNote);
        return resultData;
    }
    @RequestMapping("/addNote")
    @ResponseBody
    public ResultData<CnNote> addNote(HttpServletRequest request,HttpServletResponse response){
        String cnNotebookId=request.getParameter("cnNotebookId");
        String cnUserId=request.getParameter("cnUserId");
        String cnNoteTitle=request.getParameter("cnNoteTitle");
        CnNote cnNote=new CnNote();
        cnNote.setCnNotebookId(cnNotebookId);
        cnNote.setCnUserId(cnUserId);
        cnNote.setCnNoteTitle(cnNoteTitle);
        ResultData<CnNote> resultData=cnNoteService.addNote(cnNote);
        return resultData;
    }
    @RequestMapping("/delNote")
    @ResponseBody
    public ResultData<String> removeNotebook(HttpServletRequest request, HttpServletResponse response){
        String noteId=request.getParameter("noteId");
        ResultData<String> resultData=cnNoteService.deleteNote(noteId);
        return resultData;
    }
}

