package com.czw.base.colls;

/**
 * @author ZeviChen
 * @Date 2016-09-11 11:04:35
 */
public class TArrayList<E> {
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] DEFAULT_ELEMENTDATA = {};
	transient Object[] elementData;
	private int size;
	
	public TArrayList(){
		elementData = new Object[DEFAULT_CAPACITY];
	}
	public TArrayList(int initCapacity){
		if(initCapacity > 0){
			elementData = new Object[initCapacity];
		}else if(initCapacity == 0){
			elementData = DEFAULT_ELEMENTDATA;
		}else{
			throw new RuntimeException("不合法的容量值");
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean add(E e){
//		grow(size+1);
		elementData[size++] = e;
		return true;
	}
//	private void grow(int newCapacity){
//		elementData = Arrays.copyOf(elementData, newCapacity);
//	}
	
	public E get(int index){
		return (E) elementData[index];
	}
	

}
