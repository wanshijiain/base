package com.czw.jichu.genetictest;
/*
�����޶����ڷ�����չ

*/
import java.util.*;
class GenericDemo6 
{
	public static void main(String[] args) 
	{
		TreeSet<Worker> all=new TreeSet<Worker>(new Comp());
		all.add(new Worker("waaa2"));
		all.add(new Worker("wbbb1"));
		all.add(new Worker("wccc3"));
		//print(all);
		Iterator<Worker> it1=all.iterator();
		while(it1.hasNext())
		{
			System.out.println(it1.next().getName());
		}

		TreeSet<Student> al=new TreeSet<Student>(new Comp());
		al.add(new Student("aa---a1"));
		al.add(new Student("bb---b2"));
		al.add(new Student("cc---c3"));
		//print(al);
		Iterator<Student> it2=al.iterator();
		while(it2.hasNext())
		{
			System.out.println(it2.next().getName());
		}

	}
	/*
	public static void print(TreeSet<? extends Person> ts)
	{
		Iterator<? extends Person> it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}
	}
	*/

}

class Comp implements Comparator<Person>
{
	public int compare(Person p1,Person p2)
	{
		return p2.getName().compareTo(p1.getName());
	}
}

class Personn
{
	private String name;
	Personn(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
}
class Studentn extends Person
{
	Studentn(String name)
	{
		super(name);
	}
}
class Worker extends Person
{
	Worker(String name)
	{
		super(name);
	}
}
