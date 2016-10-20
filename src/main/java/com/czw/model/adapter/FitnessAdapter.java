package com.czw.model.adapter;

/**
 * 缺省适配器的作用用于:当适配器不需要实现所有的方法,通过抽象类实现默认方法
 * 由子类覆盖默认方法
 *
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
