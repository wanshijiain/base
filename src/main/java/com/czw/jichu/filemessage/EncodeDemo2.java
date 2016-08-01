package com.czw.jichu.filemessage;

public class EncodeDemo2 {

	/**
	 * @param args
	 */
	/*UTF-8���Ĺ���
	 * һ���ֽڱ�ʾ��0xxxxxxx
	 * �����ֽڱ�ʾ��110xxxxx 10xxxxxx
	 * �����ֽڱ�ʾ��1110xxxx 10xxxxxx 10xxxxxx
	 * 
	 * */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s="��ͨ";
		byte[] by=s.getBytes("GBK");
		for(byte b:by)
		{
			System.out.println(Integer.toBinaryString(b&255));
		}
	}

}
