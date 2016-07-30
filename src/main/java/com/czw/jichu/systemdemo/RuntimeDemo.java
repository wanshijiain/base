package com.czw.jichu.systemdemo;
/*
 * Runtime����
 * getRuntime()�������ظ������
 * */
public class RuntimeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Runtime r=Runtime.getRuntime();
		Process p=r.exec("winmine.exe");//����һ������
		
		r.exec("notepad.exe ����һ���ļ���");//���ַ�ʽ�����ü��±���һ���ļ�
		
		Thread.sleep(4000);
		p.destroy();
	}

}
/*
C:\Program Files\Java\jdk1.7.0_17\bin;F:\Ӧ�����\mysql\php;%path%;%windir%;%windir%\system32;%SystemRoot%\system32;F:\Ӧ�����\mysql\bin
*/