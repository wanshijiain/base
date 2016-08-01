package com.czw.jichu.jdbc.dao.impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.czw.jichu.jdbc.JdbcUtils;
import com.czw.jichu.jdbc.dao.UserDao;
import com.czw.jichu.jdbc.domain.User;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public class UserDaoSpringImpl implements UserDao {
	private NamedParameterJdbcTemplate simpleJdbcTemplate = new NamedParameterJdbcTemplate(
			JdbcUtils.getDataSource());

	public void addUser(User user) {
		String sql = "insert into user (name, money, birthday) values (:name, :money, :birthday)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		this.simpleJdbcTemplate.getNamedParameterJdbcOperations().update(sql,
//				param, keyHolder);  
		user.setId(keyHolder.getKey().intValue());
	}

	public void delete(User user) {
		String sql = "delete from user where id=?";
		SqlParameterSource sps = new EmptySqlParameterSource();//user.getId()
		this.simpleJdbcTemplate.update(sql, sps);
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser(String loginName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	/*public User findUser(String loginName, String password) {
		String sql = "select id, name, money, birthday  from user where name=?";
		return this.simpleJdbcTemplate.queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				loginName);
	}

	public User getUser(int userId) {
		String sql = "select id, name, money, birthday  from user where id=?";
		return this.simpleJdbcTemplate.queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.,
				userId);
	}

	public void update(User user) {
		String sql = "update user set name=?, birthday=?, money=? where id=? ";
		this.simpleJdbcTemplate.update(sql, user.getName(), user.getBirthday(),
				user.getMoney(), user.getId());

		sql = "update user set name=:name, birthday=:birthday, money=:money where id=:id ";
		this.simpleJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(
				user));
	}*/

}
