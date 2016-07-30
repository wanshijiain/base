package com.czw.jichu.javase;

import java.util.*;
import java.util.Set;
import java.util.TreeMap;

public class MapTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Studenta,String> tm=new TreeMap<Studenta,String>(new StuNameComparator());
		tm.put(new Studenta("blisi3",23), "nanjing");
		tm.put(new Studenta("alisi1",21), "beijing");
		tm.put(new Studenta("lisi4",24), "wuhan");
		tm.put(new Studenta("lisi2",22), "shanghai");
		
		Set<Map.Entry<Studenta,String>> entrySet=tm.entrySet();
		Iterator<Map.Entry<Studenta,String>> it=entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Studenta, String> me=it.next();
			Studenta stu=me.getKey();
			String addr=me.getValue();
			System.out.println(stu+":::"+addr);
		}
		
	}

}
class StuNameComparator implements Comparator<Studenta>//�Ƚ�����дcompare����
{
	public int compare(Studenta s1,Studenta s2)
	{
		int num=s1.getName().compareTo(s2.getName());
		if(num==0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}
class Studenta implements Comparable<Studenta>
{
	private String name;
	private int age;
	Studenta(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Studenta s)
	{
		int num=new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Studenta))
			throw new ClassCastException("���Ͳ�ƥ��");
		
		Studenta s=(Studenta)obj;
		return this.name.equals(s.name)&&this.age==s.age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return name+":"+age;
	}
}
