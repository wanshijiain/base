package com.czw.cache.redis;

import java.net.URL;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.stereotype.Component;

import com.czw.beans.User;

/**
 * @author ZeviChen
 * @Date 2016-08-23 16:09:21
 */
@Component
public class RedisTemp {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 将redisTemplcate注入对应的类型操作类中. 注解的注入方式,另外有配置文件的配置方式
	 */
	@Autowired
	@Qualifier("redisTemplate")
	private ListOperations<String, String> listOps;

	@Autowired
	private StringRedisTemplate strTemplate;

	public void addLinkByListTmp(String userId, URL url) {
		listOps.leftPush(userId, url.toExternalForm());
	}

	public void addLinkByStrTmp(String userId, URL url) {
		strTemplate.opsForList().leftPush(userId, url.toExternalForm());
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
/*
	@Autowired
	@Qualifier("redisTemplcate")
	HashOperations<String, byte[], byte[]> hashOperations;
	HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

	public void writeHash(String key, User user) {
		Map<byte[], byte[]> mappedHash = mapper.toHash(user);
		hashOperations.putAll(key, mappedHash);
	}

	public User loadHash(String key) {
		Map<byte[], byte[]> loadedHash = hashOperations.entries("key");
		return (User) mapper.fromHash(loadedHash);
	}*/
}
