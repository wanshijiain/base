package com.czw.spring.base;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 * @author ZeviChen
 * @Date 2016-09-09 15:15:43
 */
public class MyMethodReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		StringBuilder sb = new StringBuilder();
		for(Object o:args){
			sb.append(o.toString()+" ");
		}
		
		System.out.println("【 Replace Method 】"+obj+" , "+method.getName()+" , "+ sb);
		return null;
	}

}
