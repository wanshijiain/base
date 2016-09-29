package com.czw.web.main.action;

import com.czw.web.main.bean.Person;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZeviChen
 * @Date 2016-08-08 13:45:22
 */
@Controller
@RequestMapping("index")
public class IndexAction extends BaseAction{
	
	@RequestMapping
	public String execute(){
		return "index/index";
	}
	
	@RequestMapping("/pt")
	public String postIndex(Model model, @RequestParam("person")Person person, HttpServletRequest request){
		System.out.println(person);
		System.out.println(person.getUserName());
		model.addAttribute("person",person);
		return "index/pt";
	}
	
}
