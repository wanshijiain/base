package com.czw.spring.base.ioc;

import java.util.Date;

import com.czw.util.DateUtils;

/**
 * @author ZeviChen
 * @Date 2016-09-07 17:32:02
 */
public class Person {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(){}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void sing(String songName){
		System.out.println("【Action:Sing,时间:"+DateUtils.dtts(new Date())+"】  "+name+" 在唱  "+songName +"  听着还不错... ");
	}
	
	public void learn(String course,long mills) throws InterruptedException{
		System.out.println(DateUtils.dtts(new Date()));
		Thread.sleep(mills);
		System.out.println("【Action:Learning】  "+name+" 在学习  "+course +"  ... 用时："+mills);
	}
	
	
}
