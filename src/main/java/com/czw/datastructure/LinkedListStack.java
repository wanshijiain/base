package com.czw.datastructure;

/**
 * @author czw,2012/11/20
 *
 * @param <E>
 */
public class LinkedListStack<E> {
	private class Node{
		E item;
		Node next;
	}
	Node head;
	public boolean isEmpty(){
		return head == null;
	}
	public void push(E e){
		Node node = new Node();
		node.item = e;
		node.next = head;
		head = node;
		System.out.println("push "+e);
	}
	//出栈栈顶栈值，并删除栈顶
	public E pop(){
		if(head == null) return null;
		E e = head.item;
		head = head.next;
		return e;
	}
	public E peek(){
		if(head == null)
			return null;
		else 
			return head.item;
	}
}
