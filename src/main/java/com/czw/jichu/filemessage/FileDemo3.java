package com.czw.jichu.filemessage;

import java.io.File;

/*
 * �г�ָ��Ŀ¼���ļ������ļ��У�������Ŀ¼�����ݡ�
 * Ҳ�����г�֪��Ŀ¼���������ݡ�
 * */
public class FileDemo3 {
	
	public static void main(String[] args) {
		File dir=new File("e:\\JAVA");
		long start=System.currentTimeMillis();
		showDir(dir,0);
		long end=System.currentTimeMillis();
		System.out.println((end-start)+"����");
		
//		toBin(6);
//		int n=getNum(10);
//		sop(n);
		
	}
	public static String getLevel(int level)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("|--");
		for(int x=0;x<level;x++)
		{
			sb.insert(0,"|  ");
		}
		return sb.toString();
	}
	public static void showDir(File dir,int level)
	{
		
		System.out.println(getLevel(level)+dir.getName());
		level++;
		File[] files=dir.listFiles();
		for(int x=0;x<files.length;x++)
		{
			if(files[x].isDirectory())
				showDir(files[x],level);
			else
				System.out.println(getLevel(level)+files[x]);
		}
	}
	
	public static void toBin(int x)//�ݹ�����
	{
		if(x>0){
			toBin(x/2);
			System.out.print(x%2);
		}
	}
	public static int getNum(int x)//һ��ʮ�ĵݹ�֮��
	{
		if(x==1)
			return 1;
		return x+getNum(x-1);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	
}
