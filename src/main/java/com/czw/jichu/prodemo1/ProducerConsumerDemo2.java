package com.czw.jichu.prodemo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reasource2 res=new Reasource2();
		new Thread(new Producer1(res)).start();//���̵߳���������
		new Thread(new Consumer1(res)).start();//ȷ��Producer����һ����Consumer����һ��
		new Thread(new Producer1(res)).start();//�����֣���������֮����һ��������һ�����������εȴ�������
		new Thread(new Consumer1(res)).start();
		

	}

}
class Producer1 implements Runnable{
	private Reasource2 res;
	Producer1(Reasource2 res){
		this.res=res;
	}
	public void run(){
		try{
		while(true){
			res.set("��Ʒ");
		}
		}catch(InterruptedException e){}
	}
}

class Consumer1 implements Runnable{
	private Reasource2 res;
	Consumer1(Reasource2 res){
		this.res=res;
	}
	public void run(){
		try{
		while(true){
			res.get();
		}
		}catch(InterruptedException e){}
	}
	
}

/*����ע�͵Ĵ�����ʹ��synchronized��ͬ��������*/

//class Reasource1{
//	private String name;
//	private int count=1;
//	private boolean flag=false;
//	public synchronized void set(String name){
//		/*if(flag)*/
//		while(flag)			//while�жϱ�ǿ���ȷ��ÿ�������ѵĶ����ж�flag��ֵ
//			try{this.wait();}catch(InterruptedException e){}
//		this.name=name+"--"+count++;
//		
//		System.out.println(Thread.currentThread().getName()+"..������......"+this.name );
//		flag=true;
//		this.notifyAll();		//notifyAllȫ�����������Ƕ��жϱ�ǣ�ȷ��������ȫ���ȴ�
//	}
//	public synchronized void get(){
//		/*if(!flag)*/
//		while(!flag)
//			try{this.wait();}catch(InterruptedException e){}
//		System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
//		flag=false;
//		this.notifyAll();
//	}
//}

//JDK5.0֮��汾������
/*
 * ��ͬ��synchronized�滻����ʾLock����
 * ��Object�е�wait��notify��notifyAll�滻����Condition
 * �������Lock�����л�ȡ
 * 		await��Ҫ�׳��쳣
 * 		signal
 *ʵ�ֱ���ֻ���ѶԷ��Ĳ�����
 * */

/*
 * ��ʱͨ��Condition�����ֲ�ͬ�Ļ��Ѻ͵ȴ����ͣ��ǲ���Ҫ���ѵĳ��򣬱��ֵȴ�״̬��������߳����Ч�ʡ�
 * */
class Reasource2{
	private String name;
	private int count=1;//count��Ϊ�˼�¼�������Ĳ�Ʒ�����ͱ�����ȥ�ĳ�ƽ��
	private boolean flag=false;//flag��ǵĽ�����Ϊ��ʹ��Ʒ�����������û�б���Ӧ������ȥ��
	
	private Lock lock=new ReentrantLock();
	private Condition condition_pro=lock.newCondition();//���ԣ�java.util.concurrent
	private Condition condition_con=lock.newCondition();//ͨ������condition�ķ��������Ѻ͵ȴ���ͬ������
	
	public void set(String name)throws InterruptedException{
		lock.lock();
		try{
			while(flag)			
				condition_pro.await();
			this.name=name+"--"+count++;
			
			System.out.println(Thread.currentThread().getName()+"..������......"+this.name );
			flag=true;
			condition_con.signalAll();//��Ǹı�������ִ���꣬�ͷ����е������ߵȴ��̡߳�
		}finally{
			lock.unlock();//�쳣�еĲ����������ͷ����Ĳ���һ��Ҫִ�С�
		}
	}
	public void get()throws InterruptedException{
		lock.lock();
		try{
			while(!flag)
				condition_con.await();
			System.out.println(Thread.currentThread().getName()+"..������.."+this.name);
			flag=false;
			condition_pro.signalAll();
		}finally{
			lock.unlock();
		}
	}
}
