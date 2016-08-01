package com.czw.jichu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Utils {
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName = mystudent";
	private static String user = "sa";
	private static String password = "czw246512";
	private Utils(){
	}
	
	private static Utils instance = new Utils();
	public static Utils getInstance1(){
		return instance;
	}
	
	public static Utils getInstance2(){
		if(instance == null){
			synchronized(Utils.class){
				if(instance == null){
					instance = new Utils();
				}
			}
		}
		return instance;
	}
	
	
	static {
		try {
			Class.forName("com.sqlserver.jdbc.SQLServerDriver");
		} catch (Exception e) {
		}
		System.out.println("不知道之前写的是什么鬼编码，现在看不到了");
	}
	public static Connection getConnection()throws SQLException{
		System.out.println("不知道之前写的是什么鬼编码，现在看不到了");
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void free(ResultSet rs,Statement st,Connection conn){
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){
				e.printStackTrace();
		}
		finally{
				try{
					if(st != null)
						st.close();
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					if(conn != null)
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		}
	}
	
}
