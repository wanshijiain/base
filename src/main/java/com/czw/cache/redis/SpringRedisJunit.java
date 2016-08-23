package com.czw.cache.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author ZeviChen
 * @Date 2016-08-23 14:39:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RedisConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class SpringRedisJunit {
	
	@Autowired
	private RedisTemp tempRedis;
	
	@Test
	public void test(){
		
	}
	
	
	
	

}
