package com.czw.jichu.filemessage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * �����ѧ����ÿ��ѧ����3�ſεĳɼ���
 * �Ӽ��������������ݣ��������������ſεĳɼ���
 * ����ĸ�ʽ���磺zhangsan,30,40,60������ܳɼ���
 * ����ѧ������Ϣ�ͼ�������ܷ����ߵ�˳�����ڴ����ļ���stud.txt��
 * 
 * 1.����ѧ������
 * 2.����һ���ɲ�����ѧ������Ĺ����ࡣ
 * 
 * ˼��:
 * 1.ͨ����ȡ����¼��һ�����ݣ����������е���Ϣȡ����װ��ѧ������
 * 2.��Ϊѧ���кܶ࣬��ô����Ҫ�洢��ʹ�õ����ϡ���ΪҪ��ѧ�����ܷ�����
 * 3.�����ϵ���Ϣѩ�㵽һ���ļ��С�
 * 
 * */
public class StudentInfoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Comparator<Student> cmp=Collections.reverseOrder();
		Set<Student> stus=StudentInfoTool.getStudent(cmp);
		StudentInfoTool.write2File(stus);
		
	}

}
class Student implements Comparable<Student>
{
	private String name;
	private int ma,cn,en;
	private int sum;
	Student(String name,int ma,int cn,int en)
	{
		this.name=name;
		this.cn=cn;
		this.en=en;
		sum=ma+cn+en;
	}
	public int compareTo(Student s)
	{
		int num=new Integer(this.sum).compareTo(new Integer(s.sum));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	public String getName()
	{
		return name;
	}
	public int getSum()
	{
		return sum;
	}
	public int hasCode()
	{
		return name.hashCode()+sum*78;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("���Ͳ�ƥ��");
		Student s=(Student)obj;
		
		return this.name.equals(s.name)&&this.sum==s.sum;
	}
	public String toString()
	{
		return "student["+name+","+ma+","+cn+","+"en"+"]";
	}
	
	
}
class StudentInfoTool
{
	//�������������û��Զ���Ƚ�����Ĭ�ϱȽ���
	public static Set<Student> getStudent()throws Exception
	{
		return getStudent(null);
	}
	public static Set<Student> getStudent(Comparator<Student> cmp)throws Exception
	{
		BufferedReader bufr=
				new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		
		Set<Student> stus=null;
		if(cmp==null)
			stus=new TreeSet<Student>();
		else 
			stus=new TreeSet<Student>(cmp);
			
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			String[] info=line.split(",");
			Student stu=new Student(info[0],Integer.parseInt(info[1]),Integer.parseInt(info[2]),Integer.parseInt(info[3]));
			stus.add(stu);
		}
		bufr.close();
		
		return stus;
	}
	public  static void write2File(Set<Student> stus)throws Exception
	{
		File file=new File("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\stud.txt");
		if(!file.exists())
			file.createNewFile();
//		BufferedWriter bufw=new BufferedWriter(new FileWriter(file));
		PrintWriter bufw=new PrintWriter(new FileWriter(file),true);
		for(Student stu:stus)
		{
//			bufw.write(stu.toString()+"\t");
//			bufw.write(stu.getSum()+"");
//			bufw.newLine();
//			bufw.flush();
			bufw.print(stu.toString()+"\t");
			bufw.print(stu.getSum()+"");//���Զ�����
			
			
		}
		bufw.close();
		
		
	}
}



