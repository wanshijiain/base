package com.czw.jichu.prodemo1;

//�������ģʽ

//����ʽ
class Single1{
	private static final Single1 s=new Single1();   //�����ɳ���
	private Single1(){}
	public static Single1 getInstance(){		//���󷵻غ���
		return s;
		
	}
}

//����ʽ
	//�ص㣺ʵ�����ӳټ���
	//���⣺���̷߳���ʱ����ְ�ȫ����
	//�������ͬ�������ķ�ʽ�����������Ч����Щ�ͣ���˫���жϽ��Ч�����⣨���������������ֽ����ļ�����
class Single2{
	private static Single2 s=null;
	public static Single2 getInstance(){
		if(s==null){
			synchronized(Single2.class){
				if(s==null)
					s=new Single2();
			}
		}
		return s;
	}
}
public class SingleDesigner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
