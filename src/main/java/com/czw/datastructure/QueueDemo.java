package com.czw.datastructure;

/**
 * @author czw,2012/12/13
 */
public class QueueDemo {

	public static void main(String[] args) {
		ArrayQueueTest();
	}
	public static void ArrayQueueTest(){
		ArrayQueue<String> aQueue = new ArrayQueue<>();
		aQueue.insert("aaa");
		aQueue.insert("bbb");
		aQueue.insert("ccc");
		aQueue.insert("ddd");
		aQueue.all();
		System.out.println("获取队列头值0："+aQueue.remove());
		aQueue.insert("eee");
		aQueue.all();
		aQueue.insert("fff");
		aQueue.all();
		aQueue.insert("ggg");
		aQueue.all();
		aQueue.insert("hhh");
		aQueue.all();
		System.out.println("获取队列头值2："+aQueue.remove());
		System.out.println("获取队列头值3："+aQueue.remove());
		System.out.println("获取队列头值4："+aQueue.remove());
		aQueue.insert("iii");
		aQueue.insert("jjj");
		System.out.println("获取队列头值5："+aQueue.remove());
		System.out.println("获取队列头值6："+aQueue.remove());
		System.out.println("获取队列头值0："+aQueue.remove());
		aQueue.all();
	}

}
