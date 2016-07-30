package com.czw.jichu.annotationtest;
/*
 * 泛型只在javac编译是生效，当使用反射来调用这个集合的方法是。此时不再受定义是的泛型的影响
 * */
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args)throws Exception {
		Constructor<String> constructor1 = String.class.getConstructor(String.class);
		String str2 = constructor1.newInstance("ffff");
		System.out.println(str2.charAt(2));
		
		       
		
		ArrayList<Integer> collection3 = new ArrayList<Integer>();
		collection3.getClass().getMethod("add", Object.class).invoke(collection3, "abc");
		System.out.println(collection3.get(0));
		
		
	}

}
