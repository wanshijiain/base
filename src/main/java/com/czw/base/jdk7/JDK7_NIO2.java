package com.czw.base.jdk7;

import com.czw.util.ComUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 官方文档：http://docs.oracle.com/javase/tutorial/essential/io/file.html
 * 可以读取zip和jar文件：http://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html
 * 
 * @author ZeviChen
 * @Date 2016-09-14 15:02:14
 */
public class JDK7_NIO2 {

	/**
	 * Paths调用的是FileSystems类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Path path = Paths.get(ComUtils.getFilePath("com.czw.base.jdk7", "", true), "Features.md");
		// tReadAllBytes(path);
		tNewBufferedReader(path);
	}

	/**
	 * nio file reader
	 * 
	 * @param path
	 */
	public static void tReadAllBytes(Path path) {
		try {
			byte[] fileArray = Files.readAllBytes(path);
			System.out.println(fileArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void tNewBufferedReader(Path path) {
		Charset charset = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	public static void tInputStream(Path path) {
		try (InputStream in = Files.newInputStream(path);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.println(x);
		}
	}

}
