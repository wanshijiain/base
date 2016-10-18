/**
 * 
 */
package com.czw.model.factory.methodpattern;

/**
 * @author ZeviChen , 2016-10-18 14:37:22
 */
public class FileLogger implements Logger {

	@Override
	public void writeLog() {
		System.out.println("FileLogger - 打印文件日志...");
	}

}
