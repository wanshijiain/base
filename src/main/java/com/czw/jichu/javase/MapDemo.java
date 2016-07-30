package com.czw.jichu.javase;

/*
Map���ϣ��ü��ϴ洢��ֵ�ԡ�һ��һ������档����Ҫ��֤����Ψһ��
	1.��ӡ�
		put(K key,V value)//put��������ԭ���ڴ˼��϶����ֵ
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

Map���ϵ�����ȡ����ʽ��
	1.Set<K> keySet����Map�����еļ�����Set��,��Set�еĵ�������
	
	2.Set<Map.Entry<k,v>> entrySet����map�����е�ӳ���ϵ����set�����У��������ϵ���������;���Map.Entry
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

		//��map�����е�ӳ���ϵȡ��������set������
		Set<Map.Entry<String, String>> entrySet=map.entrySet();
		
		Iterator<Map.Entry<String, String>> it1=entrySet.iterator();
		while(it1.hasNext())
		{
			Map.Entry<String,String> me=it1.next();
			String key=me.getKey();
		    String value=me.getValue();
		    sop(key+":"+value);
		}
		
		/*
		sop("containsKey:"+map.containsKey("022"));
		sop("remaove:"+map.remove("02"));
		
		sop("get:"+map.get("023"));
		
		map.put("04", null);
		System.out.println("get:"+map.get("04"));
		//����ͨ��get��������ֵ���ж�һ�����Ƿ���ڡ�ͨ������null���жϡ���
		
		//��ȡmap�����е�����ֵ
		Collection<String> coll=map.values();
		
		sop(coll);
		sop(map);
		*/
		Set<String> keySet=map.keySet();
		Iterator<String> it=keySet.iterator();
		while(it.hasNext())
		{
			String key=it.next();
			String value=map.get(key);
			sop("key--"+key+"--value--"+value);
		}
		
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

