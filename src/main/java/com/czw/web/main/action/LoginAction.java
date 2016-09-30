package com.czw.web.main.action;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.Callable;


/**
 * @author ZeviChen ${datetime}
 */
@Controller
public class LoginAction extends BaseAction{

    /**
     * Host                    localhost:8080
     * Accept                  text/html,application/xhtml+xml,application/xml;q=0.9
     * Accept-Language         fr,en-gb;q=0.7,en;q=0.3
     * Accept-Encoding         gzip,deflate
     * Accept-Charset          ISO-8859-1,utf-8;q=0.7,*;q=0.7
     * Keep-Alive              300
     *
     * @RequestHeader 用于 Map<String, String>,MultiValueMap<String, String>, 或 HttpHeaders 参数，map 会填充所有头字段值
     * 例如：@RequestHeader Map<String,String> headers
     *
     * @param encoding
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(@RequestHeader("Accept-Encoding") String encoding, Model model, HttpSession session){
        //RequestHeader获取头字段属性

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
    public String login(HttpServletRequest req, Model model, @CookieValue("JSESSIONID")String sessionId){
        //通过上面的这种方式获取jsessionId

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

    /**
     * 支持servlet3.0的一部处理，将return交给新的线程处理
     * @param file
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public Callable<String> processUpload(final MultipartFile file) {

        return new Callable<String>() {
            public String call() throws Exception {
                // ...
                return "someView";
            }
        };

    }


}
