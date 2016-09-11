/**
 * 
 */
package com.czw.toolkit.guava.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * @author ZeviChen
 * @date 2016-09-11 20:40:03
 */
public class TestObjects {

	@Test
	public void equalTest() {
		System.out.println(Objects.equal(null, "aa"));

		// JDK7 java.util提供了相同的方法,并且還有数组的比较方法
		boolean bolType = java.util.Objects.equals(1, null);
		boolean bolList = java.util.Objects.deepEquals(new LinkedList<String>(), new ArrayList<String>());

		List<String> al = new LinkedList<>();
		al.add("aa");
		al.add("bb");
		List<String> bl = new ArrayList<>();
		al.add("bb");
		al.add("cc");

		boolean lrst = java.util.Objects.deepEquals(al, bl);
		System.out.println("类型比较：" + bolType);
		System.out.println("不同空集合比较：" + bolList);
		System.out.println("非空不同集合有相同值比较：" + lrst);

		// toString方法的编写帮助工具,其实toString()方法的字符串拼接用eclipse工具生成就好了
		// 没必要自己手动去写
		// Objects.toStringHelper(this).add("name", "zhangsan").add("age",
		// 20).toString(); 方法标记为过时
		System.out.println(MoreObjects.toStringHelper(this).add("name", "zhangsan").toString());

	}

	public boolean eq(Object a, Object b) {
		// 很好的equal方式
		return a == b || (a != null && a.equals(b));
	}

}
