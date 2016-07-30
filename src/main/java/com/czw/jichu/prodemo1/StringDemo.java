package com.czw.jichu.prodemo1;
/*
 * string�ķ�����
 * indexOf()  substring()  replace()   valueOf()    toCharArray()   contains()   equals()  
 * isEmpty()    startsWith()  endsWith()   charAt()   getBytes()    lastIndexOf()
 * toUpperCase()   toLowerCase()   split()    trim()    replaceAll()   replaceFirst()
 * length()    
 * concat(String str)  ��ָ���ַ������ӵ����ַ����Ľ�β��
 * 
 * StringBuffer������
 * setCharAt(index,char)  replace(start,end,str)  substring()//�˷����Ż�string
 * indexOf()  lastindexOf()  charAt()   append() insert()//����StringBuffer
 * delete(start,end) deleteCharAt(index)
 * reverse()
 * 
 * StringBuilder������
 * ��StringBuffer��ͬ��StringBuilder�������������Ч��
 * getChars(begin,end,char[],char[index])
 * ����
 * 		char[] chs=new char[4];
 * 		sb.getChars(1,4,chs,1)//sb�е�1��3���ַ��������1��ʼ���ַ�������
 * 
 * */


public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="affccfejocc cdjccjsfoccdcs";
		String s1="abcwerthelloyuiodef",s2="cvhellobnm";
	//	sop(myTrim(s));
	//	StringBuffer sb=new StringBuffer(s);
	//	System.out.println(sb.reverse());
	//	sop("count"+getSubCount(s,"cc"));
	//	sop(reverseString(s));
		sop(getMaxsubstring(s1,s2));
		
	}
	
	/*1.��ȡmin.length���ȵ��ַ�����max�Ƚ�
	 *2.x��1����ȡ����min��min.length-1���ȵ��ַ�����max�Ƚϡ�
	 *3.ֱ�����max��min�������ͬ�ִ���*/
	public static String getMaxsubstring(String s1,String s2){
		String max="",min="";
		max=(s1.length()>s2.length())?s1:s2;
		min=(max==s1)?s2:s1;
		for(int x=0;x<min.length();x++){
			for(int y=0,z=min.length()-x;z!=min.length()+1;y++,z++){
				String temp=min.substring(y,z);
				if(max.contains(temp))
					return temp;	
			}
		}
		return "";
	}//�ж������ַ����а�����������ͬ�ַ�������ӡ
	
	


	
	private static int getSubCount(String str,String key){
		int index=0,count=0;
		while((index=str.indexOf(key,index))!=-1){
			sop("index"+index);
			index=index+key.length();
			count++;
		}
		return count;
	}//�����ַ���str���ַ���key���ֵĴ���
	
	private static void sop(String str){
		System.out.println(str);
	}
	private static String myTrim(String str){
		int start=0,end=str.length()-1;
		while(start<=end&&str.charAt(start)==' ')
			start++;
		while(start<=end&&str.charAt(end)==' ')
			end--;
		return str.substring(start,end+1);
	}//��ȥ�ַ������˵Ŀո�
	
	
	private static String reverseString(String str){
		char[] cha=str.toCharArray();
		char temp=cha[0];
		
		for(int i=0,j=str.length();i<=j/2;i++,j--){
			temp=cha[i];
			cha[i]=cha[j-1];
			cha[j-1]=temp;
			
		}
		return new String(cha);
	}//�ַ�����ת
}
