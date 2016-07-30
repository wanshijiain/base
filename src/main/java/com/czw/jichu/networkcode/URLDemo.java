package com.czw.jichu.networkcode;

import java.net.*;

public class URLDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws MalformedURLException {
		// TODO Auto-generated method stub
		URL url=new URL("http://user.qzone.qq.com/855010303/blog/1368173366?referer=hot_topic");
		
		System.out.println("getFile():\t"+url.getFile());
		System.out.println("getHost():\t"+url.getHost());
		System.out.println("getPath():\t"+url.getPath());
		System.out.println("getPort():\t"+url.getPort());
		/*if(port==-1)
		 * 	port=80;
		 * ���ϵͳ����-1Ӧ��Ϊ��ָ��һ��Ĭ�϶˿�*/
		System.out.println("getDefaultPort():\t"+url.getDefaultPort());//��ȡĬ�϶˿�
		System.out.println("getQuery():\t"+url.getQuery());
		System.out.println("getProtocol():\t"+url.getProtocol());

	}

}
/*
 *   getDefaultPort() 
	          ��ȡ��� URL ����Э���Ĭ�϶˿ںš� 
	 String getFile() 
	          ��ȡ�� URL ���ļ����� 
	 String getHost() 
	          ��ȡ�� URL ����������������ã��� 
	 String getPath() 
	          ��ȡ�� URL ��·�����֡� 
	 int getPort() 
	          ��ȡ�� URL �Ķ˿ںš� 
	 String getProtocol() 
	          ��ȡ�� URL ��Э�����ơ�
	 getQuery() 
                  ��ȡ�� URL �Ĳ�ѯ���֡� 

 * */
