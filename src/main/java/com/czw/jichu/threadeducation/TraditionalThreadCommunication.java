package com.czw.jichu.threadeducation;

//面试题目：main线程和sub线程交替执行10次，sub线程每次循环2次，main线程每次循环4次
public class TraditionalThreadCommunication {

	public static void main(String[] args) {
		
		final Business business = new Business();
		new Thread(
				new Runnable() {
					
					@Override
					public void run() {
					
						for(int i=1;i<=20;i++){
							business.sub(i);
						}
						
					}
				}
		).start();
		
		for(int i=1;i<=10;i++){
			business.main(i);
		}
		
	}

}
  class Business {
	  private boolean bShouldSub = true;
	  public synchronized void sub(int i){
		  while(!bShouldSub){
			  try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
			for(int j=1;j<=2;j++){
				System.out.println("sub thread sequence of " + j + ",loop of " + i);
			}
		  bShouldSub = false;
		  this.notify();
	  }
	  
	  public synchronized void main(int i){
		  	while(bShouldSub){
		  		try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  	}
			for(int j=1;j<=4;j++){
				System.out.println("main thread sequence of " + j + ",loop of " + i);
			}
			bShouldSub = true;
			this.notify();
	  }
	
	
	
	
	
	
/*	
 * 
 * 这段代码有问题，还没有实现功能
 * 
 * static boolean flag = true;
	static String lock="";
	static int i;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(){
			public void run() {
				
				while (i<50) {
					synchronized (lock) {
						while (!flag) { //flag=true,就一直等待,不打印循环
							try {
								Thread.currentThread().wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						for (int j = 0; j < 10; j++) {
							System.out.println(Thread.currentThread().getName()
									+ "--" + j + "--" + i);
						}
						flag = false;
						Thread.currentThread().notify();
					}
				}
			}
		};
		
		
		t.start();
		for(i=0;i<50;i++){
			synchronized (lock) {
				while(flag){
					try {
						Thread.currentThread().wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int j=0;j<20;j++){
						System.out.println(Thread.currentThread().getName()+"--"+j+"--"+i);
					}
					flag=true;
					Thread.currentThread().notify();
				}
			}
		}
		
	}
*/
}
