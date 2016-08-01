package com.czw.jichu.javase;
/*
 * List�����ж�Ԫ���Ƿ���ͬ�����õ���Ԫ�ص�equals����
 * */
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Person> al=new ArrayList<Person>();
		al.add(new Person("lisi1",30));
		al.add(new Person("lisi2",33));
		al.add(new Person("lisi2",33));
		al.add(new Person("lisi3",35));
		al.add(new Person("lisi4",37));
		al.add(new Person("lisi4",37));
		
//		al=singleElement(al);
		
		Iterator<Person> it=al.iterator();
		while(!it.hasNext()){
			Person p=(Person)it.next();		//it����Object�࣬������getName��getAge����,ͨ������ת����ʵ��
			sop(p.getName()+"..."+p.getAge());
		}

	}
	public static ArrayList<Person> singleElement(ArrayList<Person> al)
	{
		ArrayList<Person> newal=new ArrayList<Person>();
		Iterator<Person> it=al.iterator();
		while(!it.hasNext())
		{
			Object obj=it.next();
			if(!newal.equals(obj))
				newal.add((Person)obj);
			
		}
		return newal;
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

/*���ݵķ�װ��ͨ���½��࣬�ڲ�Ԫ��˽�У�ͨ�������ṩ����������*/
class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
			return false;
		Person p=(Person)obj;
		return this.name.equals(p.name)&&this.age==p.age;
	}
}
