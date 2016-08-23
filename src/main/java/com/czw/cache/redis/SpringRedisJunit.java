package com.czw.cache.redis;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
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
	private static org.slf4j.Logger log = LoggerFactory.getLogger(SpringRedisJunit.class);
	
	@Autowired
	private RedisTemp redisTemp;
	
	@Test
	public void test() throws MalformedURLException{
//		redisTemp.addLinkByStrTmp("baidu", "www.baidu.com");
//		log.info("张三的link结果：",redisTemp.getLinkForStrTmp("张三"));
		String rst = redisTemp.getForStrTmp("name");
		System.out.println("结果: "+rst);
//		redisTemp.pingJedis();
	}
	
	
	
	

}
