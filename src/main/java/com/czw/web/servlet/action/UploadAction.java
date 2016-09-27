package com.czw.web.servlet.action;

import com.czw.web.servlet.BaseAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author ZeviChen ${datetime}
 */
public class UploadAction extends BaseAction {
    @Override
    public String dispose(HttpServletRequest req, HttpServletResponse resp) {
        try {
            for(Part part : req.getParts()){
                String filePath = "d:\\tmp"+"\\"+part.getName()+".txt";
                part.write(filePath);
            }

            resp.setContentType("application/json");
            resp.setStatus(200);
        } catch (IOException|ServletException e) {
            e.printStackTrace();
        }
        return null;
    }
}
