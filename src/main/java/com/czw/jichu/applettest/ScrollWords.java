package com.czw.jichu.applettest;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;



public class ScrollWords
{
    JLabel lab;
    
    String str;
     
    public ScrollWords()
    {
    	int i;
        JFrame frame = new JFrame("TextMove");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        str = "I'm moving...";
        lab = new JLabel(str);
        frame.add(lab);
        frame.setVisible(true);
        i=0;
        while(true)
        {
                                  
            try
            {
                Thread.sleep(300);
                lab.setBounds(i,80,80,20);
                i=(i+20)%frame.getWidth();
                if((i/frame.getWidth())>0)
                	i=-110;
            }
            catch(InterruptedException e)
            {
            }
        }
    }
     
    public static void main(String args[])
    {
        new ScrollWords();
    }
}