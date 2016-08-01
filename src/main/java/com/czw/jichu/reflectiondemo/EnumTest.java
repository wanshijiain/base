package com.czw.jichu.reflectiondemo;

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WeekDay wd=WeekDay.FRI;
		System.out.println("WeekDay.FRI:\t\t\t"+wd);//字符串返回
		System.out.println("WeekDay.FRI.name():\t\t"+wd.name());//字符串返回
		System.out.println("WeekDay.FRI.ordinal():\t\t"+wd.ordinal());//下标
		
		//静态方法
		System.out.println("WeekDay.valueOf('SUN'):\t\t"+WeekDay.valueOf("SUN"));
		//把串变成对映的枚举对象
		System.out.println("WeekDay.values().length:\t"+WeekDay.values().length);//下标
//		WeekDay.values()   数组返回枚举中的元素

		TrafficLamp tl=TrafficLamp.RED.nextLamp();
		System.out.println("TrafficLamp.RED.nextLamp():\t"+tl);
		
		
	}
	

//枚举可以作为单独的类或者内部类
//当只有一个实例的时候，可以使用单例
	public enum WeekDay{
		//在元素的后面带括号来指定应该使用的构造方法
		SUN(1),MON(),TUE,WED,THI,FRI,SAT;
		private WeekDay(int num)
		{		
//			System.out.println("Second");
		}
		private WeekDay()
		{		
//			System.out.println("First");
		}
	}
	
	//定义抽象方法，为枚举类中的实例对象定义各自的方法
	public enum TrafficLamp{
		RED{
				public TrafficLamp nextLamp(){
					return GREEN;
				}
		},
		GREEN{
				public TrafficLamp nextLamp(){
					return YELLOW;
				}
		},
		YELLOW{
				public TrafficLamp nextLamp(){
					return RED;
				}
		};
		public abstract TrafficLamp nextLamp();
	}
}
