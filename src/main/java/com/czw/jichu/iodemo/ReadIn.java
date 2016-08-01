package com.czw.jichu.iodemo;
/*
 * ��ȡ����¼��
 * System.out:��Ӧ��׼������豸������̨
 * System.in:��Ӧ��׼�������豸������
 * 
 * 
 * InputStreamReader�����Լ�ָ�����������ȡ�ļ�
 * OutputStreamWriterҲһ��
 * 
 * 
 * System.setIn(InputStream is)//���Ըı�Ĭ��Դ
 * 		���磺System.setIn(new FileInputStream("a.txt"));//Դ�Ӽ���¼��ó���a.txt�ļ�����
 * System.setOut(PrintStream ps)//���Ըı�Ĭ��Ŀ��
 * 		���磺System.setOut(new PrintStream("z.txt"));//Ŀ�Ĵӿ���̨�����z.txt��ʾ
 * 
 * */
import java.io.*;
public class ReadIn {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		InputStream in=System.in;
//		int by=in.read();
//		System.out.println(by);
		StringBuilder sb=new StringBuilder();
		while(true)
		{
			int ch=in.read();
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				String s=sb.toString();
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());
//				sb=new StringBuilder();
				sb.delete(0, sb.length());  
				
			}
			else
				sb.append((char)ch);
		}
	}
	
}
