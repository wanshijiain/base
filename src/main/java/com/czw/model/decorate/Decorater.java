package com.czw.model.decorate;

/**
 * @author ZeviChen
 * @Date 2016-08-11 16:40:26
 */
public class Decorater implements Writeable {
	
	private Writeable writer;
	
	public Decorater(Writeable writer){
		this.writer = writer;
	}
	
	@Override
	public void write() {
		System.out.println("before write");
		writer.write();
		System.out.println("after write");
		
	}

}
