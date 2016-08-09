package com.czw.util;

import redis.clients.jedis.Jedis;

/**
 * @author ZeviChen
 * @Date 2016-08-09 12:50:58
 */
public class RedisUtils {
	
	private static Jedis jedis;
	private static String url = "192.168.229.128";
	private static int port = 6379;
	
	public static Jedis init(){
		if(null == jedis)
			jedis = new Jedis(url);
		jedis.auth("123456");
		return jedis;
	}
	
	
}
