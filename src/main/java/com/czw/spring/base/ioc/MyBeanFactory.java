/**
 * 
 */
package com.czw.spring.base.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author ZeviChen
 * @date 2016-09-07 22:51:51
 */
public class MyBeanFactory implements BeanFactoryAware {
	
	private static BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	public static BeanFactory getBeanFactory(){
		return beanFactory;
	}
	
}
