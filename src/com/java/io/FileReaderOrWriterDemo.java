package com.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java File ��ȡ��д��
 *
 */
public class FileReaderOrWriterDemo{
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("JavaIO.txt");
		FileWriter fw = new FileWriter("JavaIO2.txt");
		//�����ַ���ȡ
		char[] buffer = new char[8*1024];
		//���ض������ַ�����
		int c;
		while((c = fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer, 0, c);
			System.out.println("д��ɹ�!");
			fw.flush();
		}
		fr.close();
		fw.close();
	}

}
