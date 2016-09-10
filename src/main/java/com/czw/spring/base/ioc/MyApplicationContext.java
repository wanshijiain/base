package com.czw.spring.base.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 其他的Aware接口参见：http://spring.cndocs.tk/beans.html#aware-list
 * 
 * @author ZeviChen
 * @Date 2016-09-10 11:29:07
 */
public class MyApplicationContext implements ApplicationContextAware {
	private static ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}
	
	public static Object getBean(String beanName){
		if(ctx != null)
			return ctx.getBean(beanName);
		return null;
	}
	
}
