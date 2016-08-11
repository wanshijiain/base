package com.czw.model.builder;

/**
 * @author ZeviChen
 * @Date 2016-08-11 14:48:42
 */
public class MainTest {

	public static void main(String[] args) {
		FactoryBuilder fb = FactoryBuilder.builder("张三").age(10).msg("some msgs").create();
		
		fb.getAddress();
		fb.getAge();
		fb.getMsg();
		
	}

}
