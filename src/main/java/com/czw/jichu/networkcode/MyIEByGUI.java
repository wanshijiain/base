package com.czw.jichu.networkcode;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
//import java.net.*;
public class MyIEByGUI {

	/**
	 * @param args
	 */
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	
	private Dialog d;
	private Label lab;
	private Button okBut;
	MyIEByGUI()
	{
		init();
	}
	public void init()
	{
		f=new Frame("my window");
		f.setBounds(300,100,600,500);
		f.setLayout(new FlowLayout());
		
		tf=new TextField(60);
		but=new Button("ת��");
		ta=new TextArea(25,70);
		
		d=new Dialog(f,"��ʾ��Ϣ-self",true);
		d.setBounds(400,200,240,150);
		d.setLayout(new FlowLayout());
		lab=new Label();
		okBut=new Button("ȷ��");
		
		d.add(lab);
		d.add(okBut);
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		myEvent();
		f.setVisible(true);
	}
	private void myEvent()
	{
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				d.setVisible(false);
			}
		});
		tf.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e)
			{
				try{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					showDir();
				}catch(Exception ex){}
			}
		});
		but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
				showDir();
				}catch(Exception ex){}
			}
		});
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	private void showDir()throws Exception
	{
		ta.setText("");
		
		String url=tf.getText();
		
		int index1=url.indexOf("//")+2;
		int index2=url.indexOf("/",index1);
		
		String str=url.substring(index1,index2);
		String[] arr=str.split(":");
		String host=arr[0];
		int port =Integer.parseInt(arr[1]);
		String path=url.substring(index2);
		ta.setText(str+"...."+path);
		
		//����Ĵ����ȡurl���������ļ���ַ
		
		/*
		 * ������ʾ�Ի���
		String dirPath=tf.getText();
		File dir=new File(dirPath);
		
		if(dir.exists()&&dir.isDirectory())
		{
			ta.setText("");
			String[] names=dir.list();
			for(String name:names)
			{
				ta.append(name+"/r/n");
			}
			
		}
		else
		{
			String info="���������Ϣ:"+dirPath+"�Ǵ���ģ�������.";
			lab.setText(info);
			d.setVisible(true);
		}
		*/
		
		Socket s=new Socket(host,port);//�쳣UnknownHostException
		
		PrintWriter out=new PrintWriter(s.getOutputStream());//IOException
		out.println("GET"+path+" HTTP/1.1");
		out.println("Accept: */*");
		out.println("Accept-Language:zh-cn");
		out.println("Host:10.101.2.235:11000");
		out.println("Connection:closed");
		
		out.println();
		out.println();
		
		BufferedReader bufr=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			ta.append(line+"\r\n");
		}
		s.close();
	}
	public static void main(String[] args)
	{
		new MyIEByGUI();
	}

}








