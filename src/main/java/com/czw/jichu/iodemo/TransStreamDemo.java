package com.czw.jichu.iodemo;
/*
 * �ַ�����
 * FileReader
 * FileWriter
 * 
 * BufferedReader
 * BufferedWriter
 * �ֽ�����
 * FileInputStream
 * FileOutputStream
 * 
 * BufferedInputStream
 * BufferedOutputStream
 * 
 * ͨ��ReadIn��ļ���¼��һ�����ݲ���ӡ���д�����־��Ƕ�һ�����ݵ�ԭ��
 * Ҳ����readLine����
 * 
 * �ܲ���ֱ����readLine��������ɼ��������һ�����ݵĶ�ȡ
 * 
 * readLine�������ַ���BufferedReader���еķ���
 * ������¼���read�������ֽ���InputStream�ķ�����
 * 
 * �����ܲ��ܽ��ֽ���ת�����ַ�������ʹ���ַ�����������readLine����
 * 
 **/
import java.io.*;

//ReadIn�ļ�������ת�����ַ�������ʽ



/*1.
 * Դ������¼��
 * Ŀ�ģ�����̨
 * 
 * 2.������Ѽ���¼������ݴ洢���ļ���
 * Դ������¼��
 * Ŀ�ģ��ļ�
 * 
 * 3.������Ҫ��һ���ļ������ݴ�ӡ�ڿ���̨��
 * Դ���ļ�
 * Ŀ�ģ�����̨
 * 
 * 
 * �������Ļ������ɣ�
 * 		�������кܶ࣬��֪�������ĸ�
 * 
 * 
 * ͨ��������ȷ��
 * 1.��ȷԴ��Ŀ��
 * 		Դ��������		InputStream		Reader
 * 		Ŀ�ģ������		OutputStream	Writer
 * 2.�����������Ƿ��Ǵ��ı�
 * 		�ǣ��ַ���
 * 		���ֽ���
 * 3.����ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
 * 		ͨ���豸�����֣�
 * 		�豸���ڴ棬Ӳ�̣�����
 * 		Ŀ���豸���ڴ棬Ӳ�̣�����̨
 * 
 * 
 * 1.��һ���ı��ļ��е����ݴ洢����һ���ļ��У������ļ�
 * 		Դ����Ϊ��Դ������ʹ�ö�ȡ����InputStream  Reader
 * 			�ǲ��ǲ����ı��ļ���
 * 		��-��ѡ��Reader
 * 		
 * 		����������ʹ����ϵ�е��Ǹ�����
 * 		��ȷ�豸��Ӳ�̡���һ���ļ�
 * 		Reader��ϵ�п��Բ����ļ��Ķ�����FileReader
 * 
 * 		Ŀ�ģ�OutputStream Writer
 * 		�Ƿ��Ǵ��ı���
 * 		��-��
 * 
 * 
 * */



public class TransStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		/*
		//��ȡ����¼�����
		InputStream in=System.in;
		//���ֽ�������ת�����ַ�������ʹ��ת����InputStreamReader
		InputStreamReader isr=new InputStreamReader(in);
		//Ϊ�����Ч�ʣ����ַ������л�����������߲���,ʹ��BufferedReader
		BufferedReader bufr=new BufferedReader(isr);
		*/
		
//		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader bufr=new BufferedReader(new InputStreamReader(new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\IODemo\\buf.txt")));
		//���Ǽ���¼���ͨ�÷�ʽ�����Ա����ס
		
		/*
		OutputStream out=System.out;
		OutputStreamWriter osw=new OutputStreamWriter(out);
		BufferedWriter bufw=new BufferedWriter(osw);
		*/
		BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(System.out));
//		BufferedWriter bufw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy.txt")));//��ʱ�ļ��ͳ�Ϊ��Ŀ��
		//���Ŀ��Դ������ļ�
		String line=null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
//			System.out.println(line.toUpperCase());
//			osw.write(line.toUpperCase()+"\r\n");  ����ʹ�û��в�����ƽ̨����ֲ��  ��newLine������BufferedWriter�еģ�����Ҫ��OutputStreamWriter���а�װ
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();//�ַ������л�����������Ҫͨ��flush���ͷ�
		}
		bufr.close();
	}
	public static void InputStreamReaderFunction()throws IOException
	{
		
	}
	public static void OutputStreamWriterFunction()throws IOException
	{
		
		
		
	}

}
