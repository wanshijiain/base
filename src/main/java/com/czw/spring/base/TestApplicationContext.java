package com.czw.spring.base;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionDefaults;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
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
	public void beanPostProcessor() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
		Person person = ctx.getBean(Person.class);
		person.sing("Only One - BoA");
	}

	/**
	 * 可以将外部创建的对象放入ioc容器中
	 */
	@Test
	public void outsideBeanRegistrater() {
		BeanDefinitionDefaults bdb = new BeanDefinitionDefaults();

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
		DefaultListableBeanFactory bf = (DefaultListableBeanFactory) ctx.getBeanFactory();
		// bf.registerBeanDefinition("", beanDefinition);

	}

}
