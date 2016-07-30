package com.czw.jichu.prodemo1;
/*
 * Thread.currentThread()����ȡ��ǰ�߳���
 * 
 * Reasource1����ķ�����ͬ���ģ��������������̺߳������̶߳�ֻ��ִ��������е�һ��������
 * 
 * ����Producer�߳�������Դ��������һ����Ʒ֮�󣬱�ǩflag�ı䡣��ʱֻ��������Consumer�е�һ����������Դ��
 * 
 * */
public class ProducerConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reasource1 res=new Reasource1();
		new Thread(new Producer(res)).start();//���̵߳���������
		new Thread(new Consumer(res)).start();//ȷ��Producer����һ����Consumer����һ��
		new Thread(new Producer(res)).start();//�����֣���������֮����һ��������һ�����������εȴ�������
		new Thread(new Consumer(res)).start();
		

	}

}
class Producer implements Runnable{
	private Reasource1 res;
	Producer(Reasource1 res){
		this.res=res;
	}
	public void run(){
		while(true){
			res.set("��Ʒ");
		}
	}
}

class Consumer implements Runnable{
	private Reasource1 res;
	Consumer(Reasource1 res){
		this.res=res;
	}
	public void run(){
		while(true){
			res.get();
		}
	}
	
}

class Reasource1{
	private String name;
	private int count=1;
	private boolean flag=false;
	public synchronized void set(String name){
		/*if(flag)*/
		while(flag)			//while�жϱ�ǿ���ȷ��ÿ�������ѵĶ����ж�flag��ֵ
			try{this.wait();}catch(InterruptedException e){}
		this.name=name+"--"+count++;
		
		System.out.println(Thread.currentThread().getName()+"..������......"+this.name );
		flag=true;
		this.notifyAll();		//notifyAllȫ�����������Ƕ��жϱ�ǣ�ȷ��������ȫ���ȴ�
	}
	public synchronized void get(){
		/*if(!flag)*/
		while(!flag)
			try{this.wait();}catch(InterruptedException e){}
		System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
		flag=false;
		this.notifyAll();
	}
}
