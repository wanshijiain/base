/**
 * 
 */
package com.czw.model.factory.absfactory;

/**
 * 产品族：一组相关产品的工厂
 * 产品等级：产品的等级结构
 * 
 * 皮肤工厂抽象画，来创建不同的产品族工厂
 * 
 * 优点：增加新的产品族很方便,符合开闭原则,隔离类的生成,保证客户端同一时间只使用一个产品族中的对象
 * 缺点：增加新的产品等级很难，不符合开闭原则
 * 
 * 场景：系统依赖中有多个产品族，同一时间只使用一个产品族中的对象。多系统，多皮肤	
 * 
 * @author ZeviChen , 2016-10-18 15:07:20
 */
public class MainTest {

	public static void main(String[] args) {
		SkinFactory sf = new SpringSkinFactory();
		Button b = sf.createButton();
		TextField tf = sf.createTextField();
		ComboBox cb = sf.createComboBox();
		b.display();
		tf.display();
		cb.display();
	}

}
