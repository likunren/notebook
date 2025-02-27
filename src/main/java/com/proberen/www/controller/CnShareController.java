package com.proberen.www.controller;

import com.proberen.www.entity.CnShare;
import com.proberen.www.service.CnShareService;
import com.proberen.www.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/share")
public class CnShareController {
    @Resource(name="cnShareServiceImpl")
    private CnShareService cnShareServiceImpl;
    @RequestMapping("/add")
    @ResponseBody
    public ResultData<CnShare> createShare(HttpServletRequest request, HttpServletResponse response){
        String noteId=request.getParameter("noteId");
        ResultData<CnShare> resultData=cnShareServiceImpl.addSchare(noteId);
        return resultData;
    }

}
