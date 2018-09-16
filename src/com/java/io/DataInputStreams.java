package com.java.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreams {
	// 读取数据
	public static void DIS(String file) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		// 采用int类型读取
		int i = dis.readInt();
		System.out.println(i);
		// 采用long类型读取
		long l = dis.readLong();
		System.out.println(l);
		// 采用double类型读取
		double d = dis.readDouble();
		System.out.println(d);
		// 采用UTF-8编码类型读取
		String s = dis.readUTF();
		System.out.println(s);
		// 采用char类型读取
		char c1 = dis.readChar();
		char c2 = dis.readChar();
		System.out.println(c1+""+c2);
		dis.close();
	}
}
