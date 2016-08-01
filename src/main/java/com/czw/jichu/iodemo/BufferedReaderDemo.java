package com.czw.jichu.iodemo;
import java.io.*;
/*
 * �û���ȥ�ṩ��һ��һ�ζ�һ�еķ���
 * readline()
 * ������null�Ǳ�ʾ�����ļ�ĩβ
 * */
public class BufferedReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//����һ����ȡ��������ļ������
		FileReader fr=new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf.txt");
		BufferedReader bufr=new BufferedReader(fr);
		
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		bufr.close();
		
	}

}
