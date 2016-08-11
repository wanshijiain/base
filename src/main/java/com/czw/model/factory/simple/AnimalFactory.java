package com.czw.model.factory.simple;

import com.czw.model.factory.bean.Animal;
import com.czw.model.factory.bean.Lion;
import com.czw.model.factory.bean.Wolf;

/**
 * 普通工厂一般用于不对用户暴露的具体实现，通过接口来获取对象
 * 比如这些动物类来自另一个java包，你无法做修改
 * 
 * @author ZeviChen
 * @Date 2016-08-11 11:58:12
 */
public class AnimalFactory {
	
	/**
	 * 1.静态化方法
	 * @return
	 */
	public static Animal getWolf(){
		return new Wolf();
	}
	public static Animal getLion(){
		return new Lion();
	}
	
	
	/**
	 * 2.name获取实例方法
	 * @param name
	 */
	public static Animal getAnimal(String name){
		Animal animal = null;
		switch(name){
		case "lion":animal = new Lion();break;
		case "wolf":animal = new Wolf();break;
		}
		return animal;
	}
	
}
