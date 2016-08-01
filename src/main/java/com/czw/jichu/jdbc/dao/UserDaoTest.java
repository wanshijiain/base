package com.czw.jichu.jdbc.dao;

import java.util.Date;

import com.czw.jichu.jdbc.domain.User;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public class UserDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao userDao = DaoFactory.getInstance().getUserDao();
		// UserDao userDao = new UserDaoJdbcImpl();
		// System.out.println(userDao);
		//		
		User user = new User();
		user.setBirthday(new Date());
		user.setName("dao name2");
		user.setMoney(1000.0f);

		userDao.addUser(user);
		System.out.println(user.getId());

		// User u = userDao.findUser(user.getName(), null);
		// System.out.println(u.getId());

		// User u = userDao.getUser(7);
		// u.setMoney(20000.1f);
		// userDao.update(u);

		// User u1 = userDao.getUser(8);
		// userDao.delete(u1);

	}

}
