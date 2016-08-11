package com.czw.model.decorate;

/**
 * @author ZeviChen
 * @Date 2016-08-11 16:38:57
 */
public class Writer implements Writeable {

	/* (non-Javadoc)
	 * @see com.czw.model.decorate.Writeable#write()
	 */
	@Override
	public void write() {
		System.out.println("need to decorate this");
	}

}
