package com.java.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			// 以单字节读取文件
			IOUtil.printHex("JavaIO.txt");
			// 通过批量方式来读取文件
			IOUtil.printHexByByte("JavaIO.txt");
			//通过输入流和输出流来拷贝文件
			IOUtil.copeFile(new File("JavaIO.txt"), new File("JavaIO1.txt"));
			// 通过Buffered缓冲流来拷贝文件
			IOUtil.copeBuffer(new File("JavaIO.txt"), new File("JavaIO3.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
