package com.czw.util;

/**
 * 常量池
 * @author ZeviChen
 * @Date 2016-07-20 14:45:45
 */
public enum Months {
	
	//月份
	Jan(1,"January"),
	Feb(2,"February"),
	Mar(3,"March"),
	Apr(4,"April"),
	May(5,"May"),
	Jun(6,"June"),
	Jul(7,"July"),
	Aug(8,"August"),
	Sep(9,"September"),
	Oct(10,"October"),
	Nov(11,"November"),
	Dec(12,"December");
	
	private final int signum;
	private final String value;
	Months(int signum,String value){
		this.value = value;
		this.signum = signum;
	}
	public int getSignum() {
		return signum;
	}
	public String getValue() {
		return value;
	}
}
