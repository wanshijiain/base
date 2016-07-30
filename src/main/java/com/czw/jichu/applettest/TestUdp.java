package com.czw.jichu.applettest;

import java.net.*;   
class TestUdp {   
      
      public static void main(String [] args)   throws Exception  
      {  
         //发送信息  
         DatagramSocket ds= new DatagramSocket();  
         String strinfo="hello www.it315.org";  
         ds.send(new DatagramPacket(strinfo.getBytes(),strinfo.length(),InetAddress.getByName("10.101.2.235"),3000));   
         ds.close();  
           
         //接收信息  
         DatagramSocket ds1= new DatagramSocket(3000);  
         byte[] buf=new byte[1024];  
         DatagramPacket dp= new DatagramPacket(buf,1024);  
         ds1.receive(dp);  
         String str=new String(dp.getData(),0,dp.getLength());   
         System.out.println(str);  
          
                 
   }  
   
}  