package com.czw.base.enu;

import java.util.Collection;
import java.util.EnumSet;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.czw.base.enu.EnumBitField.Style;

/** 
 * 
 * @author Zevi Chan
 * @date 2016年6月13日 下午5:38:24 
 * 
 */
public class MainTest {
	public static Logger log = LoggerFactory.getLogger(MainTest.class);
	
	/**
	 * 枚举类测试
	 */
	@Test
	@Ignore
	public void enumTest(){
		log.info("enumTest: signum is {},name is {}",EnumTest.FRI.getSignum(),EnumTest.FRI.getName());
		log.info("enumTest: enum返回的同一个实例是否相同：{}",EnumTest.MON == EnumTest.FRI);
		
	}
	
	/**
	 * 枚举方法
	 */
	@Test
	@Ignore
	public void enumOperation(){
		double x = 2.0,
				y = 1.0;
		EnumOperation apply = EnumOperation.DIVIDE;
		EnumOperation op = EnumOperation.inverse(apply);
		log.info("enumOperation1: {} {} {} = {}",x,apply,y,op.apply(x, y));
		
		test(EnumOperation.class,x,y);
	}
	
	public static <T extends Enum<T> & Operation> void test(Class<T> opSet ,double x,double y){
		for(Operation op : opSet.getEnumConstants()){
			log.info("enumOperation2: {} {} {} = {}",x,op,y,op.apply(x, y));
		}
	}
	public static void test1(Collection<? extends Operation> opSet ,double x,double y){
		for(Operation op : opSet){
			log.info("enumOperation2: {} {} {} = {}",x,op,y,op.apply(x, y));
		}
	}
	
	
	
	/**
	 * ordinal()方法返回每个枚举没有定义类型的默认int值
	 * 枚举进行重新排序，id就会改变
	 * 大多用于EnumSet和EnumMap，一般定义枚举都会赋值参数，不通过这种方式获取
	 */
	@Test
	@Ignore
	public void enumOrdinal(){
		log.info("ONE number is {}",EnumOrdinal.ONE.numberOfEnum());
		log.info("TWO number is {}",EnumOrdinal.TWO.numberOfEnum());
		log.info("THREE number is {}",EnumOrdinal.THREE.numberOfEnum());
		log.info("FOUR number is {}",EnumOrdinal.FOUR.numberOfEnum());
		log.info("FIVE number is {}",EnumOrdinal.FIVE.numberOfEnum());
		log.info(""+(2|4));
	}
	
	@Test
	@Ignore
	public void enumOrdinal1(){
		log.info("ONE number ordinal is {},\treal number is {}",EnumOrdinal1.ONE.numberOfEnum(),EnumOrdinal1.ONE.getNum());
		log.info("TWO number is {},\treal number is {}",EnumOrdinal1.TWO.numberOfEnum(),EnumOrdinal1.TWO.getNum());
		log.info("THREE number is {},\treal number is {}",EnumOrdinal1.THREE.numberOfEnum(),EnumOrdinal1.THREE.getNum());
		log.info("FOUR number is {},\treal number is {}",EnumOrdinal1.FOUR.numberOfEnum(),EnumOrdinal1.FOUR.getNum());
		log.info("FIVE number is {},\treal number is {}",EnumOrdinal1.FIVE.numberOfEnum(),EnumOrdinal1.FIVE.getNum());
	}
	
	/**
	 *  位域计算(常量联合,交集.翻译同样也困难的多)
	 *  使用枚举集合就要方便的多,并且没有常量枚举的问题
	 *  
	 *  创建不可变的EnumSet可以使用Collections.unmodifiableSet(EnumSet)
	 *  	但性能和简洁会影响
	 *  
	 */
	@Test
	@Ignore
	public void enumBitField(){
		//常量枚举
		Text text = new Text();
		text.applyStyles(Text.STYLE_BOLD|Text.STYLE_ITALIC);
		
		//枚举集合
		EnumBitField enumBitField = new EnumBitField();
		enumBitField.applyStyles(EnumSet.of(Style.BOLD,Style.ITALIC));
		
	}

	/**
	 * 枚举定义抽象方法
	 */
	@Test
	public void enumFuncTest(){
		log.info("enumFuncTest.ONE.getName = {}",EnumFunc.ONE.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
