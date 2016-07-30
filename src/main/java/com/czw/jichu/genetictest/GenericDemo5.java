package com.czw.jichu.genetictest;
import java.util.*;
class GenericDemo5 
{
	public static void main(String[] args) 
	{
		/*
		ArrayList<String> al=new ArrayList<String>();
		al.add("aaa");
		al.add("bbb");
		al.add("ccc");
		ArrayList<Integer> all=new ArrayList<Integer>();
		all.add(11);
		all.add(22);
		all.add(33);

		print(al);//ʹ��ͨ������Դ��벻ͬ���͵�Ԫ��
		print(all);
		*/

		ArrayList<Person> all=new ArrayList<Person>();
		all.add(new Person("aaa"));
		all.add(new Person("bbb"));
		all.add(new Person("ccc"));
		//print(all);

		ArrayList<Student> al=new ArrayList<Student>();
		all.add(new Student("aa---a"));
		all.add(new Student("bb---b"));
		all.add(new Student("cc---c"));
		print(al);


	}
	public static void print(ArrayList< ? extends Person> al)//�����޶���<? extends Person>
	{
		Iterator<? extends Person> it=al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}
	}
	/*
	public static void print(ArrayList<?> al)//�����Ͳ�ȷ���ǣ�ʹ��ͨ���  ��   ����ʾ
	{
		
		Iterator<?> it=al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}
	*/
}
class Person
{
	private String name;
	Person(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
class Student extends Person
{
	Student(String name)
	{
		super(name);
	}
}


