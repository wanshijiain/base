/**
 * 
 */
package com.czw.model.factory.methodpattern;

/**
 * @author ZeviChen , 2016-10-18 14:37:47
 */
public class DBLogger implements Logger {

	@Override
	public void writeLog() {
		System.out.println("DBLogger - 打印数据库日志...");
	}

}
