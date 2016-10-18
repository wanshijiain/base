/**
 * 
 */
package com.czw.model.factory.methodpattern;

/**
 * 优点：易于扩展,符合开闭原则，
 * 缺点：创建对应的产品类和工厂类会很麻烦
 * 
 * 场景：很多开源软件使用，本例的不同日志打印(文件打印，数据库打印，控制台打印...)
 * 
 * @author ZeviChen , 2016-10-18 14:38:11
 */
public class MainTest {

	public static void main(String[] args) {
		LoggerFactory lf = new FileLoggerFactory();
		Logger l = lf.createLogger();
		l.writeLog();
		
		System.out.println("-------------------------------------------");
		LoggerFactory dblf = new DBLoggerFactory();
		dblf.writeLogger();
	}

}
