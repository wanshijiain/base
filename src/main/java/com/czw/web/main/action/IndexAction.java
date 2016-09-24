package com.czw.web.main.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.czw.web.main.bean.Person;

/**
 * @author ZeviChen
 * @Date 2016-08-08 13:45:22
 */
@Controller
@RequestMapping("main/index")
public class IndexAction {
	
	@RequestMapping
	public String index(){
		return "index/index";
	}
	
	@RequestMapping("/pt")
	public String postIndex(Model model,@RequestParam("person")Person person){
		System.out.println(person);
		System.out.println(person.getUserName());
		model.addAttribute("person",person);
		return "index/pt";
	}
	
}
