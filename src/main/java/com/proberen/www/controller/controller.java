package com.proberen.www.controller;

import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import com.proberen.www.util.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class controller {
    @Resource(name="cnUserServiceImpl")
    private CnUserService cnUserService;
    @RequestMapping("/login")
    @ResponseBody
    public ResultData<CnUser> login(HttpServletRequest request, HttpServletResponse response){
        String userName=request.getParameter("userName");
        String passWord=request.getParameter("passWord");
        return cnUserService.findByUser(userName,passWord);
    }
}
