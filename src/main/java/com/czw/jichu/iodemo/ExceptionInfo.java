package com.czw.jichu.iodemo;
import java.util.*;
import java.io.*;
import java.text.*;
public class ExceptionInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int[] arr=new int[2];
			System.out.println(arr[3]);
			
		}catch(Exception e)
		{
			try{
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�˴�HH��24Сʱ�Ƶģ�hh��12Сʱ�Ƶ�
				String s=sdf.format(d);
				PrintStream ps=new PrintStream("exception.log");
				ps.println(s);
				System.setOut(ps);//�ı�Ŀ�ģ����쳣д��exception�쳣�У�������ʱ��
//				e.printStackTrace();
			}catch(IOException ex)
			{
				throw new RuntimeException("��־�ļ�����ʧ��");
			}
			e.printStackTrace();
		}
	}

}

/*
 * log4j������Է���Ĵ洢��־�ļ�
 * */




