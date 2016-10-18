package com.czw.model.singleton;

/**
 * 
 * @author Zevi Chan
 * @Date 2016-07-27 10:59:16
 */
public class LazySingleton {
	
	private static LazySingleton fullSingleton = null;
	
	private LazySingleton(){}
	
	public static LazySingleton getInstance(){
		if(fullSingleton == null)
			synchronized (LazySingleton.class){
				if(fullSingleton == null)
					fullSingleton = new LazySingleton();
			}
		return fullSingleton;
	}
	
	
	
}
