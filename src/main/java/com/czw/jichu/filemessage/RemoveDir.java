package com.czw.jichu.filemessage;

import java.io.File;

/*ɾ��Ŀ¼�����е��ļ���
 * 
 * java��ɾ�����߻���վ�������޷�ɾ�������ļ���������ɾ��ǰ�ж�isHidden()
 * 
 * ��windows��ɾ��Ŀ¼�Ǵ�������ɾ
 * 					��Ҫ�õ�   �ݹ�
 * */
public class RemoveDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir=new File("d:\\fuck");
		removeDir(dir);
	}
	public static void removeDir(File dir)
	{
		File[] files =dir.listFiles();
		for(File file:files)
		{
			if(file.isDirectory())
				removeDir(file);
			else
				System.out.println(file.toString()+":-file-:"+file.delete());//ͬ�£�toString���Բ���
		}
		System.out.println(dir+"::dir::"+dir.delete());//��ӡ������ļ���ɾ�����ξͷ���false
	}

}
