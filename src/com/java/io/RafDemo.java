package com.java.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafDemo {

	public static void main(String[] args) throws IOException {
		// 创建文件夹
		File demo = new File("demo");
		if (!demo.exists())
			demo.mkdir();
		//创建文件
		File file = new File(demo, "raf.txt");
		if (!file.exists())
			file.createNewFile();
		// 设置文件的读写方式（可读可写）
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// 写文件
		raf.writeUTF("ABC");
		// 读文件，必须把指针移到头部
		raf.seek(0);
		System.out.println(raf.readUTF());
		// 关闭文件读写
		raf.close();
	}

}
