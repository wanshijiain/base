package com.czw.jichu.zhengzebds;
/*
 * ������ʽ������һ�����ɵı��ʽ��
 * 		���ã�����ר�Ų����ַ�����
 * 		�ص㣺����һЩ�ض��ķ�������ʾһЩ�������������д
 * 		�ô������Լ򻯶��ַ����ĸ��Ӳ�����
 * 		�׶ˣ�����Խ�����Ķ���Խ��
 * 
 * ����������ܣ�
 * 1.ƥ�䣺String   matches(regex)
 * 2.�иString[] split
 * 3.�滻��String   replace
 * 
 * */
public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkQQ_2();
//		splitDemo("zhangsan.lisi.wangwu","\\.");
//		splitDemo("c:\\abc\\a.txt","\\\\");
//		splitDemo("erkktyqquio","(*)\\1+");//����ĳ���ַ����ֶ����,������ַ�����һ�����ϣ�����Ϊ�и��
								//Ϊ���ù���Ľ�����Ա����ã���()
								//��1��ʼ
		String str="wer1389980000ty1234564uiod234345675";
		
		replaceAllDemo(str,"\\d{5,}","#");
		
		String str1="erkktyqqquizzzzzo";//���ֳ���������ϣ��滻
		replaceAllDemo(str1,"(.)\\1+","$1");//����Ԫ���Ż�ȡ��ĸ��
	}
	public static void replaceAllDemo(String str,String reg,String newStr)
	{
		str=str.replaceAll(reg, newStr);
		System.out.println(str);
	}
	
	
	
	public static void splitDemo(String str,String reg)
	{
//		String str="zhangsan   lisi   wangwu";
//		
//		String reg=" +";//һ�λ��οո�
//		String reg=".";
		
		String[] arr=str.split(reg);
		for(String s:arr)
		{
			System.out.println(s);
		}
	}
	public static void checkTel()
	{
		String tel="13488575858";
		String telReg="1[358]\\d{9}";
		System.out.println(tel.matches(telReg));
	}
	public static void checkQQ_2()
	{
		String qq="133333";
		String regex="[1-9]\\d{4,14}";//��һλ1-9���ڶ�λ0-9������4��14��
		
		
		
		boolean flag=qq.matches(regex);
		if(flag)
			System.out.println(qq+"����is ok");
		else
			System.out.println(qq+"�������Ϸ�");
		
	}
	
	public static void checkQQ_1()
	{
		String qq="12345000000000000";
		int len=qq.length();
		
		if(len>=5&&len<=15)
		{
			if(!qq.startsWith("0"))
			{
				try {
					long l=Long.parseLong(qq);
					System.out.println("qq:"+l);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("�Ƿ��ַ�");
				}
				/*
				char[] arr=qq.toCharArray();
				boolean flag=false;
				for(int x=0;x<arr.length;x++)
				{
					if(!(arr[x]>='0'&&arr[x]<='9')){
						flag=true;
						break;
					}
				}
				if(flag)
				{
					System.out.println("qq:"+qq);
				}
				else
				{
					System.out.println("�Ƿ��ַ�");
				}
				*/
				
			}
			else
			{
				System.out.println("������0��ͷ");
			}
		}
		else
		{
			System.out.println("���ȴ���");
		}
		
	}

}
