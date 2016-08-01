package com.czw.jichu.iodemo;
/*
 * ������Ӳ���ϣ�����һ���ļ���д��һЩ�������� 
 * 
 * �����е��ļ�����д
 * */
import java.io.*;
public class FileWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		/*
		//����һ��FileWriter���󣬸ö���һ����ʼ���ͱ���Ҫ��ȷһ���������Ķ���
		//���Ҹ��ļ��ᱻ������ָ��Ŀ¼�£������Ŀ¼����ͬ���ļ��������ǡ�
		//��ȷ����Ҫ��ŵ�Ŀ�ĵء�
		FileWriter fw=new FileWriter("demo.txt");
		
		fw.write("abcde");
		fw.flush();//ˢ��
		fw.close();//ˢ�²��ر���
		*/
		FileWriter fw=null;
		try
		{
			fw=new FileWriter("demo.txt");//�˴������׳�FileNotFoundException
			fw.write("acajgri");
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		finally//�������ն���ִ�еĳ�����������棬�عˣ���
		{
			try{
				if(fw!=null)//���Ŀ¼���ڣ��Ͳ����׳�NullPointerException
					fw.close();
			}catch(IOException ex)
			{
				System.out.println(ex.toString());
			}
		}
	}

}
