package com.czw.datastructure;

/**
 * 这个队列的问题：如果有很多的插入，最终队列将会变的很长，
 * 占据很多的存储空间，remove这些值后队列变的很长
 * 
 * 说明：其中数组复制可使用System.arraycopy(src,head,destination,desPosition,length)
 * 
 * @author czw,2012/10/07
 *
 * @param <E>
 */
public class ArrayQueue<E> {
	private int front;
	private int rear;
	private int reartemp;
	private int count;
	private int capacity;
	private int capacityIncrement;
	private Object[] queue;
	public ArrayQueue(){
		front = 0;
		rear = 0;
		count = 0;
		capacity = 4;//初始容量
		capacityIncrement = 2;//容量不足时，自增
		queue = new Object[capacity];
	}
	//插入队列，当达到队列初始容量，开始扩充队列
	public void insert(E e){
		if(count == capacity){
			System.out.print("----开始扩充 ----");
			capacity+=capacityIncrement;
			Object[] temp = new Object[capacity];
			if(front < reartemp){
				for(int i = front ;i <= reartemp;i++){
					temp[i] = queue[i];
				}
				
				//尾指针在扩增后的位置
				rear = (reartemp+capacityIncrement-1)%capacity;
			}
			else{
				for(int i = 0;i<=reartemp;i++){
					temp[i] = queue[i];
				}
				for(int j = front;j<count;j++){
					temp[j+capacityIncrement] = queue[j];
				}
				//头指针在扩增后的位置
				front = (front+capacityIncrement)%capacity;
			}
			queue = temp;
		}
		
		queue[rear] = e;
		System.out.println("insert " +e);
		reartemp = rear;
		rear = (rear+1)%capacity;
		count++;
		
	}
	//获取先进入队列的值，并删除这个数据
	public E remove(){
		if(count == 0) 
			return null;
		else{
			E e = (E)queue[front];
			queue[front] = null;
			front = (front+1)%capacity;
			count--;
			return e;
		}
	}
	public void all(){
		System.out.print("队列中的值：");
		for(int i = 0 ;i<queue.length;i++){
			System.out.print(i+" "+queue[i]+" ");
		}
		System.out.println();
	}
}
