package com.czw.jichu.iodemo;
import java.io.*;
/*LineNumberReader extends BufferedReader
 * 
 * �������������ģ��LineNumberReader�Ĺ��ܣ�������
 * ��ʵ���еı�ǹ���
 * */
public class LineNumberReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf.txt");
		//LineNumberReader lnr=new LineNumberReader(fr);
		MyLineNumberReader mlnr=new MyLineNumberReader(fr);
		String line=null;
		mlnr.setLineNumber(10);//��11��ʼ�����
		while((line=mlnr.myReadLine())!=null)
		{
			System.out.println(mlnr.getLineNumber()+":"+line);
		}
		mlnr.myClose();
	}

}

//��ϰ��ģ��һ�����кŵĻ���������
//Ϊ����ߴ���ĸ�����
class MyLineNumberReader extends MyBufferedReader
{
	private int linenumber; 
	MyLineNumberReader(Reader r)
	{
		super(r);//��ߴ���ĸ����ԣ����Ե��ø���Ĺ��췽��
	}
	public void  setLineNumber(int linenumber)
	{
		this.linenumber=linenumber;
	}
	public int getLineNumber()
	{
		return this.linenumber;
	}
	//����Ļ�����ʹ��read��������ģ��readLine��������ȡһ���ַ�
	public String myReadLine()throws IOException
	{
		linenumber++;
		return super.myReadLine();//��ߴ���ĸ����Կ��Ե��ø���ķ���
	}

}
/*
class MyLineNumberReader
{
	private Reader r;
	private int linenumber; 
	MyLineNumberReader(Reader r)
	{
		this.r=r;
	}
	public void  setLineNumber(int linenumber)
	{
		this.linenumber=linenumber;
	}
	public int getLineNumber()
	{
		return this.linenumber;
	}
	//����Ļ�����ʹ��read��������ģ��readLine��������ȡһ���ַ�
	public String myReadLine()throws IOException
	{
		linenumber++;
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
			return sb.toString();
		return null;
	}
//	public int read(char[] c,int x,int y)
//	{
//		return 1;
//	}
	public void myClose()throws IOException
	{
		r.close(); 
	}
}
*/
