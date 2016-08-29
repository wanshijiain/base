/**
 * 
 */
package com.czw.web.main.dao.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.czw.util.DateUtils;
import com.czw.web.main.dao.UserDao;

/**
 * @author ZeviChen
 * @date 2016-08-08 21:48:15
 */
@Repository
public class UserDaoImpl implements UserDao {
	

	@Override
	public Integer getById(String id) {
		Integer rdm = new Random().nextInt();
		System.out.println("查看缓存是否执行["+id+"]："+rdm+",time="+DateUtils.dts(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return rdm;
	}
	

}
