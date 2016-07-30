package com.czw.jichu.javase;
/*
 * ���Ͽ�ܵĹ�����
 * 
 * Collections�еļ��Ϲ������еķ�����
 * fill(list��Object)								//��ָ�������е�Ԫ��ȫ���滻
 * reverse(list)									//��תָ�������е�Ԫ��
 * replaceAll(List<T> list,T oldVal,T newVal)		//������������oldVal�滻��newVal
 * binarySearch()									//����ɱȽϵļ��Ϻ�ֵ����ȡָ������
 * sort(list,Comparator)							//
 * max(list,value,Comparator)
 * reverseOrder()���򷵻�һ��������
 * */
import java.util.*;
public class CollectionsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxDemo();
//		binarySearchDemo();
	}
	public static void binarySearchDemo()
	{
		List<String > list=new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("kkkkk");
		list.add("zz");
		list.add("z");
		list.add("qq");
		//sop(list);
		Collections.sort(list,new StrLenComparators());
		
		
	    //int index=Collections.binarySearch(list, "z");
		//int index=halfSearch(list,"aaa");
		int index=halfSearch2(list,"aaa",new StrLenComparators());
		sop(list);
		sop("index"+index);
		
		
	}
	public static int halfSearch(List<String> list,String key)//�Լ���д�Ķ��ֲ��Ҵ���
	{
		int max,min,mid;
		max=list.size()-1;
		min=0;
		
		while(min<=max)
		{
			mid=(max+min)>>1;
			String str=list.get(mid);
			int num=str.compareTo(key);
			if(num>0)
				max=mid-1;
			else if(num<0)
				min=mid+1;
			else 
				return mid;
		}
		return -min-1;//�����Ϊ��ֵ�ڼ�1
	}
	
	public static int halfSearch2(List<String> list,String key,Comparator<String> cmp)
	{
		int max,min,mid;
		max=list.size()-1;
		min=0;
		
		while(min<=max)
		{
			mid=(max+min)>>1;
			String str=list.get(mid);
			int num=cmp.compare(str, key);
			if(num>0)
				max=mid-1;
			else if(num<0)
				min=mid+1;
			else 
				return mid;
		}
		return -min-1;//�����Ϊ��ֵ�ڼ�һ
	}
	
	
	public static void sortDemo()
	{
		List<String > list=new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("z");
		list.add("z");
		list.add("qq");
		sop(list);
		Collections.sort(list,new StrLenComparators());
		sop(list);
		
	}
	public static void maxDemo()
	{
		List<String > list=new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("z");
		list.add("z");
		list.add("qq");
		sop(list);
		
		String s=Collections.max(list,new StrLenComparators());
		sop(s);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}

class StrLenComparators implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if(s1.length()>s2.length())
			return 1;
		if(s1.length()<s2.length())
			return -1;
		return s1.compareTo(s2);		
	}
}
