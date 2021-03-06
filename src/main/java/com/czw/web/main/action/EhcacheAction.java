package com.czw.web.main.action;

import com.czw.web.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import java.text.ParseException;

/**
 * 
 * @author ZeviChen
 * @Date 2016-08-08 10:28:24
 */
@Controller
@RequestMapping("ehcache")
public class EhcacheAction extends BaseAction{
	@Autowired
	private UserService userServiceImpl;

	//url:localhost/ehcache/ will request this method.
	@RequestMapping
	public String execute(Model model, String id, ServletRequest request) {
		try {
			if (id == null)
				id = "1";
			Integer rdm = userServiceImpl.getById(id);


			model.addAttribute("rdm", rdm);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return "ehcache/index";
	}

}
