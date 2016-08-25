package com.czw.util;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author ZeviChen
 * @Date 2016-08-09 12:50:58
 */
public class RedisUtils {

	private static Jedis jedis;
	private static String url = "192.168.229.128";
	// private static String url = "192.168.124.128";
	// private static String url = "127.0.0.1";
	private static int port = 6379;
	private static String name = "master";
	

	// pool
	private static JedisPoolConfig config;
	private static JedisPool pool;
	private static ShardedJedis shardedJedis;//切片额客户端连接
    private static ShardedJedisPool shardedJedisPool;//切片连接池
	
	private static List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 

	static {
		initConfig();
		initPool();
		initShardPool();
	}
	
	private static void initConfig(){
		config = new JedisPoolConfig();
		// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
		// config.setBlockWhenExhausted(true);
		// 池基本配置
		// 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
		// config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(10000);
		config.setTestOnBorrow(false);
		// config.setTestWhileIdle(false);
		// config.setMinIdle(0);
	}
	
	private static void initPool(){
		pool = new JedisPool(config, url, port);
	}
	
	private static void initShardPool() 
    { 
        // slave链接 
        shards.add(new JedisShardInfo(url, port, name)); 
        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 

	public static Jedis init() {
		if (null == jedis)
			jedis = new Jedis(url);
		return jedis;
	}

	public static Jedis getResource() {
		return pool.getResource();
	}

}
