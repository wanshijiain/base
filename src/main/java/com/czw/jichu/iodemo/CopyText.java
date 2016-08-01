package com.czw.jichu.iodemo;
/*
 * ��һ���ļ����Ƶ���һ���ļ��С�
 * 1.����һ���ļ����ڴ�������
 * 2.�����ȡ�����ļ�����
 * 3.ͨ�����϶�д������ݴ洢
 * 4.�ر���Դ
 * */
import java.io.*;
public class CopyText {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//copy1();
		copy2();
	}
	public static void copy2() throws Exception
	{
		FileReader fr=null;
		FileWriter fw=null;
		try
		{
			fw=new FileWriter("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\FileReaderDemo_copy2.txt");
			fr=new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\FileReaderDemo.java");
			char[] buf=new char[1024];
			int len=0;
			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
			}
		}catch(Exception e)
		{
			throw new RuntimeException("��дʧ��");
		}
		finally
		{
			if(fr!=null)
				try{
						fr.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
			if(fw!=null)
				try{
					fw.close();					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
		}
	}
	
	
	public static void copy1()throws IOException
	{
		//����Ŀ�ĵ�
		FileWriter fw=new FileWriter("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\FileReaderDemo_copy.txt");
		//�������ļ�����
		FileReader fr=new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\FileReaderDemo.java");
		int ch=0;
		while((ch=fr.read())!=-1)
		{
			fw.write(ch);
		}
		
		fw.close();
		fr.close();
	}

}
