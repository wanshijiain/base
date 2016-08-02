package com.czw.base.enu;

/**
 * @author Zevi Chan
 * @Date 2016-08-02 12:08:00
 */
public enum EnumFunc {
	ONE(1){
		public String getName(){
			return "one";
		}
	},
	TWO(2){
		public String getName(){
			return "two";
		}
	};
	
	private int id;
	private EnumFunc(int id){
		this.id = id;
	}
	
	public abstract String getName();

	public int getId() {
		return id;
	}
}
