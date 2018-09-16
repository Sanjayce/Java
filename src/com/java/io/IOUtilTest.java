package com.java.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			// �Ե��ֽڶ�ȡ�ļ�
			IOUtil.printHex("JavaIO.txt");
			// ͨ��������ʽ����ȡ�ļ�
			IOUtil.printHexByByte("JavaIO.txt");
			//ͨ����������������������ļ�
			IOUtil.copeFile(new File("JavaIO.txt"), new File("JavaIO1.txt"));
			// ͨ��Buffered�������������ļ�
			IOUtil.copeBuffer(new File("JavaIO.txt"), new File("JavaIO3.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
