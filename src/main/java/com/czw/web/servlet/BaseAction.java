package com.czw.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZeviChen ${datetime}
 */
public abstract class BaseAction {
    protected static Logger log = LoggerFactory.getLogger(BaseAction.class);

    /**
     * Action都需要实现的处理方法,公共处理方法
     * @return
     */
    public abstract String dispose(HttpServletRequest req, HttpServletResponse resp);




}
