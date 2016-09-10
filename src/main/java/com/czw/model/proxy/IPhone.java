package com.czw.model.proxy;

/**
 * 序列化对象何以将对象状态保存在硬盘上
 * @author ZeviChen
 * @Date 2016-09-10 15:59:09
 */
public class IPhone implements Mobile {

	private static final long serialVersionUID = 4016631336913527175L;
	private String name = "";
	public IPhone(){}
	public IPhone(String name){
		this.name = name;
	}
	
	@Override
	public void charge() {
		System.out.println(name + " IPhone 充电中...");
	}

	@Override
	public void answer() {
		System.out.println(name +"　IPhone 接电话...");
	}


}
