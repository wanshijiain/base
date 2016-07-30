package com.czw.jichu.filemessage;
/*�и��ļ�*/
import java.io.*;
import java.util.*;
public class SplitFile {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		splitFile();
		merge();
	}
	public static void merge()throws Exception
	{
		ArrayList<FileInputStream> al=new ArrayList<FileInputStream>();
		for(int x=1;x<=4;x++)
		{
			al.add(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\splitfiles\\"+x+".part"));
		}
		final Iterator<FileInputStream> it=al.iterator();
		Enumeration<FileInputStream> en=new Enumeration<FileInputStream>()
		{
			//���������ڲ��࣬����Ҫ�Է��ʵľֲ�������������
			public boolean hasMoreElements()
			{
				return it.hasNext();
			}
			public FileInputStream nextElement()
			{
				return it.next();
			}
		};
		SequenceInputStream sis=new SequenceInputStream(en);
		
		FileOutputStream fos=new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\splitfiles\\merge.jpg");
		
		byte[] buf=new byte[1024];
		int len=0;
		while((len=sis.read(buf))!=-1)
		{
			fos.write(buf,0,len);
			
		}
		fos.close();
		sis.close();
		
	}
	public static void splitFile()throws Exception
	{
		FileInputStream fis=new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\split.jpg");
		FileOutputStream fos=null;
		
		byte[] buf=new byte[1024*512];
		
		/*
		 * ��Ҫ�иG�ĵ�Ӱʱ�����弸���׵��ڴ��ǲ���ʵ�ġ�
		 * 1.����������С���䣬���и�����ݴ����ļ�������һ�������������ﵽ100Mʱ��
		 * 2.���¶���һ���ļ�����������ķ������´����ļ���ֱ��������ļ��и���ɡ�
		 * */
		
		int len=0;
		int count=1;
		while((len=fis.read(buf))!=-1)
		{
			fos=new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\splitfiles\\"+(count++)+".part");
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
		
	}

}
