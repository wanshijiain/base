/**
 * 
 */
package com.czw.model.factory.methodpattern;

/**
 * @author ZeviChen , 2016-10-18 14:34:38
 */
public abstract class LoggerFactory {
	
	abstract Logger createLogger();
	
	//通过抽象工厂的方法直接打印日志，而不需要再获取对象后
	//调用Logger.writeLogger()方法
	public void writeLogger(){
		Logger log = this.createLogger();
		log.writeLog();
	}
	
	
}
