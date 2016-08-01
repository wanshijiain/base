package com.czw.jichu.iodemo;

import java.io.FileWriter;

/*
 * �������ļ���������д
 * */
public class FileWriterDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try{
			fw=new FileWriter("demo.txt",true);
			//E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\Demo.txt
			fw.write("nihao\r\nxiexie");//linux����ֱ��\nֱ�ӻ��У���windows����Ҫ    \r\n   ��������˳���ܵߵ�
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				fw.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
