package com.czw.jichu.filemessage;
import java.io.*;
/*
 * File�ೣ��������
 * 1.������
 * 		boolean createNewFile();//�ļ�����ʱ���ٴ���
 * 		
 * 		boolean mkdir();//�����ļ���
 * 		boolean mkdirs();//�����༶�ļ���
 * 
 * 2.ɾ����
 * 		boolean delete();//���ļ����ڱ��������޷�ɾ��,���ؼ�
 * 		void deleteOnExit();//��������˳������ǣ����Զ�ɾ���������ļ�
 * 
 * 3.�жϡ�
 * 		boolean exists();//�ļ��Ƿ����
 * 		boolean isHidden();//�����ļ�
 * 		boolean isAbsolute();//�Ƿ��Ǿ���·��
 * 
 * 4.��ȡ��Ϣ��
 * 			 getName();
 * 			 getPath();//��װ��ʲô·����õľ���ʲô·��
 * 			 getParent();//���ط�װ�ĸ�Ŀ¼�������ڷ���null
 * 			 getAbsolutePath();
 * 		File getAbsoluteFile();//
 * 		long lastModified();//�ϴε��ļ��޸�ʱ��
 * 		long length();//�ļ���С
 * 
 * ʹ��Runtime������԰���ִ�е��ļ���������
 * */
public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		method_1();
	}
	
	public static void method_5()
	{
		File f1=new File("c:\\Test.java");
		File f2=new File("d:\\haha.java");
		sop("rename:"+f2.renameTo(f1));//f2����Ϊf1
		
	}
	
	public static void method_4()
	{
		File f=new File("b.txt");
		sop("path:"+f.getPath());//
		sop("absolutepath:"+f.getAbsolutePath());
		sop("parent:"+f.getParent());
		//�÷������ص��Ǿ���·���еĸ�Ŀ¼(��һ��Ŀ¼)
	}
	
	public static void method_3()
	{
		File f=new File("file.txt");
		
		//����չ����Ҳ�������ļ���
		
		//�ж��ļ������Ƿ����ļ�����Ŀ¼�ǣ�����ͨ��exists�����ж������Ƿ����
		f.exists();
		sop("dir��"+f.isDirectory());
		sop("file:"+f.isFile());
	}
	
	public static void method_1()throws IOException
	{
		File f=new File("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\a.txt");
//		sop("create:"+f.createNewFile());
		sop("file:"+f.delete());
		f.deleteOnExit();

	}
	
	public static void method_2()
	{
		File f=new File("file.txt");
		File dir=new File(f,"aa//bb//cc");//�������ļ��ﴴ���ļ��еķ�ʽ�Ǵ���ģ��������������ַ�ʽ��
		
		dir.mkdirs();//�����༶�ļ���
		
	}
	
	
	public static void consMethod()
	{
		//��a.txt��װ��file���󡣿��Խ����еĺ�Ϊ���ֵ��ļ������ļ��з�װ�ɶ���
		File f1=new File("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\a.txt");
		
		File f2=new File("E:\\JAVA\\��Ŀ\\Test\\srcfilemessage","a.txt");
		
		File d=new File("E:"+File.separator+"JAVA"+File.separator+"��Ŀ"+File.separator+"Test"+File.separator+"src"+File.separator+"filemessage");
			//��ƽ̨�ķָ��� File.separator
		File f3=new File(d,"a.txt");
		
		sop("f1"+f1);
		sop("f2"+f2);
		sop("f3"+f3);//File�����װ����ʲô·���ʹ�ӡʲô·��
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
