package com.czw.jichu.networkcode;
/*
 * ���󣺽���һ���ı�ת����������
 * �ͻ��˸�����˷����ı�������˻Ὣ�ı�ת���ɴ�д���ظ��ͻ��ˡ�
 * η�ӿͻ��˿��Բ��ϵĽ����ı�ת�������ͻ�������over�ǣ�ת��������
 * 
 * ������
 * �ͻ��ˣ�
 * 		�����豸�ϵ����ݣ��Ϳ���ʹ��io������������io�Ĳ���������˼����
 * Դ������¼�롣
 * Ŀ�ģ������豸�������������
 * ���Ҳ��������ı����ݣ�����ѡ���ַ�����
 * 
 *���裺
 *1.��������
 *2.��ȡ����¼�롣
 *3.�����ݷ�������ˡ�
 *4.���ط������Ĵ�д���ݡ�
 *5.�������ر���Դ��
 *
 *�����ı����ݣ�����ʹ���ַ�����������ͬʱ���С·�����뻺�塣
 * 
 * */

import java.io.*;
import java.net.*;
public class TransTestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s=new Socket("10.101.2.235",10005);
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		
//		BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		PrintWriter pwout=new PrintWriter(s.getOutputStream(),true);
		
		//����һ��socket��ȡ��
		BufferedReader bufin=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		
		String line=null;
		while((line=bufr.readLine())!=null)//readLine()�����ڶ���\n�ǲ�ִ��
		{
//			if("over".equals(line))
//				break;
			pwout.println(line);
//			bufw.write(line);
//			bufw.newLine();
//			bufw.flush();//��ջ������������ݷ���ȥ
			
			String str=bufin.readLine();
			
			System.out.println("server:"+str);
			
			
		}
		
		bufr.close();
		s.close();
		
	}

}
class TransServer{
	public static void main(String[] args)throws Exception
	{
		ServerSocket ss=new ServerSocket(10005);
		Socket s=ss.accept();
		
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"connected...");
		//��ȡsocket��ȡ���е����ݡ�
		BufferedReader bufin=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
//		BufferedWriter bufout=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter pwout=new PrintWriter(s.getOutputStream(),true);
		//ͨ��true��pwout�����Զ�ˢ��
		
		String line=null;
		while((line=bufin.readLine())!=null)
		{
			if("over".equals(line))
				break;
			System.out.println(line);
			
			pwout.println(line.toUpperCase());//PrintWriter���Լ�������������
//			bufout.write(line.toUpperCase());
//			bufout.newLine();
//			bufout.flush();
			
			
		}
		s.close();
		ss.close();
	}
}
