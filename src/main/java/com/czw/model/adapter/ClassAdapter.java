package com.czw.model.adapter;

/**
 * @author ZeviChen
 * @Date 2016-08-11 15:27:26
 */
public class ClassAdapter extends Sport implements Fitness {

	@Override
	public void treadmill() {
		System.out.println("ClassAdapter-Fitness-treadmill");
	}

}
