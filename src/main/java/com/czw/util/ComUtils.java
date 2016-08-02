package com.czw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zevi Chan
 * @Date 2016-08-02 15:38:17
 */
public class ComUtils {
	private static long startTime = 0;
	private static long endTime = 0;
	
	private static Logger log = LoggerFactory.getLogger(ComUtils.class);
	public static void start(){
		System.out.println("--------------开始计时----------------");
		startTime = System.currentTimeMillis();
	}
	public static void end(){
		endTime = System.currentTimeMillis();
		long rtn = 0;
		if(startTime < 0)
			startTime = 0;
		if(endTime < 0)
			endTime = 0;
		rtn = endTime-startTime;
		if(rtn == endTime)
			rtn = 0;
		log.info("Spend Time:{}",endTime <= startTime?0:rtn);
		System.out.println("--------------结束计时----------------");
	}
	
	
	
}
