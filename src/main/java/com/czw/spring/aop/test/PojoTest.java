package com.czw.spring.aop.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.czw.spring.aop.act.CompactDisc;
import com.czw.spring.aop.act.Performance;
import com.czw.spring.aop.aspectj.TrackCounter;
import com.czw.spring.aop.config.SystemConfig;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月21日 下午5:10:12 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SystemConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
//去除提示：Could not instantiate TestExecutionListener
public class PojoTest {
	private static Logger log = LoggerFactory.getLogger(PojoTest.class);
	
	@Autowired
	private Performance pf;
	@Autowired
	private CompactDisc cd;
	@Autowired
	private TrackCounter tc;
	
	/**
	 * 切面编程AspectJ
	 */
	@Test
	public void dance(){
		
		pf.perform();
		
	}
	
	@Test
	@Ignore
	public void disc(){
		cd.playTrack(0);
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(3);
		cd.playTrack(4);
		cd.playTrack(5);
		
		
		log.info("{} is {}",0,tc.getPlayCount(0));
		log.info("{} is {}",1,tc.getPlayCount(1));
		log.info("{} is {}",2,tc.getPlayCount(1));
		log.info("{} is {}",3,tc.getPlayCount(2));
		log.info("{} is {}",4,tc.getPlayCount(0));
		log.info("{} is {}",5,tc.getPlayCount(0));
		log.info("{} is {}",6,tc.getPlayCount(3));
		
	}
	
	
}
