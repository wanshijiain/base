package com.czw.spring.base.ioc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.czw.spring.base.BasicSpring;

/**
 * 
 * @author ZeviChen
 * @Date 2016-09-07 17:22:05
 */
public class TestIoc extends BasicSpring {
	
	@Autowired
	private Person person;
	
	@Test
	public void beanPostProcessor() throws InterruptedException{
		person.sing("Summertrain - Greyson Chance");
		person.learn("data structure", 1000);
	}
	
	
}
