package com.czw.jichu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public class SQLInject {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		// long start = System.currentTimeMillis();
		// for (int i = 0; i < 100; i++)
		read("name1");
		// long end = System.currentTimeMillis();
		// System.out.println("read:" + (end - start));

		// start = System.currentTimeMillis();
		// for (int i = 0; i < 100; i++)
		read1("name1");
		// end = System.currentTimeMillis();
		// System.out.println("read1:" + (end - start));
	}

	static void read(String name) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();

			// conn = JdbcUtilsSing.getInstance().getConnection();
			String sql = "select id, name, money, birthday  from user where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t"
						+ rs.getString("name") + "\t" + rs.getDate("birthday")
						+ "\t" + rs.getFloat("money"));
			}

		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

	static void read1(String name) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			// conn = JdbcUtilsSing.getInstance().getConnection();

			String sql = "select id, name, money, birthday  from user where name='"
					+ name + "'";
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				// System.out.println(rs.getObject("id") + "\t"
				// + rs.getObject("name") + "\t"
				// + rs.getObject("birthday") + "\t"
				// + rs.getObject("money"));
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

}
