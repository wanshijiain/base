package com.czw.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ZeviChen
 * @Date 2016-08-09 12:50:58
 */
public class RedisUtils {

	private static Jedis jedis;
	private static String url = "192.168.229.128";
	// private static String url = "127.0.0.1";
	private static int port = 6379;

	// pool
	private static JedisPoolConfig config = null;
	private static JedisPool pool = null;

	static {
		config = new JedisPoolConfig();
		//连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		config.setBlockWhenExhausted(true);
		
		//设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
		config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
		
		config.setMaxTotal(100);
		config.setMaxIdle(1000);
		config.setMaxWaitMillis(30000);
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, url, 6380);
	}

	public static Jedis init() {
		if (null == jedis)
			jedis = new Jedis(url);
		jedis.auth("123456");
		return jedis;
	}
	
	public static Jedis getResource(){
		return pool.getResource();
	}

}
