package com.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * 读取指定文件内容，按照16进制输出到控制台 并且每输出10个byte换行 单字节读取不适合大文件，大文件效率很低
	 */
	// 以16进制单字节读取数据
	public static void printHex(String fileName) throws IOException {
		// 创建一个字节流对象
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int j = 1;
		while ((b = in.read()) != -1) {
			// 以16进制的字符串形式打印字节流
			System.out.print(Integer.toHexString(b) + "  ");
			// 每10个字节流换行
			if (j++ % 10 == 0) {
				System.out.println();
			}
		}
		// 关闭IO输入流
		in.close();
	}

	/**
	 * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
	 */
	public static void printHexByByte(String fileName) throws IOException {
		// 创建一个字节流对象
		FileInputStream in = new FileInputStream(fileName);
		// 创建一个字节数组,大小为8kb
		byte[] buf = new byte[8 * 1024];
		int bytes = 0;
		int j = 1;
		while ((bytes = in.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++) {
				System.out.print(Integer.toHexString(buf[j] & 0xff) + "  ");
				if (j++ % 10 == 0) {
					System.out.println();
				}
			}
		}
		in.close();
	}
	/**
	 * 文件拷贝，字节批量读取
	 */
	public static void copeFile(File oldFile, File newFile)throws IOException{
		//判断文件oldFile
		if(!oldFile.exists()){
			throw new IllegalArgumentException("文件:"+oldFile+"不存在");
		}
		//判断oldFile是否是文件
		if(!oldFile.isFile()){
			throw new IllegalArgumentException(oldFile+"不是文件");
		}
		//创建输入流和输出流对象
		FileInputStream in = new FileInputStream(oldFile);
		FileOutputStream out = new FileOutputStream(newFile);
		//创建一个字节数组并指定大小
		byte[] buf = new byte[8*1024];
		int b ;
	    while((b = in.read(buf,0,buf.length))!=-1){
	    	out.write(buf,0,b);
	    	out.flush();//最好加上
	    }
	    in.close();
	    out.close();
	}
	/**
	 * 文件拷贝，以缓冲流字节批量读取
	 */
	public static void copeBuffer(File oldFile, File newFile)throws IOException{
		//判断文件oldFile
		if(!oldFile.exists()){
			throw new IllegalArgumentException("文件:"+oldFile+"不存在");
		}
		//判断oldFile是否是文件
		if(!oldFile.isFile()){
			throw new IllegalArgumentException(oldFile+"不是文件");
		}
		//创建输入流和输出流对象
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(oldFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
		//创建一个字节数组并指定大小
		byte[] buf = new byte[8*1024];
		int b ;
	    while((b = in.read(buf,0,buf.length))!=-1){
	    	out.write(buf,0,b);
	    	out.flush();//最好加上
	    }
	    in.close();
	    out.close();
	}
}
