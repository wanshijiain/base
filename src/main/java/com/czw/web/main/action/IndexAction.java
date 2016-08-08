package com.czw.web.main.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZeviChen
 * @Date 2016-08-08 13:45:22
 */
@Controller
public class IndexAction {
	
	@RequestMapping("/")
	public String index(){
		return "index/index";
	}
	
}
