package com.czw.jichu.prodemo1;
/*�����������̣߳���main����ִ��ʱ��Ҳ�����߳��໥������Դȥִ�и��ԵĴ���*/
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println(Thread.currentThread().getName()+"...run"+i);
				}
			}
		}.start();
		for(int j=0;j<100;j++ ){
			System.out.println(Thread.currentThread().getName()+"...run..."+j);
			
		}
		Runnable r=new Runnable(){
			public void run(){
				for(int k=0;k<100;k++ ){
					System.out.println(Thread.currentThread().getName()+"...run......"+k);
					
				}
			}
		};
		new Thread(r).start();
	}

}
