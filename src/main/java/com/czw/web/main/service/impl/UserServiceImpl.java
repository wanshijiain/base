package com.czw.web.main.service.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.czw.web.main.dao.UserDao;
import com.czw.web.main.service.UserService;

/**
 * @author ZeviChen
 * @Date 2016-08-08 14:16:17
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Cacheable(value="testCache",key="#id")
	public Integer getById(String id) throws ParseException {
		return userDao.getById("1");
	}

	
	
}
