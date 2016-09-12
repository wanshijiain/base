/**
 * 
 */
package com.czw.toolkit.guava.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * 提供JDK所没有的集合及功能，集合不接受null值，如果需要null值使用下面的方式
 * 
 * JDK中也提供了把集合变成不可变集合的工具方法：Collections.unmodifiableXXX,
 * 不过通过原始集合改变数据也会影响到这个不可变集合
 * 
 * BiMap			1v1的集合,根据key找到value,根据value也能找到key
 * Multiset			可重复
 * Multimap			一个key可能含有多个entries
 * ListMultimap		Multimap的扩展
 * SetMultimap		Multimap的扩展，不允许多个entries
 * SortedSetMultimap		一个key对应值是SortedSet
 * ClassToInstanceMap		关联对象的原始类型
 * 
 * @author ZeviChen
 * @date 2016-09-11 22:11:18
 */
public class TestCollections {
		
	/**
	 * 不可变集合,保护集合内部对象不被外部修改
	 */
	@Test
	public void immutableSetTest(){
		
	}
	
	/**
	 * HashMultiset可以存储重复值
	 * 这个集合存储了这些值，并且还可以统计
	 * @see http://www.cnblogs.com/peida/p/Guava_Multiset.html
	 */
	@Test
	public void multiSetTest(){
		String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
     
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }
        System.out.println();
	}
	
	@Test
	public void hashMapTest(){
		String strWorld="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        String[] words=strWorld.split("\\|");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) { 
                countMap.put(word, 1); 
            }
            else { 
                countMap.put(word, count + 1); 
            }
        }        
        System.out.println("countMap：");
        for(String key:countMap.keySet()){
            System.out.println(key+" count："+countMap.get(key));
        }
	}
	
	
	
	
}
