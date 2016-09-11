/**
 * 
 */
package com.czw.toolkit.guava.base;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.Optional;

/**
 * guava取消null的模糊语义,改用明确值来明确某一结果,即快速失败处理
 * 
 * Optional的应用场景：
 * 		有时别人写的方法会不知道传入的参数是否可以为null或者返回值是否可以为null的情况发生
 * 		将方法的返回类型指定为Optional，或者传入的参数用Optional校验null的情况
 * 		可以迫使调用者思考返回的引用缺失的情形
 * @author ZeviChen
 * @date 2016-08-27 09:32:10
 */
public class TestOptional {
	
	@Test
	public void test(){
		//创建了Present实例,如果null则失败
		Optional<Integer> opt1 = Optional.of(5);
		System.out.println(opt1.get());

		//创建没有引用的实例,Absent实现Optional接口
		Optional<String> opt2 = Optional.absent();
		opt2 = Optional.of("hangzhou");
		if(opt2.orNull() != null)
			System.out.println("ornull : "+opt2.get());
		
		//可以null的值
		Optional<String> opt3 = Optional.fromNullable(null);
		System.out.println("isPresent: "+opt3.isPresent());
		if(opt3.isPresent())
			System.out.println("present: "+opt3.get());//get nonull rst.
		else
			System.out.println("null: "+opt3.orNull());//get ornull rst.
		
		List<String> data = new ArrayList<>();
		data.add("zhangsan");
		data.add("lisi");
		Optional<List<String>> opt4 = Optional.of(data);
		Set<List<String>> opData = opt4.asSet();
		//JDK8 feature：possibleFoo.ifPresent(foo -> doSomethingWith(foo));
		
		//默认值来替换可能的null值：
		Object obj = Optional.fromNullable(null).or(1);
		System.out.println("replace null:"+obj);
		
	}
	
	
	
	
	
}
