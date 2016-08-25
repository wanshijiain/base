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
		valueRdsTmp.set("100", "杭州");
		
		String addr = valueRdsTmp.get("100");
		System.out.println("addr = "+addr);
	}
	
}
