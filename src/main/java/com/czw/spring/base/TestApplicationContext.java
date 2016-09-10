package com.czw.spring.base;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionDefaults;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.czw.spring.base.ioc.Person;

/**
 * @author ZeviChen
 * @Date 2016-09-07 17:58:35
 */
public class TestApplicationContext {

	@Test
//	@Ignore
	public void beanPostProcessor() {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
		
		Person person = ctx.getBean(Person.class);
		person.sing("Only One - BoA");
		ctx.close();
		
		//在非web应用程序中调用,用于优雅的关闭spring ioc
		//ctx.registerShutdownHook();
	}

	/**
	 * 可以将外部创建的对象放入ioc容器中
	 */
	@Test
	@Ignore
	public void outsideBeanRegistrater() {
		BeanDefinitionDefaults bdb = new BeanDefinitionDefaults();

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-test/spring-ioc.xml");
		DefaultListableBeanFactory bf = (DefaultListableBeanFactory) ctx.getBeanFactory();
		// bf.registerBeanDefinition("", beanDefinition);

	}
	
	@Test
	public void testUnreferencedSingletonWasInstantiated() {
		KnowsIfInstantiated.clearInstantiationRecord();
		DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
		Properties p = new Properties();
		p.setProperty("x1.(class)", KnowsIfInstantiated.class.getName());
		assertTrue("singleton not instantiated", !KnowsIfInstantiated.wasInstantiated());
		(new PropertiesBeanDefinitionReader(lbf)).registerBeanDefinitions(p);
		lbf.preInstantiateSingletons();
		assertTrue("singleton was instantiated", KnowsIfInstantiated.wasInstantiated());
	}
	
	@SuppressWarnings("unused")
	private static class KnowsIfInstantiated {

		private static boolean instantiated;

		public static void clearInstantiationRecord() {
			instantiated = false;
		}

		public static boolean wasInstantiated() {
			return instantiated;
		}

		public KnowsIfInstantiated() {
			instantiated = true;
		}

	}

}
