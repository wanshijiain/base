package com.czw.web.main.action;

import com.czw.web.main.bean.Person;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

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

	/**
	 * springmvc不管新启的线程的后续处理结果，可用户jms,计划任务(定时器...)
	 * @return
	 */
	@RequestMapping("/quotes")
	@ResponseBody
	public DeferredResult<String> quotes() {
		DeferredResult<String> deferredResult = new DeferredResult<String>();
		// 将 deferredResult 保存到内存队列
		return deferredResult;
	}

	// 在其他线程中...
	//deferredResult.setResult(data);

}
