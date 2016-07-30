package com.czw.jichu.genetictest;
/*
�ӿ�ʵ�ַ��ͣ��̳нӿ���Ҫ�������͡�

*/

class GenericDemo4 
{
	public static void main(String[] args) 
	{
		//InterImple i=new InterImple();
		//i.show("hahaha");

		InterImple<Integer> i=new InterImple<Integer>();
		i.show(new Integer(2));

	}
}
interface Inter<T>
{
	void show(T t);
}
/*
class InterImple implements Inter<String>
{
	public void show(String s)
	{
		System.out.println("show:"+s);
	}
}
*/
class InterImple<T> implements Inter<T>//ͨ���÷�ʽ���û��Զ�������
{
	public void show(T t)
	{
		System.out.println("show:"+t);
	}
}