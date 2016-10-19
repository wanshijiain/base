package com.czw.model.adapter;

/**
 * 
 * 1.类适配器：
 * 	继承类，实现B接口,实现适配
 * 
 * 2.对象适配器
 * 	将A类放入new的适配器中
 * 
 * 3.接口适配器
 *  接口方法很多,不需要全部实现，定义抽象类来实现.子类来实现抽象类中的部分方法
 * 
 * @author ZeviChen
 * @Date 2016-08-11 15:37:31
 */
public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("==================ClassAdapter===================");
		Fitness clsfitness = new ClassAdapter();
		clsfitness.walk();
		clsfitness.treadmill();
		
		System.out.println("==================ObjectAdapter===================");
		Sport sport = new Sport();
		Fitness objFitness = new ObjectAdapter(sport);
		objFitness.walk();
		objFitness.treadmill();
		
		System.out.println("==================FitnessAdapter===================");
		FitnessAdapterOne io = new FitnessAdapterOne();
		FitnessAdapterTwo it = new FitnessAdapterTwo();
		
		io.treadmill();
		io.walk();
		it.treadmill();
		it.walk();
		
	}

}
