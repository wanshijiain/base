package com.czw.cache.redis;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.hash.HashMapper;

import com.czw.beans.User;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author ZeviChen
 * @Date 2016-08-24 14:57:04
 */
public class JunitHashOperations extends BasicRedis {

	@Resource(name = "redisTemplate")
	private HashOperations<Object, String, String> hashOperations;

	HashMapper<Object, String, String> mapper = new BeanUtilsHashMapper<Object>(null);

	@Test
	public void converterEntity() throws JsonProcessingException {
		User user = initUser();
		Map<String, String> rst = mapper.toHash(user);
		hashOperations.putAll(user.getId(), rst);
		
		//获取对象的某个属性值
		String name = hashOperations.get(user.getId(), "name");
		System.out.println("get(obj,k) = " + name);
		
		//获取对象值
		Map<String, String> rstUser = hashOperations.entries(user.getId());
		for (String key : rstUser.keySet()) {
			System.out.println(key + " | " + rstUser.get(key));
		}

		/*
		 * for (String key : rst.keySet()) { String value =
		 * hashOperations.get(user, key);
		 * System.out.println("结果显示：user = "+user+",key = "
		 * +key+",value = "+value); }
		 */

	}

	private User initUser() {
		User user = new User();
		user.setName("张三");
		user.setId(1);
		user.setGender("男");
		user.setBirthday("1999-06-06 10:00:00");
		user.setEmail("zevichen@qq.com");
		return user;
	}

}
