package com.czw.orm.mybatis.user;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.orm.mybatis.domain.User;
import com.czw.util.DateUtils;
import com.czw.util.MybatisUtils;

/**
 * @author ZeviChen
 * @Date 2016-08-30 14:28:52
 */
public class UserTest {

	private SqlSession session = MybatisUtils.getSession();

	@Test
	@Ignore
	public void getUser() throws IOException {
		User user = session.selectOne("mybatis.User.getUser", 1);
		System.out.println(user);
	}

	@Test
	@Ignore
	public void insert() {
		User user = new User();
		user.setAge(41);
		user.setName("张平");
		user.setRegTime(DateUtils.dtts(new Date()));
		user.setPassword("484greg4");

		session.insert("mybatis.User.insert", user);

		session.commit();
		session.close();
	}

	@Test
	@Ignore
	public void update() {
		User user = new User();
		user.setId(4);
		user.setPassword("mdzz");
		session.update("mybatis.User.updatePassword", user);
		session.commit();
		session.close();

	}

	@Test
	@Ignore
	public void delete() {
		int id = 5;
		session.delete("mybatis.User.delete", id);
		session.commit();
		session.close();

	}

	@Test
	@Ignore
	public void getAdultUser() {
		User user = new User();
		user.setName("张%");
		List<User> userList = session.selectList("mybatis.User.getAdultUser", user);
		for (User u : userList) {
			System.out.println(u);
		}

	}

	/**
	 * 当条件不成立就不会存在where条件，从而查找所有值
	 */
	@Test
	// @Ignore
	public void whereTest() {
		User user = new User();
		// user.setName("张%");
		List<User> userList = session.selectList("mybatis.User.getUserByName", user);
		for (User u : userList) {
			System.out.println(u);
		}

	}

}
