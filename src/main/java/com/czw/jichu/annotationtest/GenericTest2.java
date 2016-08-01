package com.czw.jichu.annotationtest;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

public class GenericTest2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Method applyMethod = GenericTest2.class.getMethod("applyVector", Vector.class);
		Type[] types = applyMethod.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType)types[0];
		System.out.println(pType.getRawType());
		System.out.println(pType.getActualTypeArguments()[0]);
		
	}
	public static void applyVector(Vector<Date> v){
		
	}

}
