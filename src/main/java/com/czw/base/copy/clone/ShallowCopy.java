package com.czw.base.copy.clone;

import com.czw.beans.Address;
import com.czw.beans.User;

/**
 * 浅拷贝和深拷贝
 * 
 * @author ZeviChen
 * @Date 2016-09-11 11:16:16
 */
public class ShallowCopy {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address("浙江","杭州");
		User user1 = new User("张三",address);
		System.out.println(user1.getAddress().getProvince());
		User user2 = (User)user1.clone();
		user2.getAddress().setCity("嘉兴");
		System.out.println("user1:"+user1.getAddress().getCity()+",user2:"+user2.getAddress().getCity());
		
	}

}
