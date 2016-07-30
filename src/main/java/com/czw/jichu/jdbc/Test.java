package com.czw.jichu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test{
	public static void main(String [] args){
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=mystudent";
		String userName = "sa";
		String userPwd = "czw246512";
		try{
			Class.forName(driverName);
			Connection dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("不知道之前写的是什么鬼编码，现在看不到了");
			
		}catch(Exception e){
			System.out.println("不知道之前写的是什么鬼编码，现在看不到了");
			e.printStackTrace();
		}
	}
}