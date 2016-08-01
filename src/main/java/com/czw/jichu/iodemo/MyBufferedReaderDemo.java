package com.czw.jichu.iodemo;
import java.io.*;
/*
 * readLine��ԭ��
 * */

public class MyBufferedReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf.txt");
		MyBufferedReader mybuf=new MyBufferedReader(fr);
		String line=null;
		while((line=mybuf.myReadLine())!=null)
		{
			System.out.println(line);
			
		}
		mybuf.myClose();
	}

}
/*
 * װ��ģʽ�ȼ̳�ģʽ�������˼̳���ϵӷ��
 * ���ҽ�����������֮�����ϵװ����ͱ�װ����ͨ��������һ����ϵ
 * MyReader//ר�����ڶ�ȡ���ݵ���
 * 		|--MyTextReader
 * 		|--MyDateReader
 * 		|--MyMediaReader
 * 		|--MyBufferedReader//ͨ�����ַ�ʽ��Ϊ�������ӵ����������ṩ������ʱ������Ҫ��������Ļ��������ͣ��������չ��
 * */
class MyBufferedReader extends Reader
{
	private Reader r;
	MyBufferedReader(Reader r)//
	{
		this.r=r;
	}
	public void close()throws IOException//��дReader�ĳ��󷽷�
	{
		r.close();
	}
	public void myClose()throws IOException//�Լ�д�Ĺر�������
	{
		r.close();
	}
	public int read(char[] cbuf,int off,int len)throws IOException
	{
		return r.read(cbuf,off,len);
	}
	public String myReadLine()throws IOException
	{
		StringBuilder sb=new StringBuilder(); 
		int ch=0;
		while((ch=r.read())!=-1)
		{
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		if(sb.length()!=0)
			return sb.toString();//����ļ����û��\r\n�����ڻ�����û�з��أ����ܻᶪʧ���ݣ�����ʹ�ø÷�ʽ
		return null; 
	}
}
