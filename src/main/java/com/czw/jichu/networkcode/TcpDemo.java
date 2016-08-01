package com.czw.jichu.networkcode;
/*
 * �ͻ��ˣ�
 * 
 * ����ˣ�
 * 1.��������˵�socket����  ServerSocket����
 * 		������һ���˿ڡ�
 * 2.��ȡ���ӹ����Ŀͻ��˶���
 * 		ͨ��ServerSocket��accept����  ����ʽ����
 * 3.�ͻ���������͹������ݣ���ô������Ҫʹ�ö�Ӧ�Ŀͻ��˶����ȡ�ö���Ķ�ȡ����ȡ���͹���������
 * 4.�رշ���ˡ�����ѡ��
 * 
 * SocketAddress�ǳ����࣬����Դ���������+�˿ں�  ������InetSocketAddress
 * 
 * ServerSocket(port,backlog)�����ͬʱ���ӵ����client����
 * 
 * */
import java.io.*;
import java.net.*;
public class TcpDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s=new Socket("10.101.2.235",10003);
		OutputStream out=s.getOutputStream();
		
		out.write("����ˣ����".getBytes());
		
		InputStream in=s.getInputStream();
		
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		
		System.out.println(new String(buf,0,len));
		s.close();
	}

}
class TcpServer{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss=new ServerSocket(10003);
		
		Socket s=ss.accept();
		
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		InputStream in=s.getInputStream();
		byte[] buf=new byte[1024];
		int len=in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		OutputStream out=s.getOutputStream();
		out.write("�յ�����á�".getBytes());
		
		s.close();
	}
}
