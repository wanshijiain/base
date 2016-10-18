package com.czw.model.factory.simple;

import org.junit.Test;

import com.czw.model.factory.bean.Animal;

/**
 * 优点：获取对象方便
 * 缺点：扩展难，对象过多不利于维护
 * 
 * 场景：创建不同的产品
 * 
 * @author ZeviChen , 2016-08-11 12:00:17
 */
public class MainTest {
	
	
	@Test
	public void test(){
		Animal wolf = AnimalFactory.getWolf();
		System.out.println(wolf.say());
		
		//简单工厂
		Product p = SimpleFactory.getInstance("pa");
		p.methodDiff();
		p.methodSame();
	}
	
}
