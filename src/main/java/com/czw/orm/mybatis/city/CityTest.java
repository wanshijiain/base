package com.czw.orm.mybatis.city;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	private SqlSession session = MybatisUtils.getSession();
	
	@Test
	@Ignore
	public void getUser() throws IOException{
		String statement = "mybatis.City.getCity";
        City city = session.selectOne(statement, 1308);
        System.out.println(city);
        //City [id=1308, code=1308, name=承德市, isCapital=0, provinceName=河北省]
	}
	
	@Test
	@Ignore
	public void getUser2(){
		String statement = "mybatis.City.getCity2";
		HashMap<String,Object> city = session.selectOne(statement,1308);
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
	
	/**
	 * 多行插入,必须要数据库支持《mysql支持，oracle不支持》
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
//	@Ignore
	public void mutiInsert() throws JsonParseException, JsonMappingException, IOException{
		List<City> cityList = new ArrayList<City>();
		ObjectMapper om = new ObjectMapper();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d://tmp/city.dat")),"UTF-8"));
		String s = null;
		while((s = br.readLine())!=null){
			City city = om.readValue(s, City.class);
			cityList.add(city);
		}
		session.insert("mybatis.City.mutiInsert",cityList);
		
		session.commit();
		br.close();
		session.close();
	}
	
	
}
