package com.czw.jichu.jdbc.dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.czw.jichu.jdbc.domain.User;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public class UserDaoImpl extends AbstractDao {

	public User findUser(String loginName, String password) {
		String sql = "select id, name, money, birthday  from user where name=?";
		Object[] args = new Object[] { loginName };
		Object user = super.find(sql, args);
		return (User) user;
	}

	public String findUserName(int id) {
		String sql = "select  name from user where id=?";
		Object[] args = new Object[] { id };
		Object user = super.find(sql, args);
		return ((User) user).getName();
	}

	protected Object rowMapper1(ResultSet rs) throws SQLException {
		return rs.getString("name");
	}

	protected Object rowMapper(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setMoney(rs.getFloat("money"));
		user.setBirthday(rs.getDate("birthday"));
		return user;
	}

	public void delete(User user) {
		String sql = "delete from user where id=?";
		Object[] args = new Object[] { user.getId() };
		super.update(sql, args);
	}

	public void update(User user) {
		String sql = "update user set name=?, birthday=?, money=? where id=? ";
		Object[] args = new Object[] { user.getName(), user.getBirthday(),
				user.getMoney(), user.getId() };
		super.update(sql, args);
	}
}
