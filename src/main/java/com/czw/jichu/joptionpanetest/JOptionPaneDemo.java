package com.czw.jichu.joptionpanetest;
import javax.swing.JOptionPane;
public class JOptionPaneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Object[] options = {"��ѯ","���","ȡ��","�˳�"};
		 int response=JOptionPane.showOptionDialog 
				 ( null, " ѡ��ҵ������","ATM ȡ���",JOptionPane.YES_OPTION
						 ,JOptionPane.PLAIN_MESSAGE,null, options, options[0] ) ;           
	     if (response == 0)
	      { JOptionPane.showMessageDialog(null,"�������˲�ѯ��ť");}
	     else if(response == 1)
	      { JOptionPane.showMessageDialog(null,"�������˴�ť");}
	     else if(response == 2)
	      { JOptionPane.showMessageDialog(null,"��������ȡ�ť");}
	     else if(response == 3)
	      { JOptionPane.showMessageDialog(null,"���������˳���ť");}
	}

}
