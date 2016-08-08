package com.czw.web.main.service;

import java.text.ParseException;

import com.czw.web.main.bean.Person;

/**
 * @author ZeviChen
 * @Date 2016-08-08 14:15:46
 */
public interface UserService {
	/**
	 * 通过id获取person
	 * @param id
	 */
	Integer getById(String id) throws ParseException;
}
