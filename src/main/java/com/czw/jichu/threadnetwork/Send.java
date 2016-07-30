package com.czw.jichu.threadnetwork;
import java.io.*;
import java.net.*;
public class Send implements Runnable{

	/**
	 * @param args
	 */
	private DatagramSocket ds;
	public Send(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try{
			BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
			String s=null;
			while((s=bufr.readLine())!=null)
			{
				if("886".equals(s))
					break;
				byte[] bt=new byte[1024];
				DatagramPacket dp=new DatagramPacket(bt,bt.length,InetAddress.getByName("10,101,2,255"),10002);
				ds.send(dp);
			}
		}catch(Exception e)
		{
			throw new RuntimeException("����ʧ��...");
		}
		
	}

}
