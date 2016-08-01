package com.czw.jichu.reflectiondemo;

public class ReflectionTest2 {

    public static void main(String[] args) {  
       TestOne  one=null;  
       try{  
	       Class<?>  cla=Class.forName("reflectiondemo.TestOne");//进行javaenhance.TestOne类加载，返回一个Class对象  
	       //首先加载静态代码块
	       
	       System.out.println("********");  
	       one=(TestOne)cla.newInstance();//产生这个Class类对象的一个实例，调用该类无参的构造方法，作用等同于new TestOne()  
       }catch(Exception e){  
           e.printStackTrace();  
       }  
       TestOne two=new TestOne();  
       System.out.println(one.getClass() == two.getClass());
       //比较两个TestOne对象的Class对象是否是同一个对象，在这里结果是true。说明如果两个对象的类型相同，那么它们会有相同的Class对象  
    }  
}  
	   


class TestOne{  
	static{  
		System.out.println("静态代码块运行");  
	}  
	TestOne(){  
		System.out.println("构造方法");  
	}  
}