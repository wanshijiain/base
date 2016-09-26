package com.czw.web.servlet.action;

import com.czw.web.servlet.BaseAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

            PrintWriter writer = resp.getWriter();
            writer.write("hahha");
            writer.append("中文显示");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
