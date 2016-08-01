package com.czw.jichu.systemdemo;
/*Systemϵͳ��
 * 
 * err   in   out
 * 
 * ��ȡϵͳ������Ϣ��Properties getProperties()//Properties��Hashtable������
 * 
 * 
 * */
import java.util.*;
public class SystemDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop=System.getProperties();
		//��ΪProperties��Hahstable�����࣬Ҳ����Map���ϵ�һ���������
		//��ô����ͨ��Map�еķ���ȡ���ü����е�Ԫ�ء�
		//�ü����д洢�Ķ����ַ�����û�з��Ͷ��塣
		
		//ϵͳ���Զ���һЩ������Ϣ
		//System.setProperty("mykey", "myvalue");
		
		//��ȡָ��������Ϣ
//		String value=System.getProperty("os.name");
//		System.out.println("value="+value);
		
		//�������jvm�����Ƕ�̬�ļ���һЩ��Ϣ
		//��������   java -D <name>=<value>    hahah=qqqqq
		//java -D haha=qqqq SystemDemo
//		String v=System.getProperty("haha");
//		System.out.println("v"+v);
		
		
		/*
		 * ��ΪProperties��Hashtable�����࣬Ҳ����Map�ļ��ϵ�һ���������
		 * ��ô����ͨ��map�ķ���ȡ���ü����е�Ԫ��
		 * �ü����д洢���ַ�����û�з��Ͷ���
		 * 
		 * */
		
		//prop.keySet().iterator()�����
	
		for(Object obj: prop.keySet())
		{
			String value=(String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}
	}

}
