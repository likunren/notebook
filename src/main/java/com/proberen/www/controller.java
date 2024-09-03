package com.proberen.www;

import com.proberen.www.entity.CnUser;
import com.proberen.www.service.CnUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/login")
public class controller {
    @Resource(name="cnUserServiceImpl")
    private CnUserService cnUserService;
    @RequestMapping("/login")
    @ResponseBody
    public List<CnUser> login(){
        return cnUserService.findAllUser();
    }
}
