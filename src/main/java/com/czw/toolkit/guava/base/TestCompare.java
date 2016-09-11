/**
 * 
 */
package com.czw.toolkit.guava.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.czw.beans.User;
import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * @author ZeviChen
 * @date 2016-09-11 21:32:32
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class TestCompare {

	@Test
	public void compareTest() {
		List<String> strData = new ArrayList<>();
		strData.add("dddd");
		strData.add("b");
		strData.add("ccccccc");
		strData.add("aaa");
		
		Ordering naturalOrder = new Ordering(){
			public int compare(Object left, Object right) {
				return Ints.compare(((String)left).length(), ((String)right).length());
			};
		};
		System.out.println("按照字符串长度排序降序："+naturalOrder.sortedCopy(strData));
		System.out.println("按照字符串长度排序升序："+naturalOrder.reverse().sortedCopy(strData));
		System.out.println("字符串长度最短："+naturalOrder.min(strData));
		System.out.println("字符串长度最长："+naturalOrder.max(strData));
		
		Ordering<User> objOrder = Ordering.natural().nullsFirst().onResultOf(new Function<User,String>(){
			public String apply(User user){
				return user.getName();
			}
		});
		Ordering userOrder = Ordering.from(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return Ints.compare(o1.getName().length(), o2.getName().length());
			}
		});
		
	}

}
