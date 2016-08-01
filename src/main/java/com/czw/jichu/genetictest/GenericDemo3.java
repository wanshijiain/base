package com.czw.jichu.genetictest;

/*
	��̬���������Է������϶���ķ���
*/
class  GenericDemo3
{
	public static void main(String[] args) 
	{
		Demo<String> d=new Demo<String>();
		d.show("haha");
		//d.show(new Integer(4));
		d.print("hehe");
		Demo.method("hahahahaah");
	}
}

/*
	���Ͷ��壺
	1����������ϣ���Ϊ������  Demo<T>
	2: ����ķ�����
*/
class Demo<Q>
{
	public <T> void show(T t)//�˷������������Ϳ��ƣ����ܷ������QӰ��
	{
		System.out.println("show:"+t);
	}
	public void print(Q q)//�˷����ܷ�����Ŀ���
	{
		System.out.println("print:"+q);
	}
	public static <W> void method(W w)//��̬�������巺�ͣ�������ڷ���ֵǰ�档
	{
		System.out.println("method:"+w);
	}
}
