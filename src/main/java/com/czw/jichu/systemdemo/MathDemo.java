package com.czw.jichu.systemdemo;

import java.util.Random;
/*
 * ��ϰ������һ��С����������С���ĺ���λ��
 * double d=10.2133;
 * int i=(int)(d*100);
 * double dl=(double)i;
 * dl=i/100;
 * 
 * 
 * */
public class MathDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		
		for(int x=0;x<5;x++)
		{
			//int d=(int)(Math.random()*10);
			int d=r.nextInt(10)+1;
			//sop(d);
		}
		
		
		double d=10.2133;
		int i=(int)(d*100);
		sop(i);
		double dl=(double)i;
		sop(dl);
		dl=dl/100;
		sop(dl);
		
		
		
	}
	public static void show()
	{
		double d=Math.ceil(12.34);//ceil���ش���ָ�����ݵ���С����������13
		double dl=Math.floor(12.34);//floor����С��ָ�����ݵ�����������Ż�12
		
		long l=Math.round(12.34);//��������
		sop("l"+l);
		sop("d="+d);
		sop("dl="+dl);
		
		double d2=Math.pow(2,3);//�������η�
		sop("d2="+d2);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
