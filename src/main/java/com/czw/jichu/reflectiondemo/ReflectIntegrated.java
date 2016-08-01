package com.czw.jichu.reflectiondemo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class ReflectIntegrated {
	// 框架：用户通过改变某些参数来使用这个框架达到自己的目的
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		InputStream is = 
				new FileInputStream("E:\\JAVA\\项目\\javaenhance\\src\\reflectiondemo\\config.properties");
		//文件中的数据是：className = java.util.ArrayList
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		String className = prop.getProperty("className");
		//System.out.println(className);
		Collection collections = (Collection)Class.forName(className).newInstance();
		//通过这种调用配置文档中信息来执行新建任务的方式就是反射
		
		
		
		
	}

}
