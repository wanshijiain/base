package com.czw.jichu.iodemo;
/*
 * װ�����ģʽ��
 * ����Ҫ�����ж�����й�����ǿ�ǣ�
 * ����ͨ�������۽����ж����룬�������й����ṩ��ǿ���ܣ���ô�Զ���ĸ��༴Ϊ��ǿ�ࡣ
 * 
 * װ����ͨ����ͨ�����췽�����ܱ�װ�ε���
 * �����ڱ�װ�εĶ����ṩ��ǿ�Ĺ���
 * 
 * */
public class PersonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person();
		//p.chiFan();֮ǰ�ĳԷ������ܼ򵥣�ͨ������װ�λ�ø���Ĺ���
		SuperPerson sp=new SuperPerson(p);
		sp.superchiFan();
	}

}
class Person
{
	public void chiFan()
	{
		System.out.println("�Է�");
	}
}
class SuperPerson
{
	private Person p;
	SuperPerson(Person p)
	{
		this.p=p;
	}
	public void superchiFan()
	{
		System.out.println("��θ��");
		p.chiFan();
		System.out.println("���");
		System.out.println("��һ��");

	}
}


