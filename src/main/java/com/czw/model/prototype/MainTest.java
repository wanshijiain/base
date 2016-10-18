/**
 * 
 */
package com.czw.model.prototype;

import com.czw.util.ComUtils;

/**
 * 原型的创建依赖克隆方法
 * 
 * 优点：当创建对象实例比较复杂时，通过已有实例创建能提高效率
 * 
 * @author ZeviChen , 2016-10-18 16:19:39
 */
public class MainTest {

	public static void main(String[] args) {
		ConcretePrototype cp1 = new ConcretePrototype();
		ConcretePrototype cp2 = cp1.clone();
		ConcretePrototype cp3 = ComUtils.clone(cp1);
		
	}

}
