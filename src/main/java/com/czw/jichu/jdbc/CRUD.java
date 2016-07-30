package com.czw.jichu.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class CRUD {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		read();
	}
	static void read(String name,Date birthday,float money)throws Exception{
		Connection conn = null;
//		Statement st = null;
		PreparedStatement ps = null;
		String sql = "insert student(name,money,brithday) values(?,?,?)";
		ResultSet rs = null;
		
		
		
		try {
			conn = Utils.getConnection();
			System.out.println("�����ˣ�");
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);//�滻����һ������������ַ�
			ps.setDate(3, new java.sql.Date(birthday.getTime()));//�����������utils���еģ���sql�е�date�̳���utils�����ܰѸ��ำ������
			//����ʹ�����ַ������õ�sql��date������
			ps.setFloat(2, money);
			
			
			rs = ps.executeQuery("select * from student");
			while(rs.next()){
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));	
			}
			
		} finally {
			Utils.free(rs, ps, conn);	
		}
	}

}
