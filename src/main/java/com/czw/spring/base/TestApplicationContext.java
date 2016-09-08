package com.czw.spring.base;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czw.spring.base.ioc.Person;

/**
 * @author ZeviChen
 * @Date 2016-09-07 17:58:35
 */
public class TestApplicationContext {
	
	
	@Test
	@Ignore
	public void beanPostProcessor(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
		Person person = context.getBean(Person.class);
		person.sing("Only One - BoA");
	}
	
	@Test
	public void beanFactory(){
		
	}
	
	
}
