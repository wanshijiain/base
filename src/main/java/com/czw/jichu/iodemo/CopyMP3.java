package com.czw.jichu.iodemo;
import java.io.*;
/*
 * ��ʾMP3�ĸ��ơ�ͨ����������
 * BufferedOutputStream
 * BufferedInputStream
 * */
public class CopyMP3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		copy_1();
		long end=System.currentTimeMillis();
		System.out.println((end-start)+"����");
	}
	//ͨ���ֽ����Ļ����� 
	public static void copy_1()throws IOException
	{
		BufferedInputStream bufis=new BufferedInputStream(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\kwill.mp3"));
		BufferedOutputStream bufos=new BufferedOutputStream(new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\kwill_copy1.mp3"));
		
		byte[] buf=new byte[1024];
		int len=0;
		while((len=bufis.read(buf))!=-1)
		{
			bufos.write(buf,0,len);
		}
		/*ͨ���ֽ������ȡ�ļ�ʱ����66���루����ķ�����
		 * ͨ��һ�ζ�һ���ֽڵķ���ʱ����215����������ķ���
		 * �������ֽ�����Ķ�ȡ�ļ��ٶ�Ҫ��ö�*/
//		int by=0;
//		while((by=bufis.read())!=-1)
//		{
//			bufos.write(buf,0,len);
//		}
	
		bufos.close();
		bufis.close();
		
	}
	public static void copy_2()throws IOException
	{
		MyBufferedInputStream bufis=new MyBufferedInputStream(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\kwill.mp3"));
		BufferedOutputStream bufos=new BufferedOutputStream(new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\kwill_copy2.mp3"));
		
		int len=0;
		while((len=bufis.myRead())!=-1)
		{
			bufos.write(len);//read�������ص���int���͵�������4���ֽڣ�write����ֻȥint�ĵ�8λ����ǿ��ת��������������������������writeд�룬
							//���Բ������ԭʼ�����������ı������
			 
		}
		bufos.close();
		bufis.myClose();
	}
}
class MyBufferedInputStream
{
	private InputStream is;
	private byte[] buf=new byte[1024];
	private int pos=0,count=0;
	MyBufferedInputStream(InputStream is)
	{
		this.is=is;
	}
	//�ӻ�����һ�ζ�һ���ֽ�
	public int myRead()throws IOException
	{
		//ͨ��is�����ȡӲ���ϵ����ݣ����洢buf��
		
		if(count==0)
		{
			count=is.read(buf);
			if(count<0)
				return -1;
			pos=0;
			byte b=buf[pos];
			count--;
			pos++;
			return b&255;//����byte�ֽڵ����ݷ��أ������������ٲ�1
		}
		else if(count>0)
		{
			byte b=buf[pos];
			count--;
			pos++;
			return b&0xff;
		}
		return -1;
		
	}
	public void myClose()throws IOException
	{
		is.close();
	}
}
/*
 * ����int�� ��byte-->int
 * byte:-1 --> int:-1
 * 00000000 00000000 00000000 11111111   255
 * 11111111 11111111 11111111 11111111  
 * 
 * 11111111-->������һ��int���� ����-1 ��-1��ԭ������8��1��ǰ�油�Ļ���1���µ�
 * ֻҪ��ǰ�油0���Ա�֤ԭ�ֽ����ݲ����п��Ա���-1�ĳ���
 * 
 *  11111111 11111111 11111111 11111111  
 * &00000000 00000000 00000000 11111111
 * ---------------------------------------
 * 	00000000 00000000 00000000 11111111
 * */







