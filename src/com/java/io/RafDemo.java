package com.java.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafDemo {

	public static void main(String[] args) throws IOException {
		// �����ļ���
		File demo = new File("demo");
		if (!demo.exists())
			demo.mkdir();
		//�����ļ�
		File file = new File(demo, "raf.txt");
		if (!file.exists())
			file.createNewFile();
		// �����ļ��Ķ�д��ʽ���ɶ���д��
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// д�ļ�
		raf.writeUTF("ABC");
		// ���ļ��������ָ���Ƶ�ͷ��
		raf.seek(0);
		System.out.println(raf.readUTF());
		// �ر��ļ���д
		raf.close();
	}

}
