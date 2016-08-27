package com.czw.util;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZeviChen
 * @Date 2016-08-02 15:38:17
 */
public class ComUtils {
	private static long startTime = 0;
	private static long endTime = 0;
	private static boolean flag = false;

	private static Logger log = LoggerFactory.getLogger(ComUtils.class);

	public static void start() {
		flag = true;
		System.out.println("--------------开始计时----------------");
		startTime = System.currentTimeMillis();
	}

	public static void end() {
		if (flag) {
			endTime = System.currentTimeMillis();
			long rtn = 0;
			if (startTime < 0)
				startTime = 0;
			if (endTime < 0)
				endTime = 0;
			rtn = endTime - startTime;
			if (rtn == endTime)
				rtn = 0;
			log.info("Spend Time:{}", endTime <= startTime ? 0 : rtn);
			System.out.println("--------------结束计时----------------");
		}
	}

	public static String getProjectPath(Class<?> clazz) {
		String path = clazz.getResource("/").getPath();
		// o: /D:/develop/workspace/base/target/test-classes/
		// o: /D:/develop/workspace/base/target/classes/
		// o: /D:/develop/workspace/base//WEB-INF/classes/

		String sep = "";
		if (path.contains("target/test-classes"))
			sep = "/target/test-classes";
		else if (path.contains("WEB-INF/classes"))
			sep = "/WEB-INF/classes";
		else if (path.contains("target/classes"))
			sep = "/target/classes";

		System.out.println("origin path: " + path);

		String rootPath = "";
		// windows下
		if ("\\".equals(File.separator)) {
			rootPath = path.substring(1, path.indexOf(sep));
			rootPath = rootPath.replace("/", "\\");
		}
		// linux下
		else if ("/".equals(File.separator)) {
			rootPath = path.substring(0, path.indexOf(sep));
			rootPath = rootPath.replace("\\", "/");
		}
		System.out.println("project path: " + rootPath);
		return rootPath;
	}

	/**
	 * <p>
	 * path ex:com.czw.toolkit.jackson
	 * <p>
	 * name ex:zoo.json
	 * <p>
	 * isMain when is true,set src.main.java path<br/>
	 * isMain when is false,set src.main.resources path<br/>
	 * @param clazz
	 * @param path
	 * @param name
	 * @return filepath String
	 */
	public static String setFilePath(Class<?> clazz, String path, String name,boolean isMain) {
		String rootPath = getProjectPath(clazz);
		String filePath = "";
		
		String javaPath = "src.main.java";
		String resPath = "src.main.resources";
		
		if(StringUtils.isBlank(path)){
			if(isMain)
				path = javaPath;
			else
				path = resPath;
		}else{
			if(isMain)
				path = javaPath+"."+path;
			else
				path =resPath+"."+path;
		}
		
		if ("\\".equals(File.separator)) {
			path = path.replace(".", "\\");
			filePath = rootPath + "\\" + path + "\\" + name;
		} else if ("/".equals(File.separator)) {
			path = path.replace(".", "/");
			filePath = rootPath + "/" + path + "/" + name;
		}
		System.out.println("filePath: " + filePath);
		return filePath;
	}

	
	//打印分割线
	//开始分割线printStartLine
	public static void ps(String title){
		String sepTitle = "======================"+title+"--start======================";
		System.out.println(calt(sepTitle));
	}
	//结束分割线printEndLine
	public static void pe(String title){
		String sepTitle = "======================"+title+"--end========================";
		System.out.println(calt(sepTitle));
	}
	
	private static String app = "=";
	private static int size = 60;
	private static StringBuilder sbLine = new StringBuilder();
	private static String calt(String line){
		sbLine.setLength(0);
		sbLine.append(line);
		int delta = size -line.length();
		System.out.println("差值是："+delta);
		int absValue = Math.abs(delta);
		
		System.out.println("绝对值："+absValue);
		boolean isEven = absValue%2==0?true:false;
		int a,b;
		if(isEven){
			a = absValue/2;
			b = a;
		}
		else{
			a = absValue/2;
			b = a+1;
		}
		System.out.println("a和b的值："+a+","+b);
		if(delta < 0){
			if(isEven){
				line = sbLine.substring(a, sbLine.length()-a);
			}
			else{
				line = sbLine.substring(a, sbLine.length()-a-1);
			}
		}
		else if(delta > 0){
			if(isEven){
				String ap = loopStr(app,a);
				System.out.println("ap值："+ap);
				sbLine.insert(0, ap);
				line = sbLine.append(ap).toString();
			}else{
				String ap = loopStr(app,a);
				String bp = loopStr(app,b);
				System.out.println("ap值："+ap);
				System.out.println("ap值："+bp);
				sbLine.insert(0, ap);
				line = sbLine.append(bp).toString();
			}
		}
		System.out.println("结果的长度: "+line.length());
		return line;
	}
	private static StringBuilder sb = new StringBuilder();
	private static String loopStr(String s,int num){
		sb.setLength(0);
		while(num>0){
			sb.append(s);
			num--;
		}
		return sb.toString();
	}
	
	
	
	public static void main(String[] args) {
////		getProjectPath(ComUtils.class);
//		String title = "今天天气真好";
//		String l = "======================="+title+"--start=======================";
//		System.out.println(l.length());
		System.out.println("======================创建Present实例--start======================".length());
		System.out.println("======================fewfew--end========================".length());
	}
	

}
