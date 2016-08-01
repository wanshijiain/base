package com.czw.jichu.applettest;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Label;

public class MyColor extends Applet {
	Label la1,la2,la3;
	public void init(){
		la1=new Label("红色");
		la2=new Label("蓝色");
		la3=new Label("黄色");
		la1.setBackground(Color.red);
		la2.setBackground(Color.blue);
		la3.setBackground(Color.yellow);
		add(la1);
		add(la2);
		add(la3);
		setSize(400,200);
	}


}
