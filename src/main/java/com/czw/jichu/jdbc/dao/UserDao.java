package com.czw.jichu.jdbc.dao;

import com.czw.jichu.jdbc.domain.User;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public interface UserDao {
	public void addUser(User user);

	public User getUser(int userId);

	public User findUser(String loginName, String password);

	public void update(User user);

	public void delete(User user);

}
