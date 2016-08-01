package com.czw.jichu.prodemo1;
/*
 * ֹͣ�߳�
 * 
 * �̻߳����϶���ѭ���ṹ��ֻҪ������ѭ�������Ϳ��Խ����߳�
 * 
 * ���������
 * ���̴߳��ڶ���״̬���Ͳ����ȡ��ǣ��߳̾Ͳ������
 * 
 * interruptǿ�ƽ���̵߳Ķ���״̬�����׳��쳣����ʱ���쳣�����д���ѭ�����������߳̽���
 * 
 * 
 * join��
 * ��A�߳�ִ�е�B�̵߳�join����ʱ��A�߳̾ͻ�ȵ�B�߳�ִ������ִ�С�
 * 
 * setDaemon();�÷���������̨�����̡߳�
 * 
 * setPrority(Thread.MAX_PRORITY)// �߳����ȼ�
 * Thread.yield()��΢�����̵߳�ִ�С�   ��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������߳�
 *  * */
public class StopThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		StopThread st=new StopThread();
		Thread t1=new Thread(st);
		Thread t2=new Thread(st);
		
		//t1.setDaemon(true);//�÷���������̨�̣߳��Ƕ�����̶߳�����
		//t2.setDaemon(true);//�ػ��߳�
		
		//t1.join();//����CPUִ��Ȩ��ִ������̣߳����ڵ���Ҫ��ʱ��Ҫ����һ���߳���ִ�С������׳��쳣
		t1.start();
		t2.start();
//		t1.join();//��join���������ǣ�main�߳�ֻ��ȵ�t1�߳̽�����ִ�С���ʱt1��t2��������CPUִ��Ȩ
		int num=0;
		while(true){
			if(num++==60){
				//st.changeFlag();
				//t1.interrupt();
				//t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+"...main");
		}
		System.out.println("over");

	}

}

class StopThread implements Runnable{
	
	public static int count=100;
	private boolean flag=true;
	public synchronized void run(){
		while(flag&&count>0){
			if(!flag)
				try{
					wait();
				}catch(InterruptedException e){
					System.out.println(Thread.currentThread().getName()+"...Exception");
					flag=false;
				}
			System.out.println(Thread.currentThread().getName()+"..run"+count--);
		}		
	}
	public void changeFlag(){
		flag=false;
	}
}
