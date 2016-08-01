package com.czw.jichu.javase;
/*
 * ��ϰ��
 * ��sdfgzxcvasdfxcvdf����ȡ���ַ����е���Ļ���ֵĴ�����
 * ϣ����ӡ�����a(1)b(2)
 * 
 * ͨ��������֣�ÿ����Ļ���ж�Ӧ�Ĵ�����
 * ˵����Ļ�ʹ���֮�䶼��ӳ���ϵ��
 * 
 * ע���ˣ���������ӳ���ϵʱ������ѡ��map���ϡ���Ϊmap�����д�ŵľ���ӳ���ϵ��
 * 
 * ������֮���������ӳ���ϵʱ����Ҫ����map���ϡ�
 * 
 * ˼·��
 * 1.���ַ���ת�����ַ����飬��ΪҪ��ÿ����ĸ���в�����
 * 2.����һ��map���ϣ���Ϊ��ӡ�������Ļ��˳������ʹ��treemap���ϡ�
 * 3.�����ַ����顣
 * 		��ÿ����ĸ��Ϊ��ȥ��map���ϡ�
 * 		�������null��ÿ����Ļ��1���뵽map�����С�
 * 		������ز���null��˵������ĸ��map�����Ѿ����ڲ��ж�Ӧ�Ĵ�����
 * 		��ô�ͻ�ȡ�ô���������������Ȼ�󽫸���ĸ��������Ĵ�����뵽map�����С�
 * 4.��map�����е����ݱ��ָ�����ַ������ء�
 * */
import java.util.*;
public class MapTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=charCount("aabfcabcdefa");
		System.out.println(s);
	}
	public static String charCount(String str)
	{
		char[] chs=str.toCharArray();
		TreeMap<Character,Integer> tm=new TreeMap<Character,Integer>();
		
		int count=0;
		for(int x=0;x<chs.length;x++)
		{
			Integer value=tm.get(chs[x]);
			
			if(value!=null)
			{
//				count=value.intValue();
				count=value;//JDK1.5�����ԣ�����ֱ�ӽ�Integer������������int
				
			}		
			count++;
			tm.put(chs[x], count);
			
			count=0;
			/*
			if(value==null)
			{
				tm.put(chs[x], 1);
			}
			else
			{
				value=value+1;
				tm.put(chs[x], value);
			}
			*/
			
		}
		
		//System.out.println(tm);
		
		StringBuilder sb=new StringBuilder();
		
		Set<Map.Entry<Character, Integer>> entrySet=tm.entrySet();
		Iterator<Map.Entry<Character, Integer>> it=entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<Character, Integer> me=it.next();
			Character ch=me.getKey();
			Integer value=me.getValue();
			sb.append(ch+"("+value+")");
		}
		return sb.toString();
	}

}
