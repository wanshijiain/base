package com.czw.jichu.guitest;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class MouseAndKeyEvent {

	/**
	 * @param args
	 */
	
	private Frame fr;
	private Button but;
	private TextField tf;
	private TextArea ta;
	
	private Dialog dia;
	private Label la;
	private Button okBut;
	
	MouseAndKeyEvent()
	{
		init();
	}
	public void init()
	{
		fr=new Frame("myFrame");
		fr.setSize(500,500);
		//fr.setLocation(300,200);
		fr.setBounds(300,100,600,500);
		
		fr.setLayout(new FlowLayout());
		
		but=new Button("我是按钮");
		tf=new TextField(60);
		ta=new TextArea(25,70);
		
		dia=new Dialog(fr,"提示信息-self",true);//true是弹出的对话框不执行，无法使用fr界面
		dia.setBounds(400,200,240,150);
		dia.setLayout(new FlowLayout());
		
		la=new Label("");
		okBut=new Button("确定");
		
		fr.add(tf);
		fr.add(but);
		fr.add(ta);
		
		dia.add(la);
		dia.add(okBut);
		
		myEvent();
		
		
		
		fr.setVisible(true);
	}
	public void myEvent()
	{
		dia.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				dia.setVisible(false);
			}
		});
		okBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dia.setVisible(false);
			}
		});
		
		fr.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			/*
			public void windowActivated(WindowEvent e)
			{
				System.out.println("获取焦点");
			}
			public void windowOpened(WindowEvent e)
			{
				System.out.println("我被打开..");
			}
			*/
		});
		
		but.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				String dirPath=tf.getText();
				File dir=new File(dirPath);
				
				if(dir.exists()&&dir.isDirectory())
				{
					ta.setText("");
					String[] names=dir.list();
					for(String name:names)
					{
						ta.append(name+"\r\n");
					}
				}
				else
				{
					String info="您输入的信息"+dirPath+"是错误的,请重输。";
					la.setText(info);
					dia.setVisible(true);
				}
			}
		});
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseAndKeyEvent();
	}

}
