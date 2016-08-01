package com.czw.jichu.genetictest;
/*
Map���ϣ��ü��ϴ洢��ֵ�ԡ�һ��һ������档����Ҫ��֤����Ψһ��
	1.��ӡ�
		put(K key,V value)
		putAll(Map<? extends K,? extends V> m)
	2.ɾ����
		clear()
	3.�жϡ�
		containsValue(Object value)
		containsKey(Object key)
		isEmpty()

	4.��ȡ��
		get(Object key)
		size()
		values()

		entrySet()
		keySet()

Map����С��
	|--Hashtable���ײ��ǹ�ϣ�����ݽṹ�������Դ���Null��Nullֵ���ü�����ͬ���ġ�Ч�ʵ�
	|--HashMap���ײ��ǹ�ϣ�����ݽṹ������ʹ��Null����nullֵ���ü����ǲ�ͬ���ġ�Ч�ʸ�
	|--TreeMap���ײ��Ƕ������ṹ���̲߳�ͬ�����������ڸ�map�����еļ�����

��Set����Set���ϵײ����Map���ϡ�
*/
import java.util.*;
class MapDemo 
{
	public static void main(String[] args) 
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("01","zhangsan1");
		map.put("02","zhangsan2");
		map.put("03","zhangsan3");

		System.out.println();
	}
}
