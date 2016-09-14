package com.czw.base.others;

/**
 * @author ZeviChen
 * @Date 2016-09-14 15:27:03
 */
public final class FileSystems {

	private FileSystems() {
	}

	private static class DefaultFileSystemHolder {
		static final String defaultFileSystem = defaultFileSystem();

		private static String defaultFileSystem() {
			System.out.println("DefaultFileSystemHolder被初始化了");
			return "获得了静态内部类初始化信息";
		}
	}

	public static String getDefault() {
		System.out.println("getDefault");
		return DefaultFileSystemHolder.defaultFileSystem;
	}
	public static String get(){
		System.out.println("get");
		return "不调用任何静态内部类方法，不会初始化信息";
	}

}
