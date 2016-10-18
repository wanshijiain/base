/**
 * 
 */
package com.czw.model.factory.methodpattern;

/**
 * @author ZeviChen , 2016-10-18 14:36:16
 */
public class DBLoggerFactory extends LoggerFactory {

	@Override
	public Logger createLogger() {
		System.out.println("DBLoggerFactory - 打印数据库日志的一些初始化工作");
		return new DBLogger();
	}

}
