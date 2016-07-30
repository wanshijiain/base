package com.czw.jichu.jdbc.service;

import com.czw.jichu.jdbc.dao.UserDao;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public class UserService {
	private UserDao userDao;

	public void regist(com.czw.jichu.jdbc.domain.User user) {
		this.userDao.addUser(user);
		// sendMail.send(user);
	}
}
