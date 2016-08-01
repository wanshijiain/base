package com.czw.jichu.javase;

import java.util.HashSet;
import java.util.Iterator;

/*
 * |--Set:Ԫ�������򣨴����ȡ��˳��һ��һ�£���Ԫ�ز������ظ�
 * 		|--HashSet:�ײ����ݽṹ�ǹ�ϣֵ
 * 				ͨ��hashcode��equals�������ж�Ԫ���Ƿ��ظ�
 * 		|--TreeSet:���Զ�Set�����е�Ԫ�ؽ�������
 * */
public class HashSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Object> hs=new HashSet<Object>();
		
		hs.add(new Persons("a1",11));
		hs.add(new Persons("a2",12));
		hs.add(new Persons("a3",13));
		
		Iterator<Object> it=hs.iterator();
		while(it.hasNext()){
			Persons p=(Persons)it.next();
			sop(p.getName()+"::"+p.getAge());
		}
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
class Persons{
	private String name;
	private int age;
	Persons(String name,int age){
		this.name=name;
		this.age=age;
	}
	public int hashcode(){								//hashSet�ıȽ�Ҫ��дhashcode��equals����
		//
		System.out.println(this.name+"hashcode");
		return name.hashCode()+age;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Persons))
			return false;
		Persons p=(Persons)obj;
		System.out.println(this.name+"..equals.."+p.name);
		return this.name.equals(p.name)&&this.age==p.age;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
}
