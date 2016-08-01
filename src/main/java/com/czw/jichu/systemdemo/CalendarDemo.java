package com.czw.jichu.systemdemo;
/*
 * 1.��ȡ������Ķ����ж�����
 * 		c.set(year,2,1)//ĳһ���3��1��
 * 		c.add(Calendar.DAY_OF_MONTH,-1);//3��1�գ���ǰ��һ�����2�µ�
 * 2.��ȡ������������ʱ�̡�
 * 		c.add(Calendar.DAY_OF_MONTH,-1);
 * */
import java.util.Calendar;
import java.util.Date;


/*
 * 
 * */

public class CalendarDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Calendar c=Calendar.getInstance();
		
//		c.set(2012,2,23);//����ʱ��
//		c.add(Calendar.MONTH,-1);//�·ݵļӼ�
		
		String a;
		java.sql.Date ds=new java.sql.Date(System.currentTimeMillis());
		Calendar cl=Calendar.getInstance();
		
//		cl.setTimeInMillis(ds.getTime());
		cl.setTime(ds);

		a=cl.get(Calendar.YEAR)+"";
		
		sop(a);
		
//		String[] mons={"һ��","����","����","����"
//				,"����","����","����","����"
//				,"����","ʮ��","ʮһ��","ʮ����"};
//		int index=c.get(Calendar.MONTH);
//		// ��0��ʼ����
//		sop(index);
//		sop(mons[index]);
//		
//		
//		sop(c.get(Calendar.YEAR)+"��");
		//sop(mons[index]);//����������·��Ǵ�0��ʼ
		
		
		
		/*
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(d);
		System.out.println(year);
		*/
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
