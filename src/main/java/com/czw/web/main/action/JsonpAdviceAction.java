package com.czw.web.main.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 支持跨域请求
 * @author ZeviChen ${datetime}
 */
@ControllerAdvice
public class JsonpAdviceAction extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdviceAction() {
        super("callback");
    }
}
