package com.czw.jichu.javase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * ÿ��ѧ�����ж�Ӧ�Ĺ����ء�
 * ѧ��Students����ַString��
 * ѧ�����ԣ����������䡣
 * ע�⣺����������ͬ����Ϊͬһ��ѧ����
 * ��֤ѧ����Ψһ�ԡ�
 * 
 * 1.����ѧ����
 * 2.����map��������ѧ����Ϊ������ַ��Ϊֵ�����롣
 * 3.��ȡ��ƨ�����е�Ԫ�ء�
 * */
public class MapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Students,String> hm=new HashMap<Students,String>();
		hm.put(new Students("lisi1",21),"beijing");
		hm.put(new Students("lisi2",22),"shanghai");
		hm.put(new Students("lisi3",23),"nanjing");
		hm.put(new Students("lisi4",24),"wuhan");
		
		Set<Students> keySet=hm.keySet();
		Iterator<Students> it=keySet.iterator();
		while(it.hasNext())
		{
			Students stu=it.next();
			String addr=hm.get(stu);
			System.out.println(stu+".."+addr);
		}
		
	}

}

class Students implements Comparable<Students>
{
	private String name;
	private int age;
	Students(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public int compareTo(Students s)
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
		if(!(obj instanceof Students))
			throw new ClassCastException("���Ͳ�ƥ��");
		
		Students s=(Students)obj;
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







