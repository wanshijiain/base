package com.czw.jichu.javase;

import java.util.*;

/*
 * ���ϱ����� 
 * collection�ӿ��е�toArray����
 * */
public class CollectionToArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<String> al=new ArrayList<String>();
//		al.add("abc1");
//		al.add("abc2");
//		al.add("abc3");
//		/*
//		 * 1.ָ�����͵����鳤��С�ڼ��ϵ�size�������ڲ�����һ���µ����鳤��Ϊ���ϵ�size
//		 * 
//		 * 2.���ϱ�������Ϊ���޶���Ԫ�صĲ�����
//		 * */
//		String[] arr=al.toArray(new String[al.size()]);
//		System.out.println(Arrays.toString(arr));
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		hm.put(1, "a");
		hm.put(2, "b");
		hm.put(3, "c");
		Set<Integer> keySet=hm.keySet();
		for(Integer i:keySet)
		{
			System.out.println(i+"::"+hm.get(i));
		}
		for(Map.Entry<Integer, String> me:hm.entrySet())
		{
			System.out.println(me.getKey()+"---"+me.getValue());
		}
		
		
	}

}
