package com.czw.jichu.filemessage;
/*��ϰ��
 * ��һ��ָ��Ŀ¼�µ�Java�ļ��ľ���·���洢��һ���ı��ļ���
 * ����һ��Java�ļ��б��ļ�
 * 
 * ˼·��
 * 1.��ָ��Ŀ¼���еݹ�
 * 2.��ȡ�ݹ���̵�����Java�ļ�·��
 * 3.��·���洢��������
 * 4.�������е�����д���ļ��С�
 * 
 * �����ݴ洢��Ӳ�̽С������ݵĳ־û�
 * */
import java.util.*;
import java.io.*;
public class JavaFileList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir=new File("E:\\JAVA\\��Ŀ\\Test\\src");
		List<File> list=new ArrayList<File>();
		fileToList(dir,list);
//		sop(list.size());
		File file=new File(dir,"javalist.txt");
		writeToFile(list,file.toString());
		
	}
	public static void fileToList(File dir,List<File> list)//���ļ��洢�������У��������ļ�����
	{

		File[] files=dir.listFiles();
		for(File file:files)
		{
			if(file.isDirectory())
				fileToList(file,list);
			else
			{
				if(file.getName().endsWith(".java"))
					list.add(file);
			}
		}
	}
	public static void writeToFile(List<File> list,String javaFile)
	{
		int count=1;
		BufferedWriter bufw=null;
		try {
			bufw=new BufferedWriter(new FileWriter(javaFile));
			for(File file:list)
			{
				String path=(count++)+"::\t"+file.getAbsolutePath();
				bufw.write(path);
				bufw.newLine();
				bufw.flush();

			}
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try {
				if(bufw!=null)
					bufw.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
