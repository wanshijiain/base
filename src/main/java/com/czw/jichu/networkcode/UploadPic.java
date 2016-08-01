package com.czw.jichu.networkcode;

/*
 * �ͻ��ˣ�
 * 1.��ȡͼƬ
 * 2.����ͼƬ
 * */
import java.net.*;
import java.io.*;
public class UploadPic {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		if(args.length!=1)
		{
			System.out.println("��ѡ��һ��jpg��ʽ��ͼƬ");
			return;
		}
		File file=new File(args[0]);
		if(!(file.exists()&&file.isFile()))
		{
			System.out.println("���ļ������⣬Ҫô������Ҫô�����ļ�");
			return;
		}
		if(!(file.getName().endsWith(".jpg")))
		{
			System.out.println("ͼƬ��ʽ����������ѡ��");
			return;
		}
		if(file.length()>1024*1024*5)
		{
			System.out.println("�ļ������������ϴ���С�ļ�");
			return;
		}
		
		Socket s=new Socket("10.101.2.235",10008);
		FileInputStream fis=new FileInputStream(file);
		OutputStream out=s.getOutputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=fis.read(buf))!=-1)
		{
			out.write(buf,0,len);
		}
		
		s.shutdownOutput();
		//�����Ѿ�д��ı�־
		
		InputStream in=s.getInputStream();
		byte[] bufin=new byte[1024];
		
		int num=in.read(bufin);
		System.out.println(new String(bufin,0,num));
		fis.close();
		s.close();
		
	}

}
class PicThread implements Runnable{
	private Socket s;
	PicThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		String ip=s.getInetAddress().getHostAddress();
		try{
			int count=1;
			System.out.println(ip+"connected...");
			InputStream in=s.getInputStream();
			
			File file=new File("D:\\User\\�ҵ�ͼƬ\\���汳��\\"+ip+"("+count+")"+".jpg");
			while(file.exists())
				file=new File("D:\\User\\�ҵ�ͼƬ\\���汳��\\"+ip+"("+(count++)+")"+".jpg");
			
			FileOutputStream fos=new FileOutputStream(file);
			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1)
			{
				fos.write(buf,0,len);
				fos.flush();
			}
			OutputStream out=s.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());
			fos.close();
			s.close();
		}catch(Exception e)
		{
			throw new RuntimeException(ip+"�ϴ�ʧ��");
		}
		
	}
}
class PicServer{
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(10008);
		while(true)
		{
			Socket s=ss.accept();
			new Thread(new PicThread(s)).start();
		}
		//ss.close();
		
	}
	
	
	
	
	
	
}
