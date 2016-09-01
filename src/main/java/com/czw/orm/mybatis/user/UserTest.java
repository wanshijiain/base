package com.czw.orm.mybatis.user;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
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
//	@Ignore
	public void getUser() throws IOException{
		User user = session.selectOne("mybatis.User.getUser",1);
		System.out.println(user);
	}
	
	@Test
	@Ignore
	public void insert(){
		User user = new User();
		user.setAge(18);
		user.setName("Jack");
		user.setRegTime(DateUtils.dtts(new Date()));
		user.setPassword("485jack");
		
		session.insert("mybatis.User.insert", user);
		
		session.commit();
		session.close();
	}
	
	@Test
	@Ignore
	public void update(){
		User user = new User();
		user.setId(4);
		user.setPassword("mdzz");
		session.update("mybatis.User.updatePassword", user);
		session.commit();
		session.close();
		
	}
	
	@Test
	@Ignore
	public void delete(){
		int id = 5;
		session.delete("mybatis.User.delete",id);
		session.commit();
		session.close();
		
	}
	
	
	
	
}
