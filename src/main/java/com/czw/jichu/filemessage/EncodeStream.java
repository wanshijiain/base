package com.czw.jichu.filemessage;
/**/
import java.io.*;
public class EncodeStream {

	/**
	 * @param args
	 */
	/*
	 * ��GBK�е�  ���  ��UTF-8�⿪��ʾ     ����
	 * ��UTF-8�е�  ���  ��GBK�⿪��ʾ     佲�
	 * */
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		writeText();
		readText();
	}
	public static void readText()throws IOException
	{
		//ͨ��ת������ָ���������ʽ
		InputStreamReader isr=new InputStreamReader(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\encode_utf.txt"),"UTF-8");
		char[] ch=new char[10];
		int len=isr.read(ch);
		String s=new String(ch,0,len);
		System.out.println(s);
		isr.close();
	}
	public static void writeText()throws Exception
	{
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\encode_utf.txt"),"UTF-8");
		osw.write("���");
		osw.close();
	}
	 

}
