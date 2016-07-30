package com.czw.jichu.filemessage;

import java.util.Arrays;

/*
 * ���룺�ַ�������ֽ�����
 * 
 * ���룺�ֽ��������ַ���
 * charsetName �����
 * String-->byte[]; str.getBytes(charsetName);
 * byte[]-->String:new String(byte[],charsetName);
 * */
public class EncodeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String s="���";
		byte[] b1=s.getBytes("GBK");//�������
		System.out.println(Arrays.toString(b1));
		String str1=new String(b1,"ISO8859-1");//������ˣ�����ŷ�ޱ����
		//��ISO8859-1���Խ������������UTF-8���ؽ��ǻ��ǳ������롣
		byte[] b2=str1.getBytes("ISO8859-1");
		System.out.println(Arrays.toString(b2));
		String str2=new String(b2,"GBK");
		
		//��Ȼ��UTF-8����GBK���������ʱ�����������������ô��ô�����������������
		
		System.out.println(str2);
	}

}
