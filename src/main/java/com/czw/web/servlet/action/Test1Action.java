package com.czw.web.servlet.action;

import com.czw.web.servlet.BaseAction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZeviChen ${datetime}
 */
public class Test1Action extends BaseAction {


    @Override
    public String dispose(HttpServletRequest req, HttpServletResponse resp) {
        log.info("Running...");
        try {
            Cookie cookie1 = new Cookie("Domain","localhost:8080");
            cookie1.setMaxAge(60*60*24);
            Cookie cookie2 = new Cookie("Version","1.0");
            cookie2.setComment("For test");

            //同一浏览器只会创建一个，直到session过期，不同浏览器会重新创建一个session
            //实际上session默认创建，该方法只是显式设置出来
            HttpSession session = req.getSession(true);
            if(session.isNew()){
                session.setAttribute("session.isNew","new");
            }else{
                //该参数设置：删除cookie1
                cookie1.setMaxAge(0);
                session.setAttribute("session.isNew","old");
            }
            //session无效设置,也可在web.xml中设置session-config配置失效时间
            /*
                <session-config>
                    <session-timeout>15</session-timeout>
                </session-config>
             */
            //session.invalidate();

            System.out.println("session.isNew: "+(String)session.getAttribute("session.isNew"));

            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            PrintWriter writer = resp.getWriter();
            writer.write("设置了cookie[Domain:localhost:8080]<br/>hahha<br/>");
            writer.append("中文显示<br/>");
            writer.append("sessionid : "+session.getId()+"<br/>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
