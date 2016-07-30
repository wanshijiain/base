package com.czw.jichu.networkcode;
/*
 * ͨ��udp���䷽ʽ����һ���������ݷ��ͳ�ȥ��
 * 1.����udpsocket����
 * 2.�ṩ���ݣ��������ݷ�װ�����ݰ��С�
 * 3.ͨ��socket����ķ��͹��ܣ������ݰ�����ȥ��
 * 4.�ر���Դ��
 * */
import java.io.*;
import java.net.*;
public class UDPSend {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		DatagramSocket ds=new DatagramSocket();
//		 byte[] data="udp ge men lai le".getBytes();
//		 DatagramPacket dp=new DatagramPacket(data,data.length,InetAddress.getByName("10.101.2.235"),10000);
//		 ds.send(dp);
//		 ds.close();
		DatagramSocket ds=new DatagramSocket();
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=bf.readLine())!=null)
		{
			if("886".equals(line))
				break;
			byte[] buf=line.getBytes();
			DatagramPacket dp=new DatagramPacket(buf,buf.length,InetAddress.getByName("10.101.2.235"),10002);
			ds.send(dp);
		}
		ds.close();
	}

}


class UDPReceive {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		DatagramSocket ds=new DatagramSocket(10000);
//		byte[] buf=new byte[1024];
//		DatagramPacket dp=new DatagramPacket(buf,buf.length);
//		ds.receive(dp);
//		
//		String ip=dp.getAddress().getHostAddress();
//		String data=new String(dp.getData(),0,dp.getLength());
//		
//		int port=dp.getPort();
//		System.out.println(ip+"::"+data+"::"+port);
//		
//		ds.close();
		
		DatagramSocket ds=new DatagramSocket(10001);
		
		
		while(true)
		{
			byte[] buf=new byte[1024];
			DatagramPacket dp=new DatagramPacket(buf,buf.length);
			ds.receive(dp);
			
			String ip=dp.getAddress().getHostAddress();
			String data=new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+"::"+data);
			
		}
		
	}

}
