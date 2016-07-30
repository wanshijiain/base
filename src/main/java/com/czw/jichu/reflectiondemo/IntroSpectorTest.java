package com.czw.jichu.reflectiondemo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*通过内省的方式来获取某个类中的值,来自于java.beans 特殊的java类
 * 通过该类具有反射特性的方式setXX getXX 利用beans中的方法来获取和
 * 设置某个具有beans特性的类的值。
 * 
 * */
public class IntroSpectorTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ReflectPoint rp = new ReflectPoint(2,3);
		//通过PropertiesDescriptor来产生相对应的方法来获取该类中的值
		
		String propertyAge = "AGE";//通过setXXX或getXXX中的XXX来获得和设置对应属性
		PropertyDescriptor pd = getProperty(rp, propertyAge);
		//refactor-->Extract Method 重构抽取方法快速构建代码，简化书写过程
		
		setProperty(rp, pd);
		System.out.println("age:"+rp.getAGE());
		System.out.println("num:"+rp.getNum());
	}

	
	private static void setProperty(Object rp, PropertyDescriptor pd)
			throws IllegalAccessException, InvocationTargetException {
//		System.out.println(pd);
		Method methodSetAge = pd.getWriteMethod();
		methodSetAge.invoke(rp , 9);
	}

	private static PropertyDescriptor getProperty(Object rp,
			String propertyAge) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor(propertyAge , rp.getClass());
		Method methodGetAge = pd.getReadMethod();
		Object retVal = methodGetAge.invoke(rp);
		System.out.println(retVal);
	//通过PropertyDescriptor属性描述的方法，获取和设置值
		

		
		/*上面的方式相比下面的方式比较简单，下面的代码可以扩展知识面*/
		//Introspector操作JavaBean类型的标准方法
/*		BeanInfo bi = Introspector.getBeanInfo(rp.getClass());
		PropertyDescriptor[] pds = bi.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			if(pd.getName().equals(propertyAge)){
				Method methodGetAge = pd.getReadMethod();
				Object retVal = methodGetAge.invoke(rp);
				System.out.println(retVal);
				return pd;
				
			}
		}
		*/
		return pd;
		
		
	}

}
class ReflectPoint{
	private int x;
	public ReflectPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int y;
	public int getAGE() {
		return x;
	}
	public void setAGE(int x) {
		this.x = x;
	}
	public int getNum() {
		return y;
	}
	public void setNum(int y) {
		this.y = y;
	}
	
}
