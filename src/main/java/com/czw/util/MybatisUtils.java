package com.czw.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author ZeviChen
 * @Date 2016-08-30 15:19:18
 */
public class MybatisUtils {
	
	private static Reader reader;
	private static SqlSessionFactory factory;
	private static SqlSession session = null;
	
	static{
		try {
			reader = Resources.getResourceAsReader("com/czw/orm/mybatis/mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		factory = new SqlSessionFactoryBuilder().build(reader);
		session = factory.openSession();
	}
	
	public static SqlSession getSession(){
		return session;
	}
	
	
}
