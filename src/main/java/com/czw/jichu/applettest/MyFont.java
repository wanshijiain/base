package com.czw.jichu.applettest;

import java.applet.Applet;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyFont extends Applet implements ActionListener{
	int num=12;
	Font ft;
	Label jl;
	Button da,xiao;
	public void init(){		
		setLayout(new FlowLayout());
		jl=new Label("我的字符串");
		da=new Button("变大");
		xiao=new Button("缩小");
		add(jl);
		add(da);
		add(xiao);
		da.addActionListener(this);
		xiao.addActionListener(this);
		setSize(400,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==da) {ft=new Font("宋体",Font.BOLD,++num);
			if(num>=20) num=20;
			jl.setFont(ft);
		}
		if(e.getSource()==xiao) {ft=new Font("宋体",Font.BOLD,--num);
			if(num<=2)num=2;
			jl.setFont(ft);
		}
		
		
	}
	public void paint(Graphics g){
		g.drawString(jl.getName(),10,10);
	}
}

