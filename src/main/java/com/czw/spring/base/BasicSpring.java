package com.czw.spring.base;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


/**
 * @author ZeviChen
 * @Date 2016-09-07 17:18:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Config.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class BasicSpring {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	
	
	
	
	
	
	
	
	
}
