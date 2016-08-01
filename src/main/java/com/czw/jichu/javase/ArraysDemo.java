package com.czw.jichu.javase;

import java.util.*;

/*
 * Arrays�����������
 * asList()����ת����list����
 * 
 * ��������е�Ԫ�ض��Ƕ�����ô��ɼ���ʱ�������е�Ԫ�ؾ�ֱ��ת�ɼ����е�Ԫ�ء�
 * ��������е�Ԫ�ض��ǻ����������ͣ���ô�ͽ���������Ϊ�����е�Ԫ�ش���
 * Integer[] in={1,2,3};
 * List<Integer> li=Arrays.asList(in);//��ͨ��printֱ�Ӵ�ӡ
 * int[] in={1,2,3};
 * List<int[]> li=Arrays.asList(in);//������print��ӡ�������ӡ����ǵ�ַ
 * */
public class ArraysDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr={"abc","cc","kkkk"};
		List<String> list=Arrays.asList(arr);
		sop("contains:"+list.contains("cc"));
		//list.add("qq");//���ܽ�����ɾ�����������쳣UnsupportedOperationException
		
		int[] nums={1,2,3};
		
		List<int[]> li=Arrays.asList(nums);
		sop(li);
		
		
	}
	public static boolean myContains(String[] arr,String key)
	{
		for(int x=0;x<arr.length;x++)
		{
			if(arr[x].equals(key))
				return true;
		}
		return false;
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
