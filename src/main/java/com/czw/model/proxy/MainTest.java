package com.czw.model.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Ignore;
import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author ZeviChen
 * @Date 2016-09-10 16:13:12
 */
public class MainTest {
	
	@Test
	@Ignore
	public void jdkProxyTest(){
		IPhone iPhone = new IPhone("zhangsan");
		ClassLoader cl = 	iPhone.getClass().getClassLoader();
		
		Class[] interfaces = iPhone.getClass().getInterfaces();
		InvocationHandler ih = new ProxyIPhone(iPhone);
		
		Mobile p = (Mobile) Proxy.newProxyInstance(cl, interfaces, ih);
		p.charge();
		
	}
	@Test
	public void cglibProxyTest(){
		Android android = new Android();
		ProxyAndroid proxyAndroid = new ProxyAndroid();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(android.getClass());
		enhancer.setCallback(proxyAndroid);
		
		Android proxy =  (Android) enhancer.create();
		proxy.charge();
		
		
	}
	
}
