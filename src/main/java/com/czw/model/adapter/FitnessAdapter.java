package com.czw.model.adapter;

/**
 * @author ZeviChen
 * @Date 2016-08-11 15:51:29
 */
public abstract class FitnessAdapter implements Fitness {

	@Override
	public void treadmill() {
	}

	@Override
	public void walk() {
	}

	/**
	 * 接口适配器，有时一个接口定义了好多的方法,然是implements是并不需要
	 * 实现所有的方法
	 */
	
	
}
