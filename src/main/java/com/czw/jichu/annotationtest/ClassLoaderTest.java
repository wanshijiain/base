package com.czw.jichu.annotationtest;

import java.util.Date;

/*
 * BootStrap 加载器，由java虚拟机启动时存在的c++编写的二进制代码    ：jre/lib/rt.jar下面的类
 * ExtClassLoader  jre/lib/ext/*.jar下面的类
 * AppClassLoader   类加载器:classPath及jar包下面去加载类
 * */
public class ClassLoaderTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.out.println(
				ClassLoaderTest.class.getClassLoader().getClass().getName()
				);
		System.out.println(
				System.class.getClassLoader()
				);
		System.out.println("--------1");
		ClassLoader cl = ClassLoaderTest.class.getClassLoader();
		while(cl != null){
			System.out.println(cl.getClass().getName());
			cl = cl.getParent();
		}
		System.out.println(cl);
		
		System.out.println("-----------2");
		
//		System.out.println(new ClassLoaderAttachment().toString());
		
		Class<?> cls = new MyClassLoader("E:\\JAVA\\项目\\javaenhance\\classloaderlib").loadClass("ClassLoaderAttachment");
		Date da = (Date)cls.newInstance();
		System.out.println(da);
		
		
	}

}
