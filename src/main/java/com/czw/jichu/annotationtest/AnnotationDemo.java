package com.czw.jichu.annotationtest;
/**/
@InterAnnotation(annotationAttr=@MetaAnnotation("flx"), color = "red",value = "abc",arrayAttr={1,2})  
//为注解中的方法设置初始值,当只有一个值的时候 arrayAttr=1 即值为1 
public class AnnotationDemo {

	
	@SuppressWarnings("deprecation")		//eclipse不能取消过时提示，但是cmd是通过这种方法不会提示过时提示
	@InterAnnotation("xyz")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.runFinalizersOnExit(true);
		/*在命令行：java  -Xlint:deprecation AnnotationDemo 可以查看具体哪句语句过时*/
		
		if(AnnotationDemo.class.isAnnotationPresent(InterAnnotation.class)){
			InterAnnotation ia = (InterAnnotation)AnnotationDemo.class.getAnnotation(InterAnnotation.class);
			System.out.println(ia.color());//调用注解类的方法
			System.out.println(ia.value());
			System.out.println(ia.arrayAttr().length);
			System.out.println(ia.lamp().nextLamp().name());
			
//			System.out.println(ia.annotationAttr());//返回注解的方法的值
			/*上面这句话出现异常，还不知道出于什么原因而存在
			 * IllegalAccessError: tried to access class AnnotationTest.MetaAnnotation from class $Proxy4*/
		}
	}

	@Deprecated     //注解此方法过时
	public static void sayHello(){
		System.out.println("hi,此方法过时");
		
	}
	
	@Override		//重载父类方法
	public boolean equals(Object obj){
		return true;
	}
}
