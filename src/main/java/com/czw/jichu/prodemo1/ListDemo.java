package com.czw.jichu.prodemo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * Collection
 * 		|>--List:Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ��������
 * 			|>--ArrayList:����ṹ��     �̲߳�ͬ����Ч�ʸ�		|����������ͬ�����ǿɱ䳤�����顣ArrayListshi 50%�ӳ�
 * 			|>--Vector:����ṹ��           �߳�ͬ����Ч�ʵ�		| ��Vector��100%�ӳ���
 * 					Vector���и�[ö��]��
 * 					for (Enumeration<E> e = v.elements(); e.hasMoreElements();)
 * 							System.out.println(e.nextElement());
 * 			
 * 			|--LinkedList:����ṹ��
 * 		|--Set:Ԫ��������ģ�Ԫ�ز������ظ���
 * 
 * 
 * List:(ֻ��ȡ�����Է���)
 * 	����add(index,element) addAll(index,collection)
 * 	ɾremove(index) removeAll(collection)//�Ƴ���ͬ��
 * 	��set(index,element)
 * 	��get(index)  subList(fromindex,endindex)  listIterator() * 
 * 
 * List������еĵ�������ListIterator��Iterator���ӽӿڡ�
 * 
 * �ڵ����ǣ�������ͨ�����϶���ķ������������е�Ԫ�ء�
 * ��Ϊ�ᷢ��ConcurrentModificationException�쳣��
 * ���ԣ���ʹ�õ������ǣ�ֻ���õ������ġ�Iteratorֻ��ʹ���жϣ���ȡ��ɾ��Ԫ��
 * ʹ��ListIterator��������������Ĺ��ܡ�
 * 
 * */
public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method();
	}
	public static void method()
	{
		ArrayList<String> al1=new ArrayList<String>();
		al1.add("java1");
		al1.add("java2");
		al1.add("java3");
		al1.add("java4");
		
		ListIterator<String> li=al1.listIterator();
		while(li.hasNext())
		{
			Object obj=li.next();
			if(obj.equals("java2"))
				//li.add("java008");
				li.set("java007");
				//li.remove();//iteratorֻ��ʹ���Ƴ�����������
			sop("obj:"+obj);
		}
		sop(al1);
		//Iterator<String> it=al1.iterator();
		
		/*while(it.hasNext())
		{
			Object obj=it.next();
			if(obj.equals("java02"))
				//al1.add("java008");
				it.remove();//iteratorֻ��ʹ���Ƴ�����������
			sop("obj:"+obj);
		}
		sop(al1);
		*/
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
