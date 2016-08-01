package com.czw.jichu.filemessage;
/*
 * ByteArrayInputStream: �ڹ����ʱ����Ҫ����һ����������Դ
 * ByteArrayOutputStream  
 * 		�����������󶼲��ù������ڲ���װ�˿ɱ䳤���飬������ȷ����Ŀ�ġ�
 * 
 * CharArrayReader  CharArrayWriter
 * 
 * StringReader StringWriter
 * 
 * */
import java.io.*;
public class ByteArrayStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteArrayInputStream bis=new ByteArrayInputStream("ABCDEFG".getBytes());
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		int ch=0;
		while((ch=bis.read())!=-1)
		{
			bos.write(ch);
		}
		System.out.println(bos.toString());;
		
//		bos.writeTo(new FileWriter("x.txt"));���䳤�����е�����һ���Դ洢���ļ��С�
	}

}
