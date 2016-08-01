package com.czw.jichu.iodemo;
import java.io.*;
public class CopyTextByBuf {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bufr=null;
		BufferedWriter bufw=null;
		try{
			bufr=new BufferedReader(new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf.txt"));
			bufw=new BufferedWriter(new FileWriter("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf_copy.txt"));
			String line=null;
			while((line=bufr.readLine())!=null)
			{
				bufw.write(line);//��������ֹ��������Ҫʹ��newLine����
				bufw.newLine();
				bufw.flush();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				if(bufr!=null)
					bufr.close();
			}catch(IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ��");
			}
			try{
				if(bufw!=null)
					bufw.close();
			}catch(IOException e)
			{
				throw new RuntimeException("д��ر�ʧ��");
			}
		}
		
		
	}

}
