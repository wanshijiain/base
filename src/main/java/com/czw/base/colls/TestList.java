package com.czw.base.colls;

import org.junit.Test;

/**
 * ArrayList:
 * 默认空间10,容量0则Object[] elementData = {}
 * 
 * @author ZeviChen
 * @Date 2016-09-11 09:41:03
 */
public class TestList {
	
	
	@Test
	public void arrayListTest(){
		TArrayList<String> tal = new TArrayList<>();
		tal.add("张三");
		tal.add("lisi");
		System.out.println(tal.get(0)+" , "+tal.get(1));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
