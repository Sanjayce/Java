package com.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderAndOouputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		// 默认项目的编码,操作的时候，要写文件本身的编码格式
		FileInputStream in = new FileInputStream("java.txt");
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		FileOutputStream out = new FileOutputStream("java.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		int c;
		char[] buffer = new char[8 * 1024];
		/*
		 * 批量读取，放入buffer这个字符数组，从第0个位置开始放置，最多放buffer.length个返回的是读到的字符的个数
		 */
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			// 写入数据
			osw.write(buffer, 0, c);
			// 刷新数据
			osw.flush();
			String s = new String(buffer, 0, c);
			System.out.print(s);
		}
		// 关闭IO流
		isr.close();
		osw.close();

	}

}
