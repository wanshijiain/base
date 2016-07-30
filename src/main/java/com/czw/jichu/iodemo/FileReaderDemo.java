package com.czw.jichu.iodemo;
import java.io.*;
public class FileReaderDemo {

	/**
	 * @param args
	 */
	//Ӧ������FileWriterDemo�еķ�ʽ���׳��쳣���˴�ʡ��
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("Demo.txt");//�ļ������ڻ��׳�FileNotFoundException
		//����һ���ַ�����
		char[] buf=new char[13];
		int num=fr.read(buf);
		
		System.out.println("num="+num+"...buf="+new String(buf));
		/*
		while(true)
		{
			int ch=fr.read();
			if(ch==-1) break;
			//read����һ�ζ�һ���ַ���ָ��ָ����һ���ַ�
			System.out.println("ch="+(char)ch);
		}
		*/
		fr.close();
		
	}

}
