package com.czw.spring.base;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import com.czw.spring.base.ioc.Person;

/**
 * @author ZeviChen
 * @Date 2016-09-07 17:58:35
 */
public class TestApplicationContext {
	
	
	@Test
	@Ignore
	public void beanPostProcessor(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
		BeanFactory beanFactory = new DefaultListableBeanFactory();
		Person person = beanFactory.getBean(Person.class);
		person.sing("Only One - BoA");
	}
	
	@Test
	public void beanFactory(){
		
	}
	
	
}
