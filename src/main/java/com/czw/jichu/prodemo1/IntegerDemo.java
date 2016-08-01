package com.czw.jichu.prodemo1;
/*
 * 
 * */
public class IntegerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer m=128;
		Integer n=128;	//�����£�����ֱ�����͸�ֵ�൱�ڣ�Integer n=new Integer(128)
			//�����Զ�װ��
		
		m=m+2;//�൱��   m= m.intValue()+2
		
		Integer a=127;
		Integer b=127;
		sop("m==n:"+(m==n));//m==n:false   	//���ִ������ԭ���ǣ�����ֵ������byte�ķ�Χ��-128~127��ʱ
		sop("a==b:"+(a==b));//a==b:true		//�������¿��ٿռ䣬��������ָ��ͬһ����ַ
		

	}
	public static void sop(String str)
	{
		System.out.println(str);
	}

}
