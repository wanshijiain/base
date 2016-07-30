package com.czw.jichu.threadeducation;

public class TraditionalThreadSychronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TraditionalThreadSychronized().init();
	}
	public void init(){
		new Thread(){
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					new Outputer().outputer("aaaaa");
				}
			}
		}.start();
		new Thread(){
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					new Outputer().outputer("bbbbb");
				}
			}
		}.start();
	}

	static class Outputer{
//		String flag = "";
		public void outputer(String name){
			synchronized (this) {
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i)+"--"+i+"  ");
				}
				System.out.println();
			}
			
//			for (int i = 0; i < name.length(); i++) {
//				System.out.print(name.charAt(i)+"--"+i+"  ");
//			}
//			System.out.println();
		}
		public synchronized void outputer2(String name){
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i)+"--"+i+"  ");
				}
				System.out.println();
		}
		public static synchronized void outputer3(String name){
				for (int i = 0; i < name.length(); i++) {
					System.out.print(name.charAt(i)+"--"+i+"  ");
				}
				System.out.println();
		}
	}
}

