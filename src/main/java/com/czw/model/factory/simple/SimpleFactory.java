/**
 * 
 */
package com.czw.model.factory.simple;

/**
 * 可以将类型type配置在config配置文件中,通过读取xml配置来创建对应的对象
 * 这样的方式对系统没有侵入性
 * 
 * 简单工厂 - 通过传入类型来创建对应的对象，如果创建的对象有许多的前置行为：
 * 例如初始化配置，创建需要的对象等，会导致简单工厂的创建方法更加的庞大，最
 * 后不便于维护，所以就需要对简单工厂提供不同的工厂方法,包methodpattern
 * 
 * @author ZeviChen , 2016-10-18 13:57:57
 */
public class SimpleFactory {

	public static Product getInstance(String type) {
		Product product = null;
		switch (type) {
		case "pa":
			product = new ConcreteProductA();
			break;
		case "pb":
			product = new ConcreteProductB();
			break;
		}
		return product;
	}

}
