package com.czw.util;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zevi Chan
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

	public static void main(String[] args) {
		getProjectPath(ComUtils.class);
	}

}
