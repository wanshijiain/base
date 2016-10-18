package com.czw.model.builder;

/**
 * 
 * @author ZeviChen , 2016/10/18 23:39
 */
public class MainTest {

	public static void main(String[] args) {
		FactoryBuilder fb = FactoryBuilder.builder("张三").age(10).msg("some msgs").create();
		
		fb.getAddress();
		fb.getAge();
		fb.getMsg();

		System.out.println("-------------------------------------");

		ActorBuilder ab =  new HeroBuilder();
		ActorController ac = new  ActorController();
		Actor actor = ac.construct(ab); //通过指挥者创建完整的建造者对象

		String  type = actor.getType();
		System.out.println(type  + "的外观：");
		System.out.println("面容：" + actor.getFace());
		System.out.println("发型：" + actor.getHairstyle());
		
	}

}
