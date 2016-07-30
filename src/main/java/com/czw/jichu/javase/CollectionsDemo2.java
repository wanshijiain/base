package com.czw.jichu.javase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.*;

/*
 * Collections�е�reverseOrder(Comparator)����ǿ����ת�Ƚ�����˳��
 * */
public class CollectionsDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		orderDemo();
		fillDemo();
	}
	public static void fillDemo()
	{
		List<String > list=new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("kkkkk");
		list.add("zz");
		list.add("z");
		sop(list);
		Collections.fill(list, "pp");
		sop(list);
		
		
	}
	

	public static void orderDemo()
	{
		TreeSet<String> ts=new TreeSet<String>(Collections.reverseOrder(new StrLenComparators()));
		ts.add("abce");
		ts.add("aaa");
		ts.add("k");
		ts.add("cc");
		
		Iterator<String> it=ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
class StrComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		/*
		int num=s1.compareTo(s2);
		if(num>0)
			return -1;
		if(num<0)
			return 1;
		return 0;
		*/
		return s2.compareTo(s1);
	}
}
