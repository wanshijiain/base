package com.czw.jichu.threadeducation;
/*���ִ�ͳ�̵߳ķ�ʽ��*/
public class TraditionalThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��һ�֣�����Thread��run����
		Thread thread = new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread:" + Thread.currentThread());
				}
			}
		};
		
		//�ڶ��֣�ʵ��Runnable�ӿڵ�run����
		Thread thread1 = new Thread(
				new Runnable(){
					public void run(){
						while(true){
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Runnable:" + Thread.currentThread());
						}
					}
				}){};
		
		//�����֣��������ߵĽ�ϡ��������û��ʵ��run����ȥ�ҽӿ���ʵ��run�ķ�����
		new Thread(
				new Runnable(){
					public void run(){
						while(true){
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Runnable:" + Thread.currentThread());
						}
					}
				}
				){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread:" + Thread.currentThread());
				}
			}
		}.start();
	}

}
