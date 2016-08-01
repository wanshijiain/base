package com.czw.jichu.threadeducation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//面试题：缓存系统实现
public class CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public  Object getData(String key){
		rwl.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();//关闭读锁
				rwl.writeLock().lock();//开启写锁
				try{
					if(value==null){
						value = "aaaa";//实际失去queryDB();
					}
				}finally{
					rwl.writeLock().unlock();//关闭写锁
				}
				rwl.readLock().lock();//开启读锁
			}
		}finally{
			rwl.readLock().unlock();//关闭读锁
		}
		return value;
	}
}