package com.czw.jichu.threadeducation;
/*��ʱ����Timer   TimerTask  ��*/
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {

	public static void main(String[] args) {
//		test();
		test1();
	}
	
	//�ҵĲ����߳�
	@SuppressWarnings("deprecation")
	public static void test1(){
		class MyTimerTask extends TimerTask{
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing"+"---"+Thread.currentThread());
				new Timer().schedule(new MyTimerTask(), 2000);
				
			}
		}
		new Timer().schedule(new MyTimerTask(), 3000);		
		while(true){
			System.out.println(new Date().getSeconds());
			/* Date����ƽ̨��û�п�������ġ�GMT��������ʱ  UT����ʱ(��ѧ)  UTC(���)
			 * Date��ȡʱ��ķ��������������̭���������������ȡʱ�估��ʽ��DateFormat
			 * Calendar.get(Calendar.MINUTE);*/
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//��Ƶ����
	private static int count = 0;
	public static void test() {
/*		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("bombing!");
				
			}
		}, 10000,3000);*/
		

		class MyTimerTask extends TimerTask{
			
			@Override
			public void run() {
				count = (count+1)%2;
				System.out.println("bombing!");
				new Timer().schedule(/*new TimerTask() {
					
					@Override
					public void run() {
						System.out.println("bombing!");
					}
				}*/new MyTimerTask(),2000+2000*count);
			}
		}
		
		new Timer().schedule(new MyTimerTask(), 2000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}









