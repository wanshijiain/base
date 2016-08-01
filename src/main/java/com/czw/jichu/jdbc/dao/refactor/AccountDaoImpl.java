package com.czw.jichu.jdbc.dao.refactor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.czw.jichu.jdbc.domain.Account;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public class AccountDaoImpl extends AbstractDao {
	public Account findAccount(int id) {
		String sql = "select id, name, money from account where id=?";
		Object[] args = new Object[] { id };
		Object account = super.find(sql, args);
		return (Account) account;
	}

	@Override
	protected Object rowMapper(ResultSet rs) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("id"));
		// ...
		return a;
	}

}
