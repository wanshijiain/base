package com.czw.spring.base.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ZeviChen
 * @Date 2016-09-07 17:41:25
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	
	public MyBeanPostProcessor() {
		super();
		System.out.println("我的BeanPostProcessor初始化");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("~~~~~~~~~~~~~~~~~~postProcessBeforeInitialization - beanName 是 :"+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("~~~~~~~~~~~~~~~~~~postProcessAfterInitialization - beanName 是 :"+beanName);
		return bean;
	}

}
