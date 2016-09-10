package com.czw.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

/**
 * @author ZeviChen
 * @Date 2016-09-10 16:13:12
 */
public class MainTest {
	
	@Test
	public void proxyTest(){
		IPhone iPhone = new IPhone();
		ClassLoader cl = 	iPhone.getClass().getClassLoader();
		
		Class[] interfaces = iPhone.getClass().getInterfaces();
		InvocationHandler ih = new ProxyIPhone();
		
		Mobile p = (Mobile) Proxy.newProxyInstance(cl, interfaces, ih);
		p.charge();
		
	}
	
}
