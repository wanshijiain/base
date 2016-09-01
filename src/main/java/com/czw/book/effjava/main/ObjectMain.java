package com.czw.book.effjava.main;

import org.junit.Test;

import com.czw.book.effjava.cdobject.NutritionFacts;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月8日 上午10:48:48 
 * 
 */
public class ObjectMain {
	@Test
	public void nutritionFactsTest(){
		NutritionFacts cocalCola = new NutritionFacts.Builder(21, 5).calories(1).build();
	}
	
	
	
}
