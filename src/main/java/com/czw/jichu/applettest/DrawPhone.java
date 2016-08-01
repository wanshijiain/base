package com.czw.jichu.applettest;

import java.applet.*; 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
public class DrawPhone extends Applet 
{ 
/**
	 * 
	 */
	private static final long serialVersionUID = 4178546188130341474L;
	String str; 
	int x, y, ScrX, ScrY, KeyX, KeyY; 
	Image img; 
	public void init()
	{ 
	x=20; y=20; 
	ScrX=45; ScrY=72; 
	KeyX=45; KeyY=350; 
	img = getImage(getCodeBase(), "ScreenPic.jpg"); 
	this.setSize(350,600);
	} 
	public void paint(Graphics g) 
	{ 
	/*Background*/ 
	g.setColor(new Color(60,60,60)); 
	g.fillRoundRect(x, y, 250, 500, 50,50); 
	g.setColor(new Color(0,0,0)); 	
	g.fillRoundRect(x+7, y+7, 235, 485, 30, 30); 
	/*white light*/ 
	int[] v = {31,31,33,37,47,37,35}; 
	int[] w = {50,38,33,31,31,35,37}; 
	g.setColor(new Color(255,255,255)); 
	g.fillPolygon(v, w, v.length); 
	/*NOKIA N73*/ 
	Font f=new Font("Arial Black", Font.PLAIN, 12); 
	g.setFont(f); 
	g.setColor(new Color(255,255,255)); 
	g.drawString("NOKIA", x+25, y+28); 
	Font f1=new Font("Arial", Font.PLAIN, 12); 
	g.setFont(f1); 
	g.drawString("N73", x+48, y+40); 
	/*3G Camera*/ 
	g.setColor(new Color(255,255,255)); 
	g.fillRoundRect(x+175, y+15, 30, 30, 10, 10); 
	g.setColor(new Color(60,60,60)); 
	g.fillRoundRect(x+177, y+17, 26, 26, 10, 10); 
	g.setColor(new Color(0,0,0)); 
	g.fillOval(x+185, y+25, 10, 10); 
	/*ear speaker*/ 
	g.setColor(new Color(80,80,80)); 
	g.drawRoundRect(115, 43, 50, 15, 15, 15); 
	g.setColor(new Color(255,255,255)); 
	g.fillRoundRect(121, 47, 38, 8, 10, 10); 
	/*Blue Light*/ 
	g.setColor(new Color(0,0,255)); 
	g.fillRoundRect(x+158, y+24, 12, 12, 3, 3); 
	g.setColor(new Color(255,255,255)); 
	g.drawLine(x+160, y+29, x+160, y+26); 
	g.drawLine(x+160, y+26, x+161, y+25); 
	g.drawLine(x+161, y+25, x+164, y+25); 
	/*Key*/ 
	g.setColor(new Color(120,120,120)); 
	g.drawRoundRect(KeyX, KeyY, 197, 150, 25, 30); 
	/*Uper Key Area*/ 
	g.setColor(new Color(255,255,255)); 
	g.fillRoundRect(KeyX+10, KeyY+8, 177, 40, 20,20); 
	g.setColor(new Color(220,220,220)); 
	g.fillRoundRect(KeyX+20, KeyY+12, 157, 32, 10, 20); 
	g.setColor(new Color(70,70,70)); 
	g.fillRoundRect(KeyX+60, KeyY+15, 80,26, 5, 5); 
	g.setColor(new Color(180,180,180)); 
	g.fillRoundRect(KeyX+62, KeyY+17, 76,22, 10, 10); 
	g.setColor(new Color(250,250,250)); 
	g.fillRoundRect(KeyX+91, KeyY+18, 20, 20, 5, 5); 
	g.setColor(new Color(100,100,100)); 
	g.fillRoundRect(KeyX+93, KeyY+20, 16, 16, 4, 4); 
	g.setColor(new Color(0,0,0)); 
	g.fillRect(KeyX+10, KeyY+28, 81, 2); 
	g.fillRect(KeyX+111, KeyY+28, 76, 2); 
	/**Uper Key Symbol*/ 
	g.setColor(new Color(14,201,222)); 
	g.drawLine(KeyX+31, KeyY+18, KeyX+31, KeyY+25); 
	g.drawLine(KeyX+31, KeyY+18, KeyX+33, KeyY+16); 
	g.drawLine(KeyX+33, KeyY+16, KeyX+46, KeyY+16); 
	g.drawLine(KeyX+150, KeyY+16, KeyX+163, KeyY+16); 
	g.drawLine(KeyX+163, KeyY+16, KeyX+165, KeyY+18); 
	g.drawLine(KeyX+165, KeyY+18, KeyX+165, KeyY+25); 
	g.setColor(new Color(0, 255, 0)); 
	g.drawLine(KeyX+31, KeyY+32, KeyX+31, KeyY+39); 
	g.drawLine(KeyX+31, KeyY+39, KeyX+33, KeyY+41); 
	g.drawLine(KeyX+33, KeyY+41, KeyX+46, KeyY+41); 
	g.setColor(new Color(255, 0, 0)); 
	g.drawLine(KeyX+150, KeyY+41, KeyX+163, KeyY+41); 
	g.drawLine(KeyX+163, KeyY+41, KeyX+165, KeyY+39); 
	g.drawLine(KeyX+165, KeyY+39, KeyX+165, KeyY+32); 
	g.drawLine(KeyX+153, KeyY+34, KeyX+159, KeyY+34); 
	/*lower key*/ 
	g.setColor(new Color(20,20,20)); 
	int[]xx = {65,222,222,217,70,65}; 
	int[]yy = {398,398,485,492,492,485}; 
	g.fillPolygon(xx, yy, xx.length); 
	/*table line*/ 
	/*side line*/ 
	g.setColor(new Color(60,60,60)); 
	g.drawLine(KeyX, 444, 65, 444); 
	g.drawLine(221, 444, KeyX+197, 444); 
	/*row*/ 
	g.setColor(new Color(0,128,255)); 
	g.drawLine(65, 421, 221, 421); 
	g.drawLine(65, 444, 221, 444); 
	g.drawLine(65, 467, 221, 467); 
	/*column*/ 
	g.drawLine(117, 398, 117, 491); 
	g.drawLine(169, 398, 169, 491); 
	/*symbol*/ 
	/*menu symbol*/ 
	g.fillOval(KeyX+5, 422, 5, 5); 
	g.drawRect(KeyX+11, 416, 3, 3); 
	g.drawArc(KeyX+4, 415, 8, 10, 90, 90); 
	g.drawArc(KeyX+7, 417, 8, 11, 270, 90); 
	/*pencil Symbol*/ 
	g.setColor(new Color(117,186,255)); 
	g.drawLine(KeyX+5, 465, KeyX+11, 471); 
	g.drawLine(KeyX+6, 462, KeyX+12, 468); 
	g.drawLine(KeyX+8, 460, KeyX+14, 466); 
	g.drawLine(KeyX+5, 465, KeyX+6, 462); 
	g.drawLine(KeyX+6, 462, KeyX+8, 460); 
	g.drawLine(KeyX+11, 471, KeyX+12, 468); 
	g.drawLine(KeyX+12, 468, KeyX+14, 466); 
	g.drawLine(KeyX+14, 466, KeyX+15, 471); 
	g.drawLine(KeyX+15, 471, KeyX+11, 471); 
	/*Music Symbol*/ 
	g.fillOval(224,421,4,4); 
	g.fillOval(231,421,5,5); 
	g.drawLine(227,421,228,416); 
	g.drawLine(228,416,237,414); 
	g.drawLine(236,414,235,422); 
	/*C Symbol*/ 
	g.drawRoundRect(229,461,7,10,2,2); 
	g.setColor(new Color(0,0,0)); 
	g.fillRect(235, 461, 3, 12); 
	/*Number*/ 
	g.setColor(new Color(117,186,255)); 
	g.drawString("1", 78, 413); 
	g.drawString("2", 130, 413); 
	g.drawString("3", 202, 413); 
	g.drawString("4", 78, 436); 
	g.drawString("5", 130, 436); 
	g.drawString("6", 202, 436); 
	g.drawString("7", 78, 459); 
	g.drawString("8", 130,459); 
	g.drawString("9", 202,459); 
	g.drawString("0", 130,485); 
	/*Numpad Symbol and word*/ 
	Font f2=new Font("Arial", Font.PLAIN, 8); 
	g.setFont(f2); 
	g.drawString("@", 95, 407); 
	g.drawRoundRect(93,411,4,4,2,2); 
	g.drawRoundRect(101,411,4,4,2,2); 
	g.drawLine(94, 415, 102, 415); 
	Font f3=new Font("Arial", Font.PLAIN, 9); 
	g.setFont(f3); 
	g.drawString("abc", 143, 413); 
	g.drawString("def", 180, 413); 
	g.drawString("ghi", 93, 436); 
	g.drawString("jkl", 143, 436); 
	g.drawString("mno", 180, 436); 
	g.drawString("pqrs", 91, 459); 
	g.drawString("tuv", 143, 459); 
	g.drawString("wxyz", 178, 459); 
	g.drawLine(93, 477, 93, 485); 
	g.drawLine(90, 479, 96, 483); 
	g.drawLine(90, 483, 96, 479); 
	/*+*/ 
	g.drawString("+", 103, 485); 
	/*0*/ 
	g.drawLine(145, 486, 155, 486); 
	g.drawLine(145, 486, 145, 484); 
	g.drawLine(155, 486, 155, 484); 
	Font i= new Font("Brush Script MT", Font.BOLD, 12); 
	g.setFont(i); 
	g.setColor(new Color(0,128,255)); 
	g.drawString("i", 149,481); 
	g.drawArc(145,473,11,8,180,180); 
	/*Arrow*/ 
	g.setColor(new Color(117,186,255)); 
	g.drawLine(188,486,192,486); 
	g.drawLine(188,486,188,483); 
	g.drawLine(192,486,192,483); 
	g.drawLine(188,483,186,483); 
	g.drawLine(192,483,194,483); 
	g.drawLine(186,483,190,479); 
	g.drawLine(194,483,190,479); 
	/*#*/ 
	Font q = new Font("Arial", Font.BOLD, 12); 
	g.setFont(q); 
	g.drawString("#", 204,485); 
	/*Screen*/ 
	g.setColor(new Color(108, 108,255)); 
	g.fillRoundRect(ScrX, ScrY, 197, 250, 10, 10); 
	g.drawImage(img, ScrX, ScrY, this); 
	/*coverage signal*/ 
	g.setColor(new Color(255,121,252)); 
	g.fillRect(ScrX+5,ScrY+5,10,4); 
	g.fillRect(ScrX+5,ScrY+11,8,4); 
	g.fillRect(ScrX+5,ScrY+17,6,4); 
	g.fillRect(ScrX+5,ScrY+23,4,4); 
	g.drawLine(ScrX+5,ScrY+30,ScrX+11,ScrY+30); 
	g.drawLine(ScrX+5,ScrY+30,ScrX+8,ScrY+33); 
	g.drawLine(ScrX+11,ScrY+30,ScrX+8,ScrY+33); 
	g.drawLine(ScrX+8,ScrY+30,ScrX+8,ScrY+38); 
	/*Batter signal*/ 
	g.fillRect(ScrX+182,ScrY+5,10,4); 
	g.fillRect(ScrX+184,ScrY+11,8,4); 
	g.fillRect(ScrX+186,ScrY+17,6,4); 
	g.fillRect(ScrX+188,ScrY+23,4,4); 
	g.drawRect(ScrX+188,ScrY+29,2,2); 
	g.drawRect(ScrX+186,ScrY+31,6,8); 
	/*Screen Word*/ 
	g.drawString("Messageing",ScrX+5, ScrY+245); 
	g.drawString("Contacts", ScrX+142, ScrY+245); 
} 
}
