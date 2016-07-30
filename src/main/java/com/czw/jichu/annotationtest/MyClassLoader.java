package com.czw.jichu.annotationtest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//����༴��һ�����������Ҳ��һ�����ܳ���
//�а������಻�ܵ����ް�������

public class MyClassLoader extends ClassLoader{

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		String srcPath = args[0];
		String destDir = args[1];
		FileInputStream fis = new FileInputStream(srcPath);
		String destFileName = srcPath.substring(srcPath.lastIndexOf("\\")+1);
		String destPath = destDir + "\\" + destFileName;
		
		FileOutputStream fos = new FileOutputStream(destPath);
		cypher(fis,fos);
		fis.close();
		fos.close();
		
		
	}
	
	//ͨ�����������ļ�
	public static void cypher(InputStream is,OutputStream os)throws Exception{
		int b = -1;
		while((b = is.read())!=-1){
			os.write(b^0xff);  //�������͵õ�ԭ��������
		}
	}
	private String classDir;

	/*�Զ���ļ�������Ҫ���Ǹ����findClass()������*/
	@Override
	@SuppressWarnings("deprecation")
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String classFileName = classDir + "\\" + name + ".class";
		try {
			FileInputStream fis = new FileInputStream(classFileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			cypher(fis,bos);
			fis.close();
			byte[] buf =bos.toByteArray();
			return defineClass(buf, 0, buf.length);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return super.findClass(name);
	}
	public  MyClassLoader(){
		
	}
	public MyClassLoader(String classDir){
		this.classDir = classDir;
	}
}






