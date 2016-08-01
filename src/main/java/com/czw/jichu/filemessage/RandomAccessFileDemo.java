package com.czw.jichu.filemessage;
/*	����ɽ��ж�д������ֱ�Ӽ̳�Object
 *�ڲ���װһ�����飬ͨ��ָ�������Ԫ�ؽ��в�����
 *getFilePointer()   seek()//��ȡ����ָ��
 *	
 * �ڲ���װ���ֽ����������ֽ������������ֻ�ܲ����ļ���
 * ���Ҳ����ļ�����ģʽ��r  ��    rw  rws   rwd
 * 
 * seek(����ָ��);//���ָ�� 
 * skipBytes(�ֽ���);//����������
 * 
 * ���ģʽ��r���ᴴ���ļ�����ȥ��ȡһ���Ѵ��ڵ��ļ���������ļ������ڣ���ᱨ�쳣��
 * ���ģʽ��rw���������Ḳ���ļ���
 * 
 * 
 * �ܶ��ļ����������д������ļ��������й��ɡ���ô���Զ����ݽ����޸ġ�
 * 
 * 
 * ����ʹ���߳����ֶ�д�����ݣ����Լӿ�Ч�ʡ�
 * ��������������ԭ��
 * 
 * */
import java.io.*;
public class RandomAccessFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
//		writeFile();
		writeFile2();
	}
	public static void readFile()throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\ran.txt","r");
//		raf.write("haha".getBytes());
		byte[] buf=new byte[4];
		raf.read(buf);
		
		String name=new String(buf,0,buf.length,"GBK");
		
		int age=raf.readInt();
		
		System.out.println("name::"+name);
		System.out.println("age::"+age);
		raf.close();
		
		
	}
	public static void writeFile2()throws IOException
	{
		//�����ܽ�������Ķ�д���ܶ��й��ɵ����ݽ����޸ġ�
		RandomAccessFile raf=new RandomAccessFile("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\ran.txt","rw");
		
		raf.seek(8*3);
		raf.write("����".getBytes());
		raf.writeInt(103);//д���ĸ��ֽڣ��յĲ��ִ�ո�
		
		raf.close();
	}
	public static void writeFile()throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\ran.txt","rw");
		
		raf.write("����".getBytes());
		raf.writeInt(97);//д���ĸ��ֽڣ��յĲ��ִ�ո�
		raf.write("����".getBytes());
		raf.writeInt(99);
		
		raf.close();
		
	}

}
