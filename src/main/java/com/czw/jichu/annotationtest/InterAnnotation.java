package com.czw.jichu.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.czw.jichu.reflectiondemo.EnumTest;
/*
 * Ԫע��
 * Ԫ��Ϣ
 * Ԫ����
 * 
 * ע����������������ڣ�javaԴ����-->class�ļ�-->�ڴ��е��ֽ���
 * 							  javac����       �������������ڴ�
 * RetentionPolicy.SOURCE RetentionPolicy.class RetentionPolicy.RUNTIME
 * Ĭ�Ͻ׶Σ�class
 * 
 */
@Retention(RetentionPolicy.RUNTIME)				//��ʹ�����ĸ���������
@Target({ElementType.METHOD,ElementType.TYPE}) //ʹ��ע����Ա���������߷�����
public @interface InterAnnotation {

		String color() default "blue";//�����color����,����Ĭ��ֵ 
		String value();
		int[] arrayAttr() default {3,4};
		EnumTest.TrafficLamp lamp() default EnumTest.TrafficLamp.RED;
		MetaAnnotation annotationAttr() default @MetaAnnotation("zxx");//����һ��ע��ķ���
}

@interface MetaAnnotation{
	String value();
}
