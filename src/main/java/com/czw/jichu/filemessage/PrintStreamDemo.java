package com.czw.jichu.filemessage;
/*
 * �ֽڴ�ӡ��
 * PrintStream
 * ���캯�����Խ��ܵĲ�������
 * 1.file����File
 * 2.�ַ���·����String
 * 3.�ֽ��������OutputStream
 * 5.ָ���ַ�����csn
 * 
 * �ַ���ӡ��
 * PrintWriter
 * ���캯�����Խ��ܵĲ�������
 * 1.file����File
 * 2.�ַ���·����String
 * 3.�ֽ��������OutputStream(����֮��������ַ���������Խ����ֽ���)
 * 4.�ַ��������Writer(�����治֮ͬ��)
 * 5.ָ���ַ�����csn
 * 
 * */
import java.io.*;
public class PrintStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr=
				new BufferedReader(new InputStreamReader(System.in));
		
//		PrintWriter out=new PrintWriter(System.out,true);//autoflushΪtrue���Զ�ˢ�£���ҪЩ���ļ���ʱ��System.outĿ�ĸĵ�����
		PrintWriter out=new PrintWriter(new FileWriter("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\a.txt"),true);//new FileWriter("a.txt"),true
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
//			out.write(line.toUpperCase());
//			out.flush();
			out.println(line.toUpperCase());
			
			
		}
		out.close();
		bufr.close();
	}

}
