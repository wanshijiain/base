package com.czw.jichu.iodemo;
/*
 * ��ȡ�ļ�����ӡ�ڿ���̨��
 * */
import java.io.*;
public class FileReaderDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\FileWriterDemo.java");
		//��Ϊ���ļ�û�г���
		char[] buf=new char[1024];
		int num=0;
		while((num=fr.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,num));
		}
		fr.close();
			
		
	}

}
