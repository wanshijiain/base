package com.czw.model.decorate;

/**
 * 修饰类
 * @author ZeviChen
 * @Date 2016-08-11 16:42:54
 */
public class MainTest {

	public static void main(String[] args) {
		Writeable writeable = new Writer();
		Writeable decorater = new Decorater(writeable);
		
		decorater.write();
		
	}

}
