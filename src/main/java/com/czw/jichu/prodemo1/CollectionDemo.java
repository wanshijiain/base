package com.czw.jichu.prodemo1;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method_get();
		method();
	}
	public static void method_get()
	{
		ArrayList<String> al1=new ArrayList<String>();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");
		
		for(Iterator<String> it=al1.iterator();it.hasNext();)//�������൱�ڵ����Ͷ��ȥ���������Ǹ�����
		{
			sop(it.next());
		}//����ķ�ʽ����������ڴ�
		System.out.println();
		Iterator<String> it1=al1.iterator();
		while(it1.hasNext())
		{
			sop(it1.next());
		}//�˷�ʽ���������
	}
	public static void method()
	{
		ArrayList<String> al1=new ArrayList<String>();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");
		ArrayList<String> al2=new ArrayList<String>();
		al2.add("java1");
		al2.add("java2");
		al2.add("java5");
		al2.add("java6");
		
//		sop(al1.removeAll(al2));//�Ƴ���ͬ�Ĳ���
		sop(al1.contains("java1"));
//		sop(al1);
		
		
	}
	public static void sop(Object obj)
	{
		System.out.print(obj);
	}

}
