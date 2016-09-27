package com.czw.web.servlet.action;

import com.czw.web.servlet.BaseAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZeviChen ${datetime}
 */
public class SkipUploadAction extends BaseAction {
    @Override
    public String dispose(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/jsp/servlet/upload.jsp").forward(req,resp);
        } catch (ServletException|IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
