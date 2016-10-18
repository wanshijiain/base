/**
 * 
 */
package com.czw.model.factory.methodpattern;

/**
 * @author ZeviChen , 2016-10-18 14:35:45
 */
public class FileLoggerFactory extends LoggerFactory {

	@Override
	public Logger createLogger() {
		System.out.println("FileLoggerFactory - 打印文件日志的一些初始化工作");
		return new FileLogger();
	}

}
