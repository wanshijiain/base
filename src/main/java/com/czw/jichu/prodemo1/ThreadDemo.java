package com.czw.jichu.prodemo1;
/*
 * �߳�ͬ����ǰ�᣺
 * 1.����Ҫ���������������ϵ��߳�
 * 2�������Ƕ���߳�ʹ��ͬһ������
 *	
 * ���뱣֤ͬһʱ��ֻ��һ���߳�������
 * synchronized���εĺ���Ĭ�϶���Ϊthis
 * 
 * ��̬��ͬ��������ʹ�õ����Ǹ÷�����������ֽ����ļ�        ����.class
 * */
public class ThreadDemo {
	public static void main(String[] args){
		Ticket t=new Ticket();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		t1.start();
		t1.setPriority(6);
		try{Thread.sleep(10);}catch(Exception e){}
		t.flag=false;
		t2.start();
		
		/*�߳�0ִ��code���߳�1ִ��show�����ڲ�ѭ����ʱ��ͨ���ȴ��߳�ȥ�����������Դ��������100�ų�Ʊ*/
	}
}
class Ticket implements Runnable{
	private static int tick=100;		//���̹߳�������
	boolean flag=true;
	Object obj=new Object();
	public void run(){
		
			if(flag){
				while(true){
					synchronized(Ticket.class){			//�ֽ����ļ�����
						if(tick>0){
							try{Thread.sleep(10);}catch(Exception e){}
							System.out.println(Thread.currentThread().getName()+"....code:"+tick--);
						}
					}
				}
			}
			else{
				while(true)
				show();
			}
		
	}
	public static synchronized void show(){
		if(tick>0){
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"....show...:"+tick--);
		}
	}
	
	
}
