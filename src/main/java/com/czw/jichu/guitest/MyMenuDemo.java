package com.czw.jichu.guitest;
/*
 * 在dos中编译java包
 * javac -d c:\myclass MyMenuDemo.java//编译有主函数的类
 * 
 * jar -cvf my.jar GUITest//压缩包 mymenu是包名
 * 
 * 要双击执行jar包，首先要有配置信息，创建一个 XX.txt文件，内容如下：
 * Main-Class:GUITest.MyMenuDemo
 * 
 * jar -cvfm my.jar XX.txt GUITest
 * 
 * 在我的电脑->工具->文件选项->文件类型
 * 
 * */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class MyMenuDemo {

	/**
	 * @param args
	 */
	private Frame f;
	private MenuBar mb;
	private TextArea ta;
	private Menu m,subMenu;
	private MenuItem closeItem,openItem,saveItem,subItem;
	
	private FileDialog openDia,saveDia;
	
	private File file;
	
	MyMenuDemo()
	{
		init();
	}
	public void init()
	{
		f=new Frame("my window");
		f.setBounds(300,100,500,600);
		//f.setLayout();/*new FlowLayout()*/
		
		mb=new MenuBar();
		m=new Menu("文件");
		
		ta=new TextArea();
		
		closeItem=new MenuItem("退出");
		subMenu=new Menu("子菜单");
		subItem=new MenuItem("子条目");
		openItem=new MenuItem("打开");
		saveItem=new MenuItem("保存");
		
		m.add(openItem);
		m.add(saveItem);
		mb.add(m);
		m.add(subMenu);
		subMenu.add(subItem);
		m.add(closeItem);
		f.add(ta);
		
		
		f.setMenuBar(mb);
		openDia=new FileDialog(f,"我要打开",FileDialog.LOAD);
		saveDia=new FileDialog(f,"我要保存",FileDialog.SAVE);
		
		myEvent();
		f.setVisible(true);
	}
	private void myEvent()
	{
		saveItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(file==null){
					saveDia.setVisible(true);
					String dirPath=saveDia.getDirectory();
					String fileName=saveDia.getFile();
					if(dirPath==null||fileName==null)
						return;
					
					file=new File(dirPath,fileName);
				}
				try{
					BufferedWriter bufw=new BufferedWriter(new FileWriter(file));
					String text=ta.getText();
					bufw.write(text);
					//bufw.flush();
					bufw.close();
				}
				catch(IOException ex)
				{
					throw new RuntimeException("");
				}
				
				
			}
		});
		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				openDia.setVisible(true);
				String dirPath=openDia.getDirectory();
				String fileName=openDia.getFile();
				System.out.println(dirPath+".."+fileName);
				if(dirPath==null||fileName==null)
					return;
				ta.setText("");
				File file=new File(dirPath,fileName);
				try
				{
					BufferedReader bufr=new BufferedReader(new FileReader(file));
					String line=null;
					while((line=bufr.readLine())!=null)
					{
						ta.append(line+"\r\n");
					}
				}
				catch(IOException ex)
				{
					throw new RuntimeException("读取失败");
				}
			}
		});
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMenuDemo();
	}

}
