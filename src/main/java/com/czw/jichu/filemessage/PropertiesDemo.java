package com.czw.jichu.filemessage;

/*
 * Properties��hashtable�����࣬�ڲ��洢�Ķ����ַ���
 * 
 * Properties�ļ���ֻ���Ǽ�ֵ�Ե���ʽ��
 * 
 * �ı������һЩ������Ϣ�����洢�������´δ��������
 * �Զ�������Щ�Ѿ��ı��������Ϣ
 * 
 *  String getProperty(String key, String defaultValue)  
 *  void load(InputStream inStream) ����load(Reader r)
 *  
 * Enumeration<?> propertyNames() 
 * Set<String> stringPropertiesNames()
 * 
 *store("д����","ע����Ϣ")
 * 
 * */
import java.util.*;
import java.io.*;
public class PropertiesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
//		setAndGet();
//		method_1();
		loadDemo();
	}
	public static void loadDemo()throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\info.txt");
		//�����е����ݼ��ؽ�����
		prop.load(fis);
		
		prop.setProperty("wangwu", "39");
		FileOutputStream fos=new FileOutputStream("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\info.txt");
		prop.store(fos,"zhushixinxi");//#ע����Ϣ,����Ϣд������
		
		//ͨ�����ַ�ʽ�����ڴ����޸ĵ�����д���Ӧ�������ļ���
		
		
//		sop(prop);
		prop.list(System.out);//ͨ����ӡ����list��Ŀ�ģ��г�����Ŀ¼
		
		fis.close();
		fos.close();
		
	}
	
	
	/*
	 * ��ʾ����������е����ݴ洢�������С�
	 * 
	 * 1.��һ������info.txt�ļ�������
	 * 2.��ȡһ�����ݣ������������á�=�������и
	 * 3.�Ⱥ������Ϊ�����ұ���Ϊֵ�����뵽Properties�����м��ɡ�
	 * */
	public static void method_1()throws IOException
	{
		BufferedReader bufr=new BufferedReader(new FileReader("E:\\JAVA\\��Ŀ\\Test\\src\\filemessage\\info.txt"));
		String line=null;
		Properties prop=new Properties();
		while((line=bufr.readLine())!=null)
		{
			String[] arr=line.split("=");
//			sop(arr[0]+"..."+arr[1]);
			prop.setProperty(arr[0], arr[1]);
		}
		System.out.println(prop.size());
		bufr.close();
		
	}
	public static void setAndGet()
	{
		Properties prop=new Properties();
		prop.setProperty("zhangsan", "30");
		prop.setProperty("lisi", "20");
//		sop(prop);
		prop.setProperty("lisi", "50");
		Set<String> names=prop.stringPropertyNames();
		for(String key:names)
		{
			sop(key+"::"+prop.getProperty(key));//��ȡ����key+value
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
