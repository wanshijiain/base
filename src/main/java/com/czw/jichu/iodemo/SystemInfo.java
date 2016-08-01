package com.czw.jichu.iodemo;
import java.util.*;
import java.io.*;
public class SystemInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Properties prop=System.getProperties();
//		System.out.println(prop);
//		prop.list(System.out);
		prop.list(new PrintStream("systeminfo.txt"));
	}

}
