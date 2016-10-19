package com.czw.model.builder;

/**
 * 构造器来构建角色,控制器来创建构造器,或者在构造器中直接创建
 * 优点:隐藏流程细节
 * 缺点:产品共同点多,不适合有很多构造器的环境
 * 场景:初始化各种角色信息,应用软件的不同模式的构建
 *
 * @author ZeviChen , 2016/10/18 23:39
 */
public class MainTest {

	public static void main(String[] args) {
		FactoryBuilder fb = FactoryBuilder.builder("张三").age(10).msg("some msgs").create();
		
		fb.getAddress();
		fb.getAge();
		fb.getMsg();

		System.out.println("----------------控制器传入builder---------------------");

		ActorBuilder ab =  new HeroBuilder();
		ActorController ac = new  ActorController();
		Actor actor = ac.construct(ab); //通过指挥者创建完整的建造者对象

		System.out.println(actor.getType()  + "的外观：");
		System.out.println("面容：" + actor.getFace());
		System.out.println("发型：" + actor.getHairstyle());

		System.out.println("-----------------在builder中直接构造--------------------");
		ActorBuilder1 ab1 = new HeroBuilder1();
		Actor actor1 = ab1.construct();
		System.out.println(actor1.getType()  + "的外观：");
		System.out.println("面容：" + actor1.getFace());
		System.out.println("发型：" + actor1.getHairstyle());

	}

}
