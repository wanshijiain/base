package com.czw.web.main.service.impl;

import java.text.ParseException;
import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.czw.util.DateUtils;
import com.czw.web.main.bean.Person;
import com.czw.web.main.service.UserService;

/**
 * @author ZeviChen
 * @Date 2016-08-08 14:16:17
 */
@Service
public class UserServiceImpl implements UserService {
	Person p = new Person();
	@Override
	@Cacheable(value="testCache",key="'get'")
	public Person getById(String id) throws ParseException {
		
		if(id.equals("1")){
			p.setUserName("张三");
			p.setDatetime(DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		}
		else if(id.equals("2")){
			p.setUserName("李四");
			p.setDatetime(DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		}
		else{
			p.setAddress("没有");
			p.setDatetime(DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		}
		return p;
	}
	
	
}
