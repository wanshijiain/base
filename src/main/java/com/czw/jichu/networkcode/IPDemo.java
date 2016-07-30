package com.czw.jichu.networkcode;

import java.net.*;
public class IPDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws UnknownHostException{
		// TODO Auto-generated method stub
		InetAddress in=InetAddress.getLocalHost();
		sop("Address:"+in.getHostAddress());
		sop("Name:"+in.getHostName());
		
		/*getByAddress()getByName()getLocalHost()����InetAddress����
		 * 
		 * getHostName()  getHostAddress()����String ���͵���������IP
		 * 
		 * */
	
		InetAddress ia1=InetAddress.getByName("www.baidu.com");
		sop("Address:"+ia1.getHostAddress());
		sop("Name:"+ia1.getHostName());
		
		
		InetAddress[] ia=InetAddress.getAllByName("www.baidu.com");
		for(int i=0;i<ia.length;i++){
			sop("Address:"+ia[i].getHostAddress());
			sop("Name:"+ia[i].getHostName());
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
