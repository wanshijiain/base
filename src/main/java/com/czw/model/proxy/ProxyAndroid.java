package com.czw.model.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author ZeviChen
 * @Date 2016-09-10 16:48:33
 */
public class ProxyAndroid implements MethodInterceptor {
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("cglib代理开始...");
		method.invoke(obj, args);
		System.out.println("cglib代理结束...");
		return null;
	}

}
