package com.czw.model.factory.simple;

import org.junit.Test;

import com.czw.model.factory.bean.Animal;

/**
 * @author ZeviChen
 * @Date 2016-08-11 12:00:17
 */
public class MainTest {
	
	
	@Test
	public void test(){
		Animal wolf = AnimalFactory.getWolf();
		System.out.println(wolf.say());
	}
	
}
