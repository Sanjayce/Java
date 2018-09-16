package com.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java File 读取与写入
 *
 */
public class FileReaderOrWriterDemo{
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("JavaIO.txt");
		FileWriter fw = new FileWriter("JavaIO2.txt");
		//批量字符读取
		char[] buffer = new char[8*1024];
		//返回读到的字符个数
		int c;
		while((c = fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer, 0, c);
			System.out.println("写入成功!");
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
