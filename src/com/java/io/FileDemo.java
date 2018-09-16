package com.java.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	
	public static void main(String[] args) {
		file();
	}
	/**
	 * 常用的File对象的API
	 */
	public static void file() {
		File file = new File("JavaIO.txt");
		// 判断文件是否存在
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("文件创建成功!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//System.out.println("文件已经存在!");
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			//file.delete();
			//System.out.println("文件删除成功!");
		}
	}
}
