package com.czw.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZeviChen
 * @Date 2016-09-10 16:00:16
 */
public class ProxyIPhone implements InvocationHandler {
	private IPhone iPhone;
	
	public ProxyIPhone(){
		if(iPhone == null)
			iPhone = new IPhone();
	}
	public ProxyIPhone(IPhone iPhone) {
		this.iPhone = iPhone;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理开始...");
		method.invoke(iPhone, args);
		System.out.println("代理结束...");
		return null;
	}
	

}
