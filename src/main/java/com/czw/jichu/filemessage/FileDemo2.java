package com.czw.jichu.filemessage;
/*
 * File.listRoots();//�о��̷�����C�̣�d��
 * f.list(FilenameFilter filter);//�о��̷��е������ļ�(���������ļ�)����ָ���ļ��ǣ�Ŀ¼��Ϊ�գ������Ϊ��ֵ������ֿ�ָ���쳣
 * 		FilenameFilter��һ���ӿ��࣬�ڲ������У�accept(File dir,String name)//��ȡtxt�ļ�
 * 
 * 		ʹ�ã�f.list(new FiltnameFilter(){  public boolean accept(File dir,String name){..�ڲ��жϺ�׺������䶨��..}  });		
 * 
 * f.listFiles();
 * f.listFiles(FileFilter fileFilter);
 * */
import java.io.*;

public class FileDemo2 {
	public static void main(String[] args) {
		listDemo();
//		listDemo2();
//		listFilesDemo();
	}
	public static void listFilesDemo()
	{
		File dir=new File("e:\\JAVA\\");
		File[] files=dir.listFiles();
		for(File f:files)
		{
			sop(f.getName()+"::"+f.length());
		}
	}
	public static void listDemo2()
	{
		File dir=new File("e:\\JAVA\\");
		String[] arr=dir.list(new FilenameFilter()//Ϊ�ӿڵķ����������ʵ��
		{
			public boolean accept(File dir,String name)//Ϊ�ӿڶ���ʵ�ʷ���
			{
				/*
				if(name.endsWith(".txt"))
					return true;
				else
					return false;
				*/
				return name.endsWith(".txt");
			}
		});
		for(String name:arr)
		{
			sop(name);
		}
	}
	public static void listDemo()
	{
		File f=new File("c:\\");
		String[] s=f.list();//�̷��е��ļ��л����ļ���
		for(String name:s)
		{
			sop(name+"::"+name.length());
		}
	}
	public static void listRootsDemo()
	{
		File[] files=File.listRoots();
		for(File f:files)
		{
			sop(f);//�г�����������Ч���̷�
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
