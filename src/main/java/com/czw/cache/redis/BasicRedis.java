package com.czw.cache.redis;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import redis.clients.jedis.Jedis;

/**
 * @author ZeviChen
 * @Date 2016-08-23 14:39:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RedisConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class BasicRedis {
	
	protected static Logger log = LoggerFactory.getLogger(BasicRedis.class);
	@Autowired
	private Jedis jedis;
	
	protected void ping() {
		log.info(jedis.ping());
	}
	
}
