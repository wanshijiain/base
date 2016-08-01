package com.czw.jichu.reflectiondemo;

import java.lang.reflect.Constructor;

/*
 * 通过反射机制来创建对象
 * 1.无参Class cls    cls.newInstance()
 * 2.通过构造器Constructor
 * 
 * Constructor用于获取构造方法
 * Constructor[] con=cls.getConstructors();
 * 
 * */
public class ConstructorTest {  
   
    public static void main(String[] args) {  
       try {  
			//获得指定字符串类对象  
			Class<?> cla=Class.forName("reflectiondemo.Tests");  
			//设置Class对象数组，用于指定构造方法类型  
			Class<?>[] cl=new Class[]{String.class,int.class};  
			   
			//获得Constructor构造器对象。并指定构造方法类型  
			Constructor<?> con=cla.getConstructor(cl);  
			   
			//给传入参数赋初值  
			    
			Object[] x={"jinnian",new Integer(2013)};  
			//得到实例  
			Object obj=con.newInstance(x);  //两种传递参数的方式
			//Object obj=con.newInstance("jintian",new Integer(2103));  
			obj.toString();
    } catch (Exception e) {  
        e.printStackTrace();  
    } finally {
      }  
    }  
   
}  
   
class Tests{  
	int x;
    public Tests(String s,int y){  
       System.out.println(s+"    "+y);  
    }  

	
    
}