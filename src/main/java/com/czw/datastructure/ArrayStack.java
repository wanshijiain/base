package com.czw.datastructure;
/**
 * @author czw,2012/10/20
 * @param <E>
 */
public class ArrayStack<E> {
	public int count;
	public Object[] as;
	//初始化栈容量20
	public ArrayStack(){
		as = new Object[20];
		count = 0;
	}
	//自定义栈容量size
	public ArrayStack(int size){
		as = new Object[size];
		count = 0;
	}
	//重置栈容量
	private void resize(int size){
		Object[] ass = new Object[size];
		for(int i = 0;i<ass.length;i++){
			ass[i] = as[i];
		}
		as = ass;
	}
	//压栈
	public void push(E e){
		if((count+1) == as.length) resize(2*as.length);
		as[++count] = e;
		System.out.println("push "+e);
	}
	public E pop(){
		if(count == 0) return null;//count=0占据一个空间不被使用
		E item = (E)as[count];
		count--;
		//当取值候栈空间0~1/3之间，重置栈空间1/2
		if(count>0&&count<as.length/3) resize(as.length/2);
		return item;
	}
	public boolean isEmpty(){
		return count == 0 ;
	}

	
	
	
	
}
