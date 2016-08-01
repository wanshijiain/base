package com.czw.jichu.iodemo;
/*
 * �������ĳ�����Ϊ���������Ч��
 * �����ڻ�����֮ǰ����Ҫ��������
 * */
import java.io.*;
public class BufferedWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//����һ���ַ���д�����
		FileWriter fw=new FileWriter("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf.txt");
		//Ϊ������ַ�д������Ч�ʣ������˻��弼����
		//��Ҫ���Ч�ʵ���������Ϊ�������ݸ�������
		BufferedWriter bufw=new BufferedWriter(fw);
		
		for(int x=1;x<5;x++)
		{
			bufw.write("abcd"+x);
			bufw.newLine();//��ƽ̨�Ļ��з���
			bufw.flush();
		}
		
		
		//��ʵ�رջ����������ڹرջ������е�������
		bufw.close();
		//fw.close();���Դ˷�������д
	}

}
