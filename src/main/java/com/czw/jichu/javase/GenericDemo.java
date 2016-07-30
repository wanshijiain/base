package com.czw.jichu.javase;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 	���ͣ�JDK1.5�汾��������ԣ����ڽ����ȫ���⣬��һ�����Ͱ�ȫ���ơ�
 * 
 * 	�ô���
 * 	1.������ʱ�ڳ�������ClassCastException��ת�Ƶ��˱���ʱ�ڡ�
 * 		���������Ա������⡣��������������١�
 * 	2.������ǿ��ת�����鷳��
 * */
public class GenericDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> ts=new TreeSet<String>(new LenComparator());
		ts.add("abcd");
		ts.add("ccc");
		ts.add("aaa");
		ts.add("cba");
		ts.add("z");
		ts.add("hahaha");
		
		Iterator<String> it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
	}

}
class LenComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		int num=new Integer(s2.length()).compareTo(new Integer(s1.length()));
		
		if(num==0)
			return  s2.compareTo(s1);
		return num;
	}
	/*�˴�������Ԫ�س��Ȱ���С����ֻ��ı�String�ıȽ�λ��*/
}
