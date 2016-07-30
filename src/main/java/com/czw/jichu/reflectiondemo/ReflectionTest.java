package com.czw.jichu.reflectiondemo;
/*
 * Class.forName(string path)   返回加载的字节码
 * 两种加载方式：
 * 1.字节码已经被加载过，在jvm中
 * 2.把字节码加载在jvm中缓存，然后返回
 * 
 * 得到字节码
 * 1.new Person().getClass();
 * 2.Person.class
 * 3.Class.forName("E:\JAVA\项目\javaenhance\src\javaenhance\Person");
 * 
 * 反射：
 * 	通过反射可以知道一个类中的状态信息(变量，方法及返回值等)而不需要通过它的对象
 * 	可以动态多去类中的信息
 * 	
 * 	实际应用是：可以修改配置文件
 * 
 * Class		所有的java类都属于这个Class类
 * 
 * Field		Class类中的属性信息可以返回给这个Field类来处理
 * 		getField()  返回public 变量
 * 		getDeclaredFields()	返回所有变量
 * 			setAccessible(true) field.get(obj)  //获取非public修饰的变量并进行修改的方式
 * 		getType()  变量类型( 字节码用 == 来判断 )
 * 
 * Constructor	Class类来获得java类的构造方法，可以通过这个来赋值并新建该类的对象
 * 		getConstructor(Class... cls)
 * 		newInstance(Object... obj)
 * 
 * Method		Class类中的方法都可以返回给这个Method类来处理
 * 		getMethod("方法名" , 参数.class)
 * 		getDeclaredMethods()
 * 		method.invoke(cls , 方法参数)
 * 
 * 配置文件一般都放在整个工程之下
 * 通过获取类加载器来获取配置文件
 * 
 * Class.getClassLoader().getResourceAsStream("XX.properties")
 * 
 * */
import java.lang.reflect.*;
public class ReflectionTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
/*Field*/
		/*
		Person p=new Person();
		Class cls = Class.forName("E:\\JAVA\\项目\\javaenhance\\src\\reflectiondemo\\Person");
		Class<?> cls = p.getClass();
		
		Method[] mtd = cls.getDeclaredMethods();
		for(Method me:mtd)
		{
			System.out.println(me.toString());
		}
		
		Field[] fds = cls.getDeclaredFields();
		for(Field fi:fds)
		{
			System.out.println(fi.toString());
		}
		*/
		
		
		//获取成员变量的值
		//getField  获取类中public修饰的变量
		//getDeclaredFields   获取类中已经被定义的所有变量
		Person p1=new Person("zhangsan",22,"anhui");
		Field fieldAddr=p1.getClass().getField("addr");
		System.out.println("fieldAddr.get(p1):"+fieldAddr.get(p1));
		
		//暴力反射
		Field fieldName=p1.getClass().getDeclaredField("name");
		fieldName.setAccessible(true);
		System.out.println(fieldName.get(p1));
		
	

		changeStringValue(p1);
		System.out.println(p1.toString());
		
	
/*Method*/
		String str1 = "abc";
		//String.charAt(1);
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		//字节码.getMethod("方法名",参数);   返回类型  Method
		
		System.out.println(methodCharAt.invoke(str1, 1));
		
		//1.4没有可变数组，所以通过传入数组的形式类赋予参数值
		System.out.println(methodCharAt.invoke(str1,new Object[]{1}));
		
	}
	
	//通过反射来设置类变量的值
	public static void changeStringValue(Object obj)throws IllegalAccessException {
		Field[] field=obj.getClass().getFields();
		for(Field f:field){
			
			//遍历Field判断是否为String
			if(f.getType() == String.class){
				
				//然后通过字符串的方法来修改一些默认信息
				String oldValue = (String)f.get(obj);
				String newValue = oldValue.replace('b', 'a');
				//Field方法来设置改变的属性
				f.set(obj, newValue);
//				System.out.println(newValue);
			}
		}
	}

}
class Person {
	private String name;//当类型被私有或者默认修饰是，通过反射机制无法访问该变量
	int age;
	public String addr;
	
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
	public String str1="ab";
	public String str2="bc";
	public String str3="ac";
	
	
	Person(){}
	Person(String name, int age, String addr) {
//		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getAdd(){
		return addr;
	}
	
	@Override
	public String toString(){
		return str1 + ":" + str2 + ":" + str3;
	}
}
