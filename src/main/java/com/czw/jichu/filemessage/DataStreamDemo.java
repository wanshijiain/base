package com.czw.jichu.filemessage;
import java.io.*;
public class DataStreamDemo {
	/*DataStreamд�������Ҫ��DataStream����ȡ��������������ֽ�ԭ����ܳ������������
	 * 
	 * �������Բ���������������
	 * ������
	 * 
	 * skipBytes(int n)  �μ� DataInput �� skipBytes �����ĳ���Э����
	 * readUTF(DataInput in) 
	 * read(byte[] b, int off, int len) 
	 * 
	 * ���Ӧ��write()....

	 * */
	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
//		writeData();
		readData();
		
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(""),"UTF-8");//��ת�������ָ���ַ�������ʽ
		osw.write("���");
		osw.close();
		
	}
	public static void writeUTFDemo()throws IOException
	{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(""));
		dos.writeUTF("���");
		dos.close();
		
	}
	public static void readData()throws IOException
	{
		DataInputStream dis=new DataInputStream(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\data.txt"));
		int num=dis.readInt();
		boolean b=dis.readBoolean();
		double d=dis.readDouble();
		
		System.out.println(num);
		System.out.println(b);
		System.out.println(d);
		
	}
	public static void writeData()throws IOException{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\data.txt"));
		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(9887.543);
		
		
		dos.close();
	}

}
