package com.czw.web.servlet;

import com.czw.util.DateUtils;
import com.czw.web.servlet.action.SkipUploadAction;
import com.czw.web.servlet.action.Test1Action;
import com.czw.web.servlet.action.UploadAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZeviChen ${datetime}
 */
public class HostServlet extends HttpServlet {
    protected static Logger log = LoggerFactory.getLogger(HostServlet.class);

    private static Map<String,Object> requestPath = new HashMap<>();
    static{
        requestPath.put("/servlet/test1",new Test1Action());
        requestPath.put("/servlet/skiptoupload",new SkipUploadAction());
        requestPath.put("/servlet/upload",new UploadAction());
    }

    @Override
    public void init() throws ServletException {
        log.info("init() datetime = {}", DateUtils.dtts(new Date()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        //Implicit Objects
        ServletContext servletContext = this.getServletContext();
        ServletConfig servletConfig = this.getServletConfig();

        //Path...
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String pathInfo = req.getPathInfo();
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+contextPath+"/";
        String reqURL = contextPath+servletPath+pathInfo;
        System.out.println("---contextPath: "+contextPath+" , servletPath: "+servletPath+" , pathInfo: "+pathInfo);
        System.out.println("---ServletContext.realPath: "+servletContext.getRealPath("/"));
        System.out.println("---basePath: "+basePath);
        System.out.println("---reqURL: "+reqURL);


        BaseAction action = (BaseAction) requestPath.get(reqURL);
        if(null != action){
            action.dispose(req,resp);
        }else{
            PrintWriter writer = resp.getWriter();
            writer.println("没有对应的处理路径");
            writer.close();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
