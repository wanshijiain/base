package com.czw.web.main.action;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.czw.web.main.bean.Person;
import com.czw.web.main.service.UserService;

/**
 * 
 * @author ZeviChen
 * @Date 2016-08-08 10:28:24
 */
@Controller
@RequestMapping("/ehcache")
public class EhcacheAction {
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping
	public String index(Model model,String id){
		try {
			Integer rdm = userServiceImpl.getById(id);
			model.addAttribute("rdm",rdm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "ehcache/index";
	}

	
	
	
	
	
	
	
	
	
	
}
