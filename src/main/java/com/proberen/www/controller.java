package com.proberen.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class controller {
    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
