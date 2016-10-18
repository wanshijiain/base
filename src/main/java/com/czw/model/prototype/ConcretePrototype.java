/**
 * 
 */
package com.czw.model.prototype;

import java.io.Serializable;

/**
 * @author ZeviChen , 2016-10-18 16:27:23
 */
public class ConcretePrototype implements Cloneable,Serializable {
	private static final long serialVersionUID = -6990784606135303189L;

	public ConcretePrototype() {}
	
	@Override
	protected ConcretePrototype clone(){
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (ConcretePrototype) obj;
	}
	
}
