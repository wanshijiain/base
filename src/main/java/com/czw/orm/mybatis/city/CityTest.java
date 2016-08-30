package com.czw.orm.mybatis.city;

import java.io.IOException;

import org.junit.Test;

import com.czw.orm.mybatis.domain.City;
import com.czw.util.MybatisUtils;

/**
 * @author ZeviChen
 * @Date 2016-08-30 14:28:52
 */
public class CityTest {
	
	@Test
	public void getUser() throws IOException{
        String statement = "mybatis.City.getUser";
        City city = MybatisUtils.getSession().selectOne(statement, 1308);
        System.out.println(city);
        //City [id=1308, code=1308, name=承德市, isCapital=0, provinceName=河北省]
	}
	
	
}
