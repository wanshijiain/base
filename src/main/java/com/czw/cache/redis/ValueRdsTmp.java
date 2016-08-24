package com.czw.cache.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author ZeviChen
 * @Date 2016-08-24 13:14:46
 */
public class ValueRdsTmp extends StringRedisTemplate {
	
	private ValueOperations<String, String> vops = super.opsForValue();
	
	public String get(String key){
		return  (String) vops.get(key);
	}
	
	public void set(String key,String value){
		vops.set(key, value);
	}
	
}
