package com.czw.jichu.systemdemo;
/*
 * �μ���
 * DateFormat//���ڸ�ʽ�� �������ࣩ���� SimpleDateFormat
 * 
 * 
 * */
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=new Date();
		System.out.println(d);
		
		//��ģʽ��װ��format������
		SimpleDateFormat sdf=
				new SimpleDateFormat("yyyy��MM��dd�� E hh:mm:ss");//�˴�HH��24Сʱ�Ƶģ�hh��12Сʱ�Ƶ�
		String time=sdf.format(d);
		System.out.println(time);
		
		long l=System.currentTimeMillis();
		Date dl=new Date(l);
		System.out.println(dl);
	}

}
