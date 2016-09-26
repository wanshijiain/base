package com.czw.web.servlet;

import com.czw.web.servlet.action.Test1Action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZeviChen ${datetime}
 */
public class HostServlet extends HttpServlet {

    private static Map<String,Object> requestPath = new HashMap<>();
    static{
        requestPath.put("/servlet/test1",new Test1Action());
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
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
        System.out.println("contextPath: "+contextPath+" , servletPath: "+servletPath+" , pathInfo: "+pathInfo);
        System.out.println("ServletContext.realPath: "+servletContext.getRealPath("/"));
        System.out.println("basePath: "+basePath);

        String reqURL = contextPath+servletPath+pathInfo;
        BaseAction action = (BaseAction) requestPath.get(reqURL);
        if(null != action){
            action.dispose(req,resp);
        }else{
            PrintWriter writer = resp.getWriter();
            writer.write("没有对应的处理路径");
            writer.flush();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
