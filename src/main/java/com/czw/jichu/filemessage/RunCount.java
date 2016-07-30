package com.czw.jichu.filemessage;
/*
 * ���ڼ�¼Ӧ�ó�������д�����
 * ���ʹ�ô����Ѿ����ˣ���ô����ע����ʾ��
 * 
 * ����һ�������ļ�����¼�����ʹ�ô�����
 * 
 * map+io-->Properties
 * �����ļ�����ʵ��Ӧ�ó���Ĺ���
 * 
 * dom4j =  dom for java//��ȡxml�е������ļ���Ϣ  
 * 
 * */
import java.util.*;
import java.io.*;
public class RunCount {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		
		File file=new File("E:\\JAVA\\��Ŀ\\Test\\src\\count.ini");
		if(!file.exists())
			file.createNewFile();
		FileInputStream fis=new FileInputStream(file);
		
		prop.load(fis);
		
		int count=0;
		String value=prop.getProperty("time");
		if(value!=null)
		{
			count=Integer.parseInt(value);
			if(count>=5)
				System.out.println("���ã�ʹ�ô����ѵ�����Ǯ��");
		}
		count++;
		
		prop.setProperty("time", count+"");
		FileOutputStream fos=new FileOutputStream(file);
		
		prop.store(fos, "zuijinxiugai");
		
		fos.close();
		fis.close();
	}

}
