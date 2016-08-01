package com.czw.jichu.applettest;

import java.awt.*;  
import java.awt.event.*;  
import java.net.*;  
/** 
 * Sample application using Frame. 
 * 
 * @author  
 * @version 1.00 11/04/22 
 */  
public class ChatFrame extends Frame {  
      
	
    List lst = new List(6);  
    TextField tfIP= new TextField(15);  
    TextField tfData=new TextField(20);  
      
    DatagramSocket ds=null;  
      
      
      
     public ChatFrame() {  
                  
                try  
                {  
                      
                    ds= new DatagramSocket(3000);  
                      
                   
                }  
                catch(Exception e)  
                {  
                    e.printStackTrace();  
                }   
                  
        MenuBar menuBar = new MenuBar();  
        Menu menuFile = new Menu();  
        MenuItem menuFileExit = new MenuItem();  
          
        menuFile.setLabel("File");  
        menuFileExit.setLabel("Exit");  
          
        // Add action listener.for the menu button  
        menuFileExit.addActionListener  
        (  
            new ActionListener() {  
                public void actionPerformed(ActionEvent e) {  
                    ChatFrame.this.windowClosed();  
                }  
            }  
        );   
        menuFile.add(menuFileExit);  
        //menuBar.add(menuFile);  
          
        setTitle("Chat");  
        setMenuBar(menuBar);  
        setSize(new Dimension(400, 400));   
        setResizable(false);  
          
        this.add(lst,"Center");  
          
        Panel p= new Panel();  
        this.add(p,"South");  
        p.add(tfIP,"West");  
        p.add(tfData,"East");  
          
        new Thread(new Runnable()  
           {  
                public void run()  
                {  
                    byte[] buf=new byte[1024];  
                
                    DatagramPacket dp=new DatagramPacket(buf,buf.length);   
                    while(true)  
                    {  
                        try  
                        {   
                            ds.receive(dp);  //���հ�  
                            lst.add(new String(buf,0,dp.getLength())+"from"+dp.getAddress() ,0);  
                        }  
                        catch(Exception e)  
                        {  
                            e.printStackTrace();  
                        }  
                       
                    }  
                  
                  
                }  
            }  
              
        ).start();  
          
        tfData.addActionListener(new ActionListener()  
            {  
                public void actionPerformed(ActionEvent e)  
                {  
                    byte[] buf;  
                    buf=tfData.getText().getBytes();  
                      
                   
                    try  
                    {  
                  
                    DatagramPacket dp= new DatagramPacket(buf,buf.length,  
                    InetAddress.getByName(tfIP.getText()),3000);  //�����ֽ�,�ֽڳ���,Ip��ַ,�˿�  
                      
                    ds.send(dp); //���Ͱ�  
                    }  
                    catch(Exception ex)  
                    {  
                        ex.printStackTrace();  
                    }  
                   
                    tfData.setText("");  
                }  
            }  
        );  
          
        // Add window listener.  
        this.addWindowListener  
        (  
            new WindowAdapter() {  
                public void windowClosing(WindowEvent e) {  
                      
                    ds.close();  
                    ChatFrame.this.windowClosed();  
                }  
            }  
        );    
    }  
      
      
    /** 
     * Shutdown procedure when run as an application. 
     */  
    protected void windowClosed() {  
          
        // TODO: Check if it is safe to close the application  
          
        // Exit application.  
        System.exit(0);  
    }  
    public static void main(String[] args)
    {
    	new ChatFrame().setVisible(true);
    }
}  
