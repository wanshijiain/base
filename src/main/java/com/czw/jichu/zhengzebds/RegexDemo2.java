package com.czw.jichu.zhengzebds;
/*
 * ������ʽ�ĵ��ĸ����ܣ�
 * 4.��ȡ�������Ϲ�����ִ�ȡ��
 * 
 * �������裺
 * 1.������ʽ��װ�ɶ���
 * 2.����������Ҫ�������ַ����������
 * 3.�����󣬻�ȡ������ʽ���档
 * 4.ͨ������Է��Ϲ�����ִ����в���������ȡ����
 * 
 * */
import java.util.regex.*;
public class RegexDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDemo();
	}
	public static void getDemo()
	{
		String str = "ming tian jiu yao fang jia le.";
		str = "123456";
		
		String reg = "[0-9]\\d{4,14}";
		
		//�����װ�ɶ���
		Pattern p = Pattern.compile(reg);
		//����������Ҫ���õ��ַ��������
		Matcher m = p.matcher(str);
		System.out.println(m.matches());
		
		
	}

}
