package com.czw.web.main.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZeviChen ${datetime}
 */
@Controller
@RequestMapping("main/freemarker")
public class FreemarkerAction {

    @RequestMapping("test")
    public String test(Model model){
        model.addAttribute("message","send some msgs");
        model.addAttribute("name","张三");
        return "test";
    }

}
