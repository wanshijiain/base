package com.czw.jichu.iodemo;
/*
 * JVM�������������Ĭ�Ϸ���64M�Ŀռ�
 * 
 * �ַ�����//�������������ı�����
 * 		FileReader FileWriter

 * 		BufferedReader BufferedWriter
 * �ֽ�����//������������ͼ�������
 * 
 * 
 * ������Ҫ����ͼƬ���ݣ��õ��ֽ���
 * FileInputStream�еķ���availab���������ı��е��ַ�����      �س���������  \r\n
 * 
 * //ʹ��fis.available()���Զ���һ���ոպõ��������洢���ݣ�������Ҫͨ��ѭ������ȡ
 * */
import java.io.*;
public class FileStream {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
//		writeFile();
		readFile_3();
	}
	public static void readFile_3()throws IOException
	{
		FileInputStream fis=new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\fos.txt");
//		int num=fis.available();
		
		byte[] buf=new byte[fis.available()];
		System.out.println(buf);
		
		fis.close();
		//�˷�ʽʹ��available�����������ã����ļ������ǻ��������
		
	}
	public static void readFile_2()throws IOException
	{
		FileInputStream fis=new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\fos.txt");
		byte[] buf=new byte[1024];
		int len=0;
		while((len=fis.read(buf))!=-1)
		{
			
			System.out.print(new String(buf,0,len));
		}
		fis.close();
	}
	public static void readFile_1()throws IOException
	{
		FileInputStream fis=new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\fos.txt");
		int ch=0;
		while((ch=fis.read())!=-1)
		{
			System.out.print((char)ch);
		}
		fis.close();
	}
	public static void writeFile()throws IOException
	{	
		FileOutputStream fos=new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\fos.txt");
		fos.write("abcde".getBytes());
		//��Ȼ�ַ�������Ҫˢ�£�������Ҫ�ر���Դ
		fos.close();
	}

}
