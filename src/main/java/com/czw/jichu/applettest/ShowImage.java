package com.czw.jichu.applettest;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


public class ShowImage extends Applet{
	
	
	Button bt;
	Image im;
	File fl;
	StringBuffer sb;
	public void init(){
		try{
		fl=new File("D:\\User\\我的图片\\桌面背景");
		im=getImage(fl.toURI().toURL(),"2.jpg");
		}catch(IOException e){}
		this.setVisible(true);
		this.setSize(450,350);
		}
	
	
	
	
	public void paint(Graphics g){
		
		g.drawImage(im,25,25,400,300,this);
		
	}
	
}

//程序无法获取图片，未知原因



