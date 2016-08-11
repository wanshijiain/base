package com.czw.model.adapter;

/**
 * @author ZeviChen
 * @Date 2016-08-11 15:40:57
 */
public class ObjectAdapter implements Fitness{
	
	private Sport sport;
	
	public ObjectAdapter(){}
	
	public ObjectAdapter(Sport sport) {
		super();
		this.sport = sport;
	}
	
	@Override
	public void treadmill() {
		System.out.println("ObjectAdpater-Fitness-treadmill");
	}

	@Override
	public void walk() {
		sport.walk();
	}
	
	
}
