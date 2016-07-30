package com.czw.jichu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Base {

	public static void main(String[] args) throws Exception{
		test();
//		System.out.println("fjewofheroghro");
		//		template();
		
//		for (int i = 0; i < 10; i++) {
//			Connection conn = JdbcUtils.getConnection();
//			System.out.println(conn.getClass().getName());
//			JdbcUtils.free(null, null, conn);
//		}
		
	}
	static void template()throws Exception{

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Utils.getConnection();
			System.out.println("不知道之前写的是什么鬼编码，现在看不到了");
			ps = conn.prepareStatement("select * from student;");
			System.out.println(ps.execute("select * from student;"));
			
//			while(rs.next()){
//				System.out.println(rs.getString(1) + "\t" + rs.getString(2)+"不知道之前写的是什么鬼编码，现在看不到了");
//				
//			}
			
			
		} finally {
			Utils.free(rs, ps, conn);
			
		}
		
	}
	
	static void test()throws Exception
	{	
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//System.setProperty("jdbc.drivers","com.sqlserver.jdbc.SQLServerDriver:com.mysql.jdbc.Driver"); 
//		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		
		System.out.println("--------------1--------------");
		Class.forName("com.mysql.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName = mystudent","sa","czw246512");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/borsys","root","246512");
		//mysql 3306  sqlserver 1433  oracle 1521
		//mysql url   jdbc:mysql://localhost:3306/mystudent
		//oracle url   Class.forName( "oracle.jdbc.driver.OracleDriver" );
		//                  ("jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL", sUsr, sPwd);
		
		PreparedStatement ps =null;
		ResultSet rs = null;
		 
//		System.out.println("-------"); 
//		ps = con.prepareStatement(null);
//		boolean flag = ps.execute("select * from student where stu_id = ?;");
//		ps.setInt(1, 1000); 
//		System.out.println(flag);
		
		 
//		ResultSet rs = ps.executeQuery("select * from student where stu_id=10000");
//		 
//		while(rs.next()){
//			System.out.println(rs.getString(1) + "\t" + rs.getString(2));
//		}
		ps = con.prepareStatement("");
		System.out.println(ps+"1111111111");
		rs = ps.executeQuery("select storesize,borout from library where lib_id = 1000;");
		rs.next();
		int storesize = rs.getInt(1); 
		int borout = rs.getInt(2); 
		System.out.println(storesize+"----"+borout+"---"+rs+"2222222222");
		rs.close();
		rs= ps.executeQuery("select sborsize,sbornum from student where stu_id=10000;");
		System.out.println(rs+"----333333333");
		rs.close();
		 
//		rs.close();
		ps.close();
		con.close();
		
		
		
		
	}

}
