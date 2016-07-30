package com.czw.jichu.prodemo1;

import java.util.LinkedList;
/*
 * LinkedList���з�����
 * addFirst()  addLast()                  	��1.6��������������	     	offer()  	offerFirst()
 * getFirst()  getLast()//��ȡԪ�ز�ɾ��									peek()		peekFirst()
 * removeFirst() removeLast()//��ȡԪ��ɾ��								poll		pollFirst()
 * 
 * 		�˷�������NoSuchElementException								�˷�������  NULL
 * */
public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> ll=new LinkedList<String>();
		ll.add("java1");
		ll.add("java2");
		ll.add("java3");
		ll.add("java4");
		
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
