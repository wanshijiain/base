package com.czw.jichu.guitest;
/*
 * Frame默认边界式布局CardLayout
 * 
 * 创建图形化界面
 * 1.创建frame窗体
 * 2.对窗体进行基本设置
 * 3.定义组件，添加组件
 * 
 * */
import java.awt.event.*;
import java.awt.*;
public class AwtDemo {
	private Frame fr;
	private Button b;
	AwtDemo()
	{
		init();
	}
	/**
	 * @param args
	 */
	public void init()
	{
		fr=new Frame("myFrame");
		fr.setSize(500,500);
		//fr.setLocation(300,200);
		fr.setBounds(300,100,600,500);
		
		fr.setLayout(new FlowLayout());
		
		b=new Button("我是按钮");
		
		myEvent();
		fr.add(b);
		fr.setVisible(true);
	}
	private void myEvent()
	{
		
		fr.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
			public void windowActivated(WindowEvent e)
			{
				System.out.println("获取焦点");
			}
			public void windowOpened(WindowEvent e)
			{
				System.out.println("我被打开..");
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new AwtDemo();
		
	}

}
/*
class MyWin extends WindowAdapter
{
	public void WindowAdapter(WindowEvent e)
	{
		System.exit(0);
	}
}
*/
