/**
 * 
 */
package com.czw.toolkit.guava.base;

import org.junit.Test;

import com.google.common.base.Preconditions;

/**
 * 使用場景有限
 * 
 * @author ZeviChen
 * @date 2016-09-11 20:25:37
 */
public class TestPreconditions {
	
	private String name;
	
	@Test
	public void checkArgumentTest(){
		//抛出异常的方式来处理结果
//		Preconditions.checkArgument(1 > 2,"非预期的结果 %s , %s",1,2);
		System.out.println(Preconditions.checkElementIndex(10, 20));
		
	}
	
	
	
}
