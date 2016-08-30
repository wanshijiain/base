package com.czw.orm.mybatis.city;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;

import com.czw.orm.mybatis.domain.City;
import com.czw.util.MybatisUtils;

/**
 * @author ZeviChen
 * @Date 2016-08-30 14:28:52
 */
public class CityTest {
	
	@Test
	@Ignore
	public void getUser() throws IOException{
		String statement = "mybatis.City.getUser";
        City city = MybatisUtils.getSession().selectOne(statement, 1308);
        System.out.println(city);
        //City [id=1308, code=1308, name=承德市, isCapital=0, provinceName=河北省]
	}
	
	@Test
	public void getUser2(){
		String statement = "mybatis.City.getUser2";
		HashMap<String,Object> city = MybatisUtils.getSession().selectOne(statement,1308);
		for(String key:city.keySet())
			System.out.println(key+":"+city.get(key));
		
		/*
			isCapital:0
			code:1308
			name:承德市
			id:1308
			provinceName:河北省
			roundMode:5
		 */
	}
	
	
}
