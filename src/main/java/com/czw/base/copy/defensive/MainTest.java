package com.czw.base.copy.defensive;

import java.util.Arrays;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月14日 下午5:12:56 
 * 
 */
public class MainTest {
	private static Logger log = LoggerFactory.getLogger(MainTest.class);
	
	
	@Test
	@Ignore
	public void test(){
		int[] arrs = {1,2,3,4,5};
		log.info("Arrays.asList(arrs) toString = {}",Arrays.asList(arrs));		//[[I@11d617d]
		log.info("Arrays.toString(arrs) toString = {}",Arrays.toString(arrs));	//[1, 2, 3, 4, 5]
	}
	
	
	/**
	 * 未保护的参数很容易被修改
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void defensiveCopy1(){
		/*Date start = new Date();
		Date end = new Date();
		DefensiveCopy1 dc1 = new DefensiveCopy1(start, end);
		end.setYear(78);
		log.info("DefensiveCopy1: \nstart = {} , end = {}",dc1.start().toString(),dc1.end().toString());*/
		
		//构造器参数保护
		/*Date start = new Date();
		Date end = new Date();
		DefensiveCopy2 dc1 = new DefensiveCopy2(start, end);
		end.setYear(78);	
		log.info("DefensiveCopy1: \nstart = {} , end = {}",dc1.start().toString(),dc1.end().toString());*/
		
		
		//构造器参数和返回值保护,这种保护性拷贝就不会出现可以修改类中参数值的情况
		Date start = new Date();
		Date end = new Date();
		DefensiveCopy3 dc1 = new DefensiveCopy3(start, end);
		end.setYear(78);
		dc1.start().setYear(10);
		log.info("DefensiveCopy1: \nstart = {} , end = {}",dc1.start().toString(),dc1.end().toString());
		
	}
	
	
	
	
	
	
	
	
}
