package com.czw.cache.redis;

import org.junit.Before;
import org.junit.Test;

import com.czw.util.RedisUtils;

import redis.clients.jedis.Jedis;

/**
 * @author ZeviChen
 * @Date 2016-08-09 12:51:25
 */
public class JedisPing {
	private Jedis jedis;
	
	@Before
	public void init(){
		jedis = RedisUtils.init();
	}
	
	@Test
	public void test(){
		System.out.println("ping rst:"+jedis.ping());
	}
	
	
	
}
