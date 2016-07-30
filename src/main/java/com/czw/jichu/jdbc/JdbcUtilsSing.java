package com.czw.jichu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Zevi Chan
 * @Date 2016年7月5日
 */
public final class JdbcUtilsSing {
	private String url = "jdbc:mysql://localhost:3306/jdbc";
	private String user = "root";
	private String password = "";

	// private static JdbcUtilsSing instance = new JdbcUtilsSing();
	private static JdbcUtilsSing instance = null;

	private JdbcUtilsSing() {
	}

	public static JdbcUtilsSing getInstance() {
		if (instance == null) {
			synchronized (JdbcUtilsSing.class) {
				if (instance == null) {
					instance = new JdbcUtilsSing();
				}
			}
		}
		return instance;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void free(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
}
