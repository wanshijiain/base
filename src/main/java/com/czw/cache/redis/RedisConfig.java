package com.czw.cache.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

import com.czw.util.RedisUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author ZeviChen
 * @Date 2016-08-23 14:40:00
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
@ImportResource("classpath:spring-redis.xml")
public class RedisConfig {
	
	private String host = "192.168.229.128";
	private int port = 6379;
	private int sport = 6380;
	
	/**
	 * my config
	 * @return
	 */
	@Bean
	public Jedis getJredis(){
		return RedisUtils.init();
	}
	
	/**
	 * Jedis Sentinel cofig
	 * @return RedisConnectionFactory
	 */
	/*@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
	  RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration() .master("mymaster")
	  .sentinel(host, port) .sentinel(host, sport);
	  return new JedisConnectionFactory(sentinelConfig);
	}*/

	/**
	 * lettuce
	 */
	/*@Bean
	public RedisConnectionFactory lettuceConnectionFactory() {
	  RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
	  .sentinel(host, port) .sentinel("127.0.0.1", sport);
	  return new LettuceConnectionFactory(sentinelConfig);
	}*/
}
