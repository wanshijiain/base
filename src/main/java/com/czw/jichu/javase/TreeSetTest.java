package com.czw.jichu.javase;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * ���ַ�����������
 * 		ʵ��Comparator��ڣ�����compare����
 *    
 * */
public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> ts=new TreeSet<String>(new StrLenComparator<String>());
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
class StrLenComparator<T> implements Comparator<T>//�Զ���Ƚ���
{
	public int compare(Object o1,Object o2)
	{
		String s1=(String)o1;
		String s2=(String)o2;

		/*if(s1.length()>s2.length())
			return 1;
		if(s1.length()==s2.length())
			return 0;
		return -1;
		*/
		int num=new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if(num==0)
			return s1.compareTo(s2);
		return num;
		
		
	}
}
