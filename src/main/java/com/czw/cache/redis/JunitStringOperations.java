package com.czw.cache.redis;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZeviChen
 * @Date 2016-08-24 14:53:51
 */
public class JunitStringOperations extends BasicRedis {
	
	@Autowired
	private ValueRdsTmp valueRdsTmp;
	
	@Before
	public void init(){
		ping();
	}
	
	@Test
	public void stringTest() throws MalformedURLException{
		String name = valueRdsTmp.get("name");
		System.out.println("name = "+name);
	}
	
}
