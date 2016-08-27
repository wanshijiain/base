/**
 * 
 */
package com.czw.toolkit.guava.base;


import org.junit.Test;

import com.czw.util.ComUtils;
import com.google.common.base.Optional;

/**
 * guava取消null的模糊语义,改用明确值来明确某一结果,即快速失败处理
 * @author ZeviChen
 * @date 2016-08-27 09:32:10
 */
public class TestOptional {
	
	@Test
	public void test(){
		ComUtils.ps("创建Present实例");
		//创建了Present实例,快速检查失败
		Optional<Integer> opt1 = Optional.of(5);
		System.out.println(opt1.get());
		ComUtils.pe("fewfew");
		
		ComUtils.ps("创建无引用实例");
		//创建没有引用的实例
		Optional<String> opt2 = Optional.absent();
		opt2 = Optional.of("hangzhou");
		if(opt2.orNull() != null)
			System.out.println(opt2.get());
		
		ComUtils.ps("可引用空值");
		Optional<String> opt3 = Optional.fromNullable(null);
		System.out.println("isPresent: "+opt3.isPresent());
		if(opt3.isPresent())
			System.out.println("present: "+opt3.get());//get nonull rst.
		else
			System.out.println("null: "+opt3.orNull());//get ornull rst.
		
	}
	
	
	
	
	
}
