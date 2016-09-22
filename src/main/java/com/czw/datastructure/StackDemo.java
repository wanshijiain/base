package com.czw.datastructure;

/**
 * @author czw,2012/11/24
 *
 */
public class StackDemo {

	public static void main(String[] args) {
		System.out.println("----------arraystack----------");
		arrayStackTest();
		System.out.println("----------linkedliststack----------");
		linkedlistStackTest();
	}
	public static  void arrayStackTest(){
		ArrayStack<String> aStack = new ArrayStack<>();
		aStack.push("zhangsan");
		aStack.push("lisi");
		aStack.push("wangwu");
		System.out.println("栈顶值pop:"+aStack.pop());
		aStack.push("aaaa");
		System.out.println("出栈值 pop:"+aStack.pop()+"  "+aStack.pop());
		
		
	}
	public static void linkedlistStackTest() {
		LinkedListStack<String> llStack = new LinkedListStack<>();
		llStack.push("aaa");
		llStack.push("bbb");
		llStack.push("ccc");
		System.out.println("当前栈顶pop："+llStack.pop()+" 次栈顶值peek： "+llStack.peek()+" 次栈顶值pop： "+llStack.pop());
		llStack.push("ddd");
		System.out.println("出栈值pop："+llStack.pop()+"  "+llStack.peek());
		
		
	}

}
