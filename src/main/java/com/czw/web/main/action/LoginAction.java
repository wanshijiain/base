package com.czw.web.main.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZeviChen ${datetime}
 */
@Controller
public class LoginAction {

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login/login";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String account,String password){
        System.out.println("account:"+account+" , password"+password);
        return "success";
    }
}
