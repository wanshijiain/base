package com.czw.jichu.networkcode;
import java.net.*;
import java.io.*;

/*
 * �˴����е�����
 * */
public class UserLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket s=new Socket("10.101.2.235",10009);
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(s.getOutputStream());
		BufferedReader bufin=
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		for(int x=0;x<3;x++)
		{
			String line=bufr.readLine();
			if(line==null)
				break;
			
			
			out.println(line);

			String info=bufin.readLine();
			System.out.println("info:"+info);
			if(info.contains("��ӭ"))
				break;
		}
		bufr.close();
		s.close();
	}

}

class UserThread implements Runnable
{
	private Socket s;
	UserThread(Socket s)
	{
		this.s=s;
	}
	@SuppressWarnings("unused")
	public void run()
	{
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		try
		{
			
			//����У�飬������̲߳���ִ�С�
			for(int x=0;x<3;x++)
			{
				BufferedReader bufin=new BufferedReader(new InputStreamReader(s.getInputStream()));
				String name=bufin.readLine();
				
				if(name==null)
					break;
				
				BufferedReader bufr=new BufferedReader(new FileReader("user.txt"));
				String line=null;
				
				PrintWriter out=new PrintWriter(s.getOutputStream(),true);
				
				boolean flag=false;
				while((line=bufr.readLine())!=null)
				{
					if(line.equals(name))
					{
						flag=true;
						break;
					}
				}
				if(flag)
				{
					System.out.println(name+",�ѵ�¼");
					out.println(name+",��ӭ����");
					break;
				}
				else
				{
					System.out.println(name+",���Ե�¼");
					out.println(name+",�û���������");
					break;
				}
				
				
			}
			s.close();
		}catch(Exception e)
		{
			throw new RuntimeException("У��ʧ��");
		}
	}
}
class ServerLogin{
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(10009);
		while(true)
		{
			Socket s=ss.accept();
			new Thread(new UserThread(s)).start();
		}
	}
}







