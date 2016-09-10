/**
 * 
 */
package com.czw.spring.base;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czw.spring.base.ioc.MyApplicationContext;
import com.czw.spring.base.ioc.Person;

/**
 * http://spring.cndocs.tk/beans.html#beans-factory-aware
 * 1.ApplicationContextAware 
 * 2.BeanNameAware
 * 
 * @author ZeviChen
 * @date 2016-09-09 23:48:02
 */
public class TestGetBeans {
	private AbstractApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
	}
	
	/**
	 * ApplicationContextAware在contextLoaderListener中测试才能体现出效果
	 */
	@Test
	public void applicationContextAware(){
		MyApplicationContext myctx =  (MyApplicationContext) ctx.getBean("myctx");
		Person p = (Person) myctx.getBean("person1");
		p.sing("Surrender - Darin");
				
		
		
	}
	
	
	
}
