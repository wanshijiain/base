package com.czw.jichu.networkcode;

import java.io.InputStream;
import java.net.*;

public class URLConnectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception//MalformedURLException
	{
		// TODO Auto-generated method stub
		URL url=new URL("http://user.qzone.qq.com/855010303/blog/1368173366?referer=hot_topic");
		//�Դ�Ӧ�ò�Э��
		URLConnection conn=url.openConnection();
		
		InputStream in=conn.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		System.out.println(new String(buf,0,len));
		
		
		
	}

}
