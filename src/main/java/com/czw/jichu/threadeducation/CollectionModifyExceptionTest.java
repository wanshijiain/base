package com.czw.jichu.threadeducation;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全的集合，扩展子ArrayList
 * 适用于读操作比较多的情况下使用，当写入数据会copy一份新的数据到集合中
 */
public class CollectionModifyExceptionTest {
	public static void main(String[] args) {
		Collection users = new CopyOnWriteArrayList();
			
			//new ArrayList();
		users.add(new User("张三",28));	
		users.add(new User("李四",25));			
		users.add(new User("王五",31));	
		Iterator itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			User user = (User)itrUsers.next();
			if("李四".equals(user.getName())){
				users.remove(user);
				//itrUsers.remove();
			} else {
				System.out.println(user);				
			}
		}
		System.out.println("=================");
		Object[] list = users.toArray();
		for(Object o:list){
			System.out.println(o.toString());
		}
	}
}	 