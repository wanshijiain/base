package com.czw.jichu.filemessage;
import java.io.*;
public class ObjectStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		writeObj();
		readObj();
	}
	public static void readObj()throws Exception
	{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\object.txt"));
		Person p=(Person)ois.readObject();
		
		System.out.println(p);
		ois.close();
		
		
		
	}
	public static void writeObj()throws IOException
	{
		ObjectOutputStream oos=
				new ObjectOutputStream(new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\object.txt"));
		oos.writeObject(new Person("lisi",39));
		
		oos.close();
		
	}
}
//û�з����Ľӿ�:��ǽӿ�(���Ǹ���Ǹ���)
class Person implements Serializable//ʵ�ֿ����л��Ľӿ�
{
	/*
	 * ��Person���޸ĺ�ԭ�е�object.txt�е��ļ������±����Person���кŲ�һ�£��ͻ�����쳣
	 * ���кŸ��߳�Ա��������ģ������¸Ļ�ԭ����״̬�ٱ��룬����ʹ��
	 * 
	 * ��������౻�޸ĺ���Ȼ���Ա���ȡ�������Լ�����һ�����к�ֵ
	 * �磺
	 * 		public static final long serialVersionUID=42L;(42L�����ȡ)
	 * 
	 * static ���ܱ����л�
	 * 
	 * ���������ĳЩԪ�ر����л�
	 * 			���Ϲؼ��֣�  transient
	 * 
	 * */
	private String name;
	transient int age;//age���ܱ����л�����ֵ֤�ڶ��ڴ��д��ڣ��������ı��ļ��д���
	Person(String name,int age)
	{
		this.name=name;
		this.age=age;
		
	}
	public String toString()
	{
		return name+"::"+age;
	}
}





