package com.czw.orm.mybatis.user;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.orm.mybatis.domain.User;
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
	
	
	
	
}
