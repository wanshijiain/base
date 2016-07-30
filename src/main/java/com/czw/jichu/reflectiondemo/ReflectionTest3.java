package com.czw.jichu.reflectiondemo;
/*自己些程序调用别人的main放法*/
import java.lang.reflect.*;
import java.util.Arrays;
public class ReflectionTest3 {

	//运行方法：run as --> run configuration --> arguement 在文本框输入要执行的类所在的路径
	
	public static void main(String[] args)throws Exception {
/*		// TODO Auto-generated method stub
//方法1：		TestArguement.main(new String[]{"abc" , "bcd"});
		
//		String startingClassName = args[0];
		String startingClassName = "reflectiondemo.TestArguement";
		
		//获取路径，调用该路径下的main方法
		Method mtd = Class.forName(startingClassName).getMethod("main", String[].class);
//		mtd.invoke(null, new Object[]{new String[]{"abc" , "bcd"}});
		//一种解决方案：java中会自动打开String数组来获取里面的两个参数。而定义只接收一个参数。所以将这个String数组再次进行打包
		mtd.invoke(null, (Object)new String[]{"abc" , "bcd"});
		//另一种解决方案：把这个String数组弄成一个对象
		System.out.println("------------");*/
		arrayReflect();
		

		
	}
	
	public static void arrayReflect(){
		//有具体赋值就不能定义数组大小
		int[] a1 = new int[]{1,2,3};
		int[] a2 = new int[4];
		int[][] a3 = {{1,2,3},{4,5,6}};
		String[] a4 = new String[]{"a","b","c"};
/*		System.out.println(a1.getClass() == a2.getClass());//同维数同数组类型，字节码相同
		System.out.println(a1.getClass().getName());
		System.out.println(a1.getClass().getSuperclass().getName());//父类都是Object
		System.out.println(a4.getClass().getSuperclass().getName());*/
		
		Object aobj1 = a1;
		Object aobj2 = a4;
		Object aobj6 = a3;
//		Object[] aobj3 = a1;	//XXXXXXXX错误
		Object[] aobj4 = a3;
		Object[] aobj5 = a4;
		//一位数组表示一个对象，多为数组表示一个数组对象。
		
//		System.out.println(Arrays.asList((Object)a1));
//		System.out.println(Arrays.asList(a4));
		
		//通过反射打印数组
//		Object obj = null;
		printObject(a1);
		
	}
	public static void printObject(Object obj){
		Class<?> cls = obj.getClass();
		if(cls.isArray()){
			int len = Array.getLength(obj);
			for(int i = 0;i<len;i++){
				System.out.println(Array.get(obj, i));
				// 如果给定的值是数组，则分别打印，否则全部打印
			}
		}
		else{
			System.out.println(obj);
		}
	}

}
class TestArguement{
	public static void main(String[] args) {
		for (String s : args) {
			System.out.println(s);
		}
	}
}
