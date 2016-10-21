package com.czw.jichu.javase;

public class GenericDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		IntelliJ t=new IntelliJ();
//		t.setObject(new Teacher());
//		Worker w=(Worker)t.getObject();
		
		Utils<Worker> ut=new Utils<Worker>();//������
		ut.setObject(new Worker());
		Worker w=ut.getObject();
		
	}

}
class Worker
{
	
}
class Teacher
{
	
}

/*�˷�ʽΪ���ͳ���֮ǰ�Ĺ��߶��巽ʽ��ʹ��ʱ�������ǿת*/
class Tool
{
	private Object obj;
	public Object getObject()
	{
		return obj;
	}
	public void setObject(Object obj)
	{
		this.obj=obj;
	}
}
/*���ͳ���֮���÷�����ʹ�÷�ʽ
 * 
 * �����ࣺ������Ҫ�����������������Ͳ�ȷ����ʱ��������object�������չ�����ڶ���
 * ��������ʵ�֡�
 * */
class Utils<QQ>
{
	private QQ q;
	public QQ getObject()
	{
		return q;
	}
	public void setObject(QQ q)
	{
		this.q=q;
	}
}








