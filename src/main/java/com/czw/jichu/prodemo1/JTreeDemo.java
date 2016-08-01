package com.czw.jichu.prodemo1;


import java.awt.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JFrame;

//�����JTreeDemo�̳п�ܡ�
public class JTreeDemo extends JFrame {
	private DefaultMutableTreeNode root, red, green, blue,cyan;
	private JTree jtree1;
	private JPanel jpanel1;
	private DefaultTreeModel dtm;
	
private JFrame frame;

JTreeDemo() {
		super();
		initilize();

	}
//��ʼ����
	public void initilize() {
		frame = new JFrame("Jtree");

		root = new DefaultMutableTreeNode("Color");
		red = new DefaultMutableTreeNode("red");
		blue = new DefaultMutableTreeNode("blue");
		green = new DefaultMutableTreeNode("green");
		cyan=new DefaultMutableTreeNode("cyan");

		root.add(red);
		root.add(blue);
		root.add(green);
		green.add(cyan);

		dtm=new DefaultTreeModel(root,false);
		jtree1 = new JTree(dtm);
		jpanel1 = new JPanel();

		JSplitPane jsplitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				jtree1, jpanel1);
		jsplitpane.setOneTouchExpandable(true);//��ʾ�͹ر�tree���м����ϵ�����С����
		jsplitpane.setMinimumSize(new Dimension(100, 50));//�ָ�����С

		frame.getContentPane().add(jsplitpane);

		frame.setSize(600, 500);
		frame.setLocation(50, 50);
		frame.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//����Ϊĳ������ָ������Ĭ�ϴ���رշ�ʽ��

	}

	public static void main(String[] args) {
		new JTreeDemo();
	}

}