package com.czw.base.copy.defensive;

import java.util.Date;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月15日 上午11:27:20 
 * 
 */
public class DefensiveCopy1 {
	private final Date start;
	private final Date end;
	
	public DefensiveCopy1(Date start,Date end){
		if(start.compareTo(end)>0){
			throw new IllegalArgumentException(start + " after "+ end);
		}
		this.start = start;
		this.end = end;
	}
	
	public Date start(){
		return start;
	}
	public Date end(){
		return end;
	}
}
