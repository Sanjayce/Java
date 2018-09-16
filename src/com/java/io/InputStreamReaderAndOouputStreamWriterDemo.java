package com.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderAndOouputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		// Ĭ����Ŀ�ı���,������ʱ��Ҫд�ļ�����ı����ʽ
		FileInputStream in = new FileInputStream("java.txt");
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		FileOutputStream out = new FileOutputStream("java.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		int c;
		char[] buffer = new char[8 * 1024];
		/*
		 * ������ȡ������buffer����ַ����飬�ӵ�0��λ�ÿ�ʼ���ã�����buffer.length�����ص��Ƕ������ַ��ĸ���
		 */
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			// д������
			osw.write(buffer, 0, c);
			// ˢ������
			osw.flush();
			String s = new String(buffer, 0, c);
			System.out.print(s);
		}
		// �ر�IO��
		isr.close();
		osw.close();

	}

}
