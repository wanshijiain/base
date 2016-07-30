package com.czw.jichu.javase;

/*
 * ��ջ�����еĴ���ʵ��
 * 
 * ��װ������ͨ����Ŀ���ض��ķ�ʽʵ��
 * */
import java.util.*;
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DuiLie ll=new DuiLie();
		ll.myAdd("java1");
		ll.myAdd("java2");
		ll.myAdd("java3");
		ll.myAdd("java4");
		
		while(!ll.isNULL())
		{
			System.out.println(ll.myGet());
		}
	}

}
class DuiLie{
	private LinkedList<Object> link;
	DuiLie()
	{
		link=new LinkedList<Object>();
	}
	public void myAdd(Object obj)
	{
		link.offerLast(obj);
	}
	public Object myGet()
	{
		return link.pollFirst();//�˴���FIFO���Ƕ��е�ȡ����ʽ��   ��ʹ��pollLast()���Ƕ�ջ��ȡ����ʽ����ȥһ��ɾһ����
	}
	public boolean isNULL()
	{
		return link.isEmpty();
	}
}





