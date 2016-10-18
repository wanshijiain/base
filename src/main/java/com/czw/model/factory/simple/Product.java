/**
 * 
 */
package com.czw.model.factory.simple;

/**
 * 
 * @author ZeviChen , 2016-10-18 13:56:45
 */
public abstract class Product {
	public void methodSame(){
		System.out.println("methodSame");
	}
	public abstract void methodDiff();
}
