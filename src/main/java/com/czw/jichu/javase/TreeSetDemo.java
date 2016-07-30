package com.czw.jichu.javase;
/*
 *   |--TreeSet:���Զ�set�����е�Ԫ�ؽ�������
 *   			�ײ����ݽṹ�Ƕ��������������
 *   			Comparable�ӿڸ�дcompareTo����return 0
 *   			
 *   			TreeSet����ĵ�һ�ַ�ʽ����Ԫ������߱��Ƚ���
 *   				
 *   				
 *   			TreeSet����ĵڶ��ַ�ʽ��
 *   				��Ԫ�������߱��Ƚ����ǣ���߱��ıȽ��Բ�������Ҫ�ĵġ�
 *   				���Ǿ���Ҫ�ü�������߱��Ƚ��ԡ�
 *   				�ڼ��ϳ�ʼ��ʱ�������˱Ƚ��ԡ�
 *   				
 *   				����һ���Ƚ�����
 *   					ʵ��Comparator��ڣ�����compare������
 * */
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Student> ts=new TreeSet<Student>();
//		ts.add(new Student("lisi004",20));
		ts.add(new Student("lisi003",19));
		ts.add(new Student("lisi002",18));
		ts.add(new Student("lisi001",17));
		
		Iterator<Student> it=ts.iterator();
		while(it.hasNext())
		{
//			Student stu=(Student)it.next();
			Student stu=it.next();
			System.out.println(stu.getName()+"....."+stu.getAge());
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
class Student implements Comparable<Object>{
	private String name;
	private int age;
	Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public int compareTo(Object obj)//TreeSetҪ��дcompareTo��������������Ƚ�
	{
		if(!(obj instanceof Student))
			throw new RuntimeException("����ѧ��");
		Student s=(Student)obj;
		System.out.println(this.name+"..compareTo.."+s.name);
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
		{
			return this.name.compareTo(s.name);
		}
		return -1;
	}
}
