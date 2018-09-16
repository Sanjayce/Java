package com.java.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreams {
	// ��ȡ����
	public static void DIS(String file) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		// ����int���Ͷ�ȡ
		int i = dis.readInt();
		System.out.println(i);
		// ����long���Ͷ�ȡ
		long l = dis.readLong();
		System.out.println(l);
		// ����double���Ͷ�ȡ
		double d = dis.readDouble();
		System.out.println(d);
		// ����UTF-8�������Ͷ�ȡ
		String s = dis.readUTF();
		System.out.println(s);
		// ����char���Ͷ�ȡ
		char c1 = dis.readChar();
		char c2 = dis.readChar();
		System.out.println(c1+""+c2);
		dis.close();
	}
}
