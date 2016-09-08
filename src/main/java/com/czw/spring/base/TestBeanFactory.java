package com.czw.spring.base;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.czw.spring.base.ioc.Person;

/**
 * @author ZeviChen
 * @Date 2016-09-08 15:52:48
 */
public class TestBeanFactory {
	
	
	
	/**
	 * beanFactory是spring最初提供的解析，初始化，存储创建对象的容器
	 * 不提供BeanPostProcessor,aop,事件驱动等功能（需要这些功能使用applicationContext）
	 */
	@Test
	@Ignore
	public void beanFactory() {
		BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(reg);
		reader.loadBeanDefinitions(new ClassPathResource("spring-test/spring-ioc.xml"));
		BeanFactory bf = (BeanFactory) reg;
		Person p = bf.getBean(Person.class);
		p.sing("Lucía - Alvaro Soler");
	}
}
