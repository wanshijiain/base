package com.czw.jichu.filemessage;
import java.io.*;
import java.util.*;
/*
 * 	SequenceInputStream(Enumeration<? extends InputStream> e) 
               ͨ����ס��������ʼ���´����� SequenceInputStream���ò�����������������ʱ����Ϊ InputStream ����� Enumeration �Ͳ����� 
	SequenceInputStream(InputStream s1, InputStream s2) 
               ͨ����ס��������������ʼ���´����� SequenceInputStream������˳���ȡ�������������ȶ�ȡ s1��Ȼ���ȡ s2�������ṩ�Ӵ� SequenceInputStream ��ȡ���ֽڡ� 

 * */
public class SequenceInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		Vector<FileInputStream> v=new Vector<FileInputStream>();
		v.add(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\Sequence\\1.txt"));
		v.add(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\Sequence\\2.txt"));
		v.add(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\Sequence\\3.txt"));
		Enumeration<FileInputStream> en=v.elements();
		SequenceInputStream sis=new SequenceInputStream(en);
		
		FileOutputStream fos=new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\Sequence\\4.txt");
		byte[] buf=new byte[1024];
		int len=0;
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);//sis��������ȡ����ͨ��������߳�ͬ����д��fos��Ӧ���ļ��С�
		}
		fos.close();
		sis.close(); 
		
	}

}
