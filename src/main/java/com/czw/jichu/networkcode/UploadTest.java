package com.czw.jichu.networkcode;
/*
��Է������ļ��������ȷ����ļ����ͽ�����־���ж϶����Ƿ�����ļ������ظ��ļ�
���ļ���������ʹ�ӡ
*/
import java.net.*;
import java.io.*;
public class UploadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Socket s=new Socket("10.101.2.235",10007);
		
		File newfile=new File("E:\\JAVA\\��Ŀ\\Test\\src\\networkCode\\IPDemo.java");
		BufferedReader bufr=
				new BufferedReader(new FileReader(newfile));
		PrintWriter out=
				new PrintWriter(s.getOutputStream(),true);
		
		//���������������Ķ���,
//		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		//������־��һ��ʱ���,���ַ�ʽ�Ƚ��鷳���õ��˶���������
//		long time=System.currentTimeMillis();
		//out.println(time);
//		dos.write(time);
				
				
		String line=null;
		
		while((line=bufr.readLine())!=null)
		{
			 out.println(line);
		}
		
		s.shutdownOutput();
		//�رտͻ��˵����������൱�ڽ�����ǡ�
		
		//out.println("over");
		
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str=in.readLine();
		System.out.println(str);
		
		bufr.close();
		s.close();
		
	}

}
/*
 * �ļ������ʱ���Ȱ��ļ�������ȥ���ڽ���һ���ļ��ѽ�����Ҫ����ļ����ݱ��浽���ļ��¡�
 * ��������������ж�һ�������Ƿ�һ������һ������һ��  xx(2).��չ��   �����ļ�.
 * ����ļ�������ʱ�䴫���ȥ���Ͳ�������ظ���
 * */
class TestServer{
	public static void main(String [] args)throws Exception
	{
		ServerSocket ss=new ServerSocket(10007);
		Socket s=ss.accept();
		
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"connected...");
		
//		DataInputStream dis=new DataInputStream(s.getInputStream());
//		long time=dis.readLong();
		//����˵�Դ������������
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		File newfile=new File("E:\\JAVA\\��Ŀ\\Test\\src\\networkCode\\server.txt");
		newfile.createNewFile();
		PrintWriter out=new PrintWriter(new FileWriter(newfile),true);
		
		String line=null;
		while((line=in.readLine())!=null)
		{
//			if("over".equals(line))
//				break;
			out.println(line);
		}
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		pw.println("�ϴ��ɹ�");
		out.close();
		s.close();
		ss.close();
		
		
		
		
		
		
		
	}
}