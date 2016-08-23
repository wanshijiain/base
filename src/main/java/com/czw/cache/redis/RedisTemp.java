package com.czw.cache.redis;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.stereotype.Component;

import com.czw.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

/**
 * @author ZeviChen
 * @Date 2016-08-23 16:09:21
 */
@Component
public class RedisTemp {
	
	@Autowired
	private Jedis jedis;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 将redisTemplcate注入对应的类型操作类中. 注解的注入方式,另外有配置文件的配置方式
	 */
//	@Autowired
//	@Qualifier("redisTemplate")
	@Resource(name="redisTemplate")
	private ListOperations<String, String> listOps;

	@Autowired
	private StringRedisTemplate strTemplate;

	public void addByListTmp(String userId, String data) {
		listOps.leftPush(userId, data);
	}

	public void addByStrTmp(String userId, String data) {
		strTemplate.opsForList().leftPush(userId, data);
	}
	public String getForStrTmp(String userId){
//		return strTemplate.opsForList().set(arg0, arg1, arg2);
		return null;
	}

	/**
	 * RedisTemplate and StringRedisTemplate allow the developer to talk
	 * directly to Redis through the RedisCallback interface.Usually, used for
	 * chaining several operations together ( get/set/trim etc....) low level
	 * code
	 */
	public void useCallback() {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Long size = connection.dbSize();
				// Can cast to StringRedisConnection if using a
				// StringRedisTemplate
				((StringRedisConnection) connection).set("name", "zevi");
				return null;
			}
		});
	}
	
	public void pingJedis(){
		System.out.println("ping rst:"+jedis.ping());
	}
	
	
	@Resource(name="redisTemplate")
	HashOperations<String, String, String> hashOperations;
	HashMapper<Object, String, String> mapper = new BeanUtilsHashMapper<Object>(null);
	
	public void writeHash(String key, User user) {
		Map<String, String> mappedHash = mapper.toHash(user);
		hashOperations.putAll(key, mappedHash);
	}

	public User loadHash(String key) {
		Map<String, String> loadedHash = hashOperations.entries("key");
		return (User) mapper.fromHash(loadedHash);
	}
	
	
	/**
	 * execute a transaction
	 * @see http://docs.spring.io/spring-data/redis/docs/1.8.0.M1/reference/html/#tx.spring
	 */
	@SuppressWarnings({"unchecked","rawtypes"})
	public void txByredisTmp(){
		List<Object> txResults = redisTemplate.execute(new SessionCallback<List<Object>>() {
			public List<Object> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForSet().add("key", "value1");
				
				// This will contain the results of all ops in the transaction
				return operations.exec();
			}
		});
		System.out.println("Number of items added to set: " + txResults.get(0));
	}
}
