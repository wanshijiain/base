package com.czw.web.servlet.filter;

import com.czw.util.DateUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author ZeviChen ${datetime}
 */
public class ImpurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("杂质过滤器初始化 - DateTime " + DateUtils.dtts(new Date()));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("杂质过滤器在Servlet的请求前执行...");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("杂质过滤器销毁 - DateTime "+DateUtils.dtts(new Date()));
    }
}
