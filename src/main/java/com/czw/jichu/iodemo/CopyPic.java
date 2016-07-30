package com.czw.jichu.iodemo;
/*
 * ����һ��ͼƬ  �õ��ֽ���
 * */
import java.io.*;
public class CopyPic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try{
			fos=new FileOutputStream("");
			fis=new FileInputStream("");
			/*���ļ������Ǿ���Ҫ����һ���ֽ��������洢���ݣ�ͨ��ѭ������ȡ�ļ�������*/
			byte[] buf=new byte[1024];
			int len=0;
			while((len=fis.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
			
		}catch(IOException e)
		{
			throw new RuntimeException("�����ļ�ʧ��");
		}
		finally{
			try{
				if(fis!=null)
					fis.close();
				
			}catch(IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ��");
			}
			try{
				if(fos!=null)
					fos.close();
				
			}catch(IOException e)
			{
				throw new RuntimeException("д��ر�ʧ��");
			}
		}
	}

}
