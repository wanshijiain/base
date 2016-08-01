package com.czw.jichu.javase;
/*
 * 1.5������
 * 
 * �ɱ����
 * 
 * ��̬���� import static java.util.Arrays.*;
 * */

import static java.util.Arrays.*;

import java.util.Arrays;
public class ParaMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show("hehe",1,2,3);
		//�����3
		int[] arr={3,2,2};
		
		sort(arr);//Arrays.sort(arr);
		int index=binarySearch(arr,2);//Arrays.binarySearch(arr,2);
		System.out.println(Arrays.toString(arr));
		//System.out.println(toString(arr));�˴�����ʡ��Arrays��Ϊ������������Ҫָ��������
		System.out.println("Index="+index);
	}
	
	public static void show(String s,int... arr)//�ɱ����һ��Ҫ���嵽�����б�������
	{
		System.out.println(arr.length);
	}
	
	/*
	public static void show(int[] arr )
	{}
	public static void show(int a,int b)
	{
		System.out.println(a+","+b);
	}
	public static void show(int a,int b,int c)
	{}
	*/

}
