package com.czw.jichu.networkcode;

import java.net.*;
import java.io.*;

public class ServerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(11000,10);//ͬʱ���ӵ��������˵����ͻ��˸���
		Socket  s=ss.accept();
		
		System.out.println(s.getInetAddress().getHostAddress());
		InputStream in=s.getInputStream();
		
		byte[] buf=new byte[1024];
		
		int len=in.read(buf);
		System.out.println(new String(buf,0,len));
		
		PrintWriter pwout=new PrintWriter(s.getOutputStream());
		pwout.println("<font color=red size=5>�ͻ������</font>");
		
		
		s.close();
		ss.close();
		
	}

}
