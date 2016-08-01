package com.czw.jichu.filemessage;
/*
 * �ܵ���ʹ�ö��̼߳���
 * 
 * �뷨��
 * �Ƿ����ʹ�úϲ���SequenceInputStream����ΪԴ,��װ���ܵ���PipedInputStream��
 * ������ͨ���ܵ���PipedOutputStream��ӡ��Ŀ���С�
 * ����뷨����
 * 
 * */
import java.io.*;
class Read implements Runnable
{
	private PipedInputStream in;
	Read(PipedInputStream in)
	{
		this.in=in;
	}
	public void run()
	{
		try{
			byte[] buf=new byte[1024];
			System.out.println("��ȡǰ����û�����ݾ�����");
			int len=in.read(buf);
			System.out.println("�������ݡ�������������");
			String s=new String(buf,0,len);
			System.out.println(s);
			in.close();
		}catch(IOException e)
		{
			throw new RuntimeException("�ܵ���ȡ��ʧ��");
		}
	}
}
class Write implements Runnable 
{
	private PipedOutputStream out;
	Write(PipedOutputStream out)
	{
		this.out=out;
	}
	public void run()
	{
		try{
			System.out.println("��ʼд�����ݣ��ȴ�6��󡣡�");
			Thread.sleep(6000);
			out.write("piped lai le".getBytes());
			out.close();
		}catch(Exception e)
		{
			throw new RuntimeException("�ܵ�д����ʧ��");
		}
	}
}
public class PipedStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream();
		pis.connect(pos);//����������������������
		Read r=new Read(pis);
		Write w=new Write(pos);
		
		new Thread(r).start();
		new Thread(w).start();
		
	}

}
