package com.czw.web.main.action;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;


/**
 * @author ZeviChen ${datetime}
 */
@Controller
public class LoginAction extends BaseAction{

    @RequestMapping("toLogin")
    public String toLogin(Model model,HttpSession session){
        String rmdToken = UUID.randomUUID().toString();
        session.setAttribute("loginToken",rmdToken);
        model.addAttribute("loginToken", rmdToken);
        System.out.println("当前sessionid:"+session.getId());
        return "login/login";
    }


    /**
     * 后面在做把session存入redis的测试，暂时就这样吧，2016-09-29 17:04:04
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value="login",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String login(HttpServletRequest req, Model model){
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String upToken = req.getParameter("loginToken");

        HttpSession session = req.getSession();
        String oldLoginToken = (String) session.getAttribute("loginToken");
        System.out.println("upToken:"+upToken+" , oldLoginToken:"+oldLoginToken);
        if(null != oldLoginToken && oldLoginToken.equals(upToken)){
            //临时存储，如果登录失败在把这个设置回去
            String tmpToken = (String) req.getSession().getAttribute("loginToken");
            String newToken = UUID.randomUUID().toString();
            req.getSession().setAttribute("loginToken",newToken);
            String sha1HexPassword = DigestUtils.sha1Hex(password.getBytes());
            System.out.println("account:"+account+" ,  password："+sha1HexPassword);
            //...
            return "success";
        }else{
            return "不要重复点击";
        }
    }
}
