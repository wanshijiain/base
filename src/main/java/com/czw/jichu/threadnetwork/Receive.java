package com.czw.jichu.threadnetwork;
import java.net.*;
public class Receive implements Runnable{

	/**
	 * @param args
	 */
	private DatagramSocket ds;
	public Receive(DatagramSocket ds)
	{
		this.ds=ds;
	}
	public void run()
	{
		try{
			byte[] bt=new byte[1024];
			DatagramPacket dp=new DatagramPacket(bt,bt.length);
			ds.receive(dp);
			
			String ip=dp.getAddress().getHostAddress();
			String data=new String(dp.getData(),0,dp.getLength());
			
			System.out.println(ip+"::"+data);
			
		}catch(Exception e)
		{
			throw new RuntimeException("����ʧ��..");
		}
	}

}

