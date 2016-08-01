/*package com.czw.jichu.jdbc.spring;

import com.czw.jichu.jdbc.JdbcUtils;
import com.czw.jichu.jdbc.domain.User;

*//**
 * spring4.x中SimpleJdbcTemplate被取消，NamedParameterJdbcTemplate具有相同的功能
 * @author Zevi Chan
 * @Date 2016年7月5日
 *//*
public class SimpleJdbcTemplateTest {
	static SimpleJdbcTemplate simple = new SimpleJdbcTemplate(JdbcUtils
			.getDataSource());

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static User find(String name) {
		String sql = "select id, name, money, birthday  from user where name=? and money > ?";
		User user = simple.queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				name, 100f);
		return user;
	}


}
*/