package com.czw.base.copy.defensive;

import java.util.Date;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月15日 上午11:27:20 
 *  
 */
public class DefensiveCopy3 {
	private final Date start;
	private final Date end;
	
	public DefensiveCopy3(Date start,Date end){
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		if(start.compareTo(end)>0){
			throw new IllegalArgumentException(start + " after "+ end);
		}
		
	}
	
	//返回的只是一个新对象，而不是当前对象中的对象属性引用，所以外部获得的引用的修改不会修改该对象中属性对象的值
	//起到了保护对象内部值得功能
	public Date start(){
		return new Date(start.getTime());
	}
	public Date end(){
		return new Date(end.getTime());
	}
}
