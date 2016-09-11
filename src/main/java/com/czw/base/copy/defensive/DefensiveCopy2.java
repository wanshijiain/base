package com.czw.base.copy.defensive;

import java.util.Date;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月15日 上午11:27:20 
 * 
 */
public class DefensiveCopy2 {
	private final Date start;
	private final Date end;
	
	public DefensiveCopy2(Date start,Date end){
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		if(start.compareTo(end)>0){
			throw new IllegalArgumentException(start + " after "+ end);
		}
		
	}
	
	public Date start(){
		return start;
	}
	public Date end(){
		return end;
	}
}
