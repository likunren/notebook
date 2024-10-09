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
}

