package com.czw.book.effjava.cdobject;

/** 
 * 
 * @author Zevi Chan
 * @Date 2016-07-22 10:13:50
 * 
 */
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private int fat;				//final修饰的引用类型，里面的地址不可变,如果是基本类型就是里面的值不可变,当引用的类里面的值是不受限制的
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder{
		private final int servingsSize;
		private final int servings;
		
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;
		
		public Builder(int servingSize,int servings){
			this.servingsSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val){
			calories = val; return this;
		}
		public Builder carbohydrate(int val){
			carbohydrate = val; return this;
		}
		public Builder sodium(int val){
			sodium = val; return this;
		}
		
		public NutritionFacts build(){
			return new NutritionFacts(this);
		}
		
	}
	
	private NutritionFacts(Builder builder){
		servingSize = builder.servingsSize;
		servings = builder.servings;
		calories = builder.calories;
		sodium = builder.sodium;
		fat = builder.fat;
		carbohydrate = builder.carbohydrate;
	}
	

}


