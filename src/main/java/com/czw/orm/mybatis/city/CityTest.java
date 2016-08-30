package com.czw.orm.mybatis.city;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;

import com.czw.orm.mybatis.domain.City;
import com.czw.util.MybatisUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ZeviChen
 * @Date 2016-08-30 14:28:52
 */
public class CityTest {
	
	@Test
//	@Ignore
	public void getUser() throws IOException{
		String statement = "mybatis.City.getUser";
        City city = MybatisUtils.getSession().selectOne(statement, 1308);
        System.out.println(city);
        //City [id=1308, code=1308, name=承德市, isCapital=0, provinceName=河北省]
	}
	
	@Test
	@Ignore
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
	
	@Test
	@Ignore
	public void insert() throws JsonParseException, JsonMappingException, IOException{
		SqlSession session = MybatisUtils.getSession();
		ObjectMapper om = new ObjectMapper();

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d://tmp/city.dat")),"UTF-8"));
		String s = null;
		while((s = br.readLine())!=null){
			System.out.println(s);
			City city = om.readValue(s, City.class);
			session.insert("mybatis.City.insert2", city);
		}
		session.commit();
		br.close();
		session.close();
	}
	
	
}
