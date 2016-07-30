package com.czw.jichu.jdbc;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * 
 * 2008-12-7
 * 
 * @author <a href="mailto:liyongibm@gmail.com">liyong</a>
 * 
 * 
 * �����ݿ����ӣ��鿴���ݿ�����ԣ��鿴��Щ���Ի򷽷���ʹ��
 * 
 */
public class DBMD {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		java.sql.Connection conn = JdbcUtils.getConnection();
		DatabaseMetaData dbmd = conn.getMetaData();
		System.out.println("db name: " + dbmd.getDatabaseProductName());
		System.out.println("tx: " + dbmd.supportsTransactions());
		conn.close();
	}

}
