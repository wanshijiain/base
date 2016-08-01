package com.czw.jichu.prodemo1;
/*����̼߳��ͨ������
 * 
 * �ȴ����ѻ���
 * 
 * ����synchronized��re��������ͬһ������ʹ�߳���ʹ�ù�����Դʱ�ܹ����������ﵽ���ݷ�װ
 * 
 * ���ݵ�˽�л�
 * 
 * �����ӡMike��������set��get������ͬ���ģ����������߳������е�ʱ��ֻ��ִ�����е�һ����
 * �����ǩ��ȷ���ڲ��Ƿ����ֵ�������Ѿ���ȡ��ֵ��
 * 
 * */

class Reasource{
	 private String name;
	 private String sex;
	 private boolean flag=false;
	 public synchronized void set(String name,String sex){
		 if(flag)
			 try{this.wait();}catch(InterruptedException e){}
		 this .name=name;
		 this.sex=sex;
		 flag=true;
		 this.notify();
	 }
	 public synchronized void  get(){
		 if(!flag)
			 try{this.wait();}catch(InterruptedException e){}
		 System.out.println(this.name+"...."+this.sex);
		 flag=false;
		 this.notify();
	 }

}
class Input implements Runnable{
	private Reasource r;
	int x=0;
	Input(Reasource r){
		this.r=r;
	}
	public void run (){
		while(true){
			/*synchronized(r){
				if(r.flag)
					try{r.wait();}catch(InterruptedException e){}*/
				if(x==0)
					r.set("Mike", "man");
					/*{
						r.name="Mike";
						r.sex="man";
				}*/
				else
					r.set("����", "ŮŮ");
					/*{
						r.name="����";
						r.sex="ŮŮ";			 	
				}
				r.flag=true;
				r.notify();*/
		/*	}*/
		x=(x+1)%2;
		}
	}
}

class Output implements Runnable{
	private Reasource r;
	Output(Reasource r){
		this.r=r;
	}
	public void run(){
		while(true){
			/*synchronized(r){
				if(!r.flag)
					try{r.wait();}catch(InterruptedException e){}
				System.out.println(r.name+"...."+r.sex);
				r.flag=false;
				r.notify();
			
			}*/
			r.get();
		}
	}
}

public class InputOutputDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reasource r=new Reasource();
		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
		
		
		/*Input in=new Input(r);
		Output out=new Output(r);
		Thread t1=new Thread(in);
		Thread t2=new Thread(out);
		
		t1.start();
		t2.start();*///ֻ�ǵ����ǣ������Ż�֮ǰ�Ķ���

	}

}

/*
 * wait()   notify()   notifyAll()
 * 
 * ��������ͬ���У���ΪҪ�Գ��ж����м��������������̲߳�����
 * ����Ҫʹ����ͬ���У���Ϊֻ��ͬ���ž�������
 * 
 * ��Щ�����̵߳ķ������������߳��У�
 * ��Ϊ��Щ�����ڲ���ͬ�����߳�ʱ��������Ҫ��ʶ�����������߳������е�����
 * ֻ��ͬһ�����ϵı��ȴ��̣߳����Ա�ͬһ�����ϵ�notify���ѡ�
 * 
 * �ȴ��ͻ��ѱ�����ͬһ������
 * 
 * ��������������������Կ��Ա����������õķ�������object���С�
 * 
 * */







