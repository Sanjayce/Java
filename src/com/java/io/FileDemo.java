package com.java.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	
	public static void main(String[] args) {
		file();
	}
	/**
	 * ���õ�File�����API
	 */
	public static void file() {
		File file = new File("JavaIO.txt");
		// �ж��ļ��Ƿ����
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("�ļ������ɹ�!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//System.out.println("�ļ��Ѿ�����!");
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			//file.delete();
			//System.out.println("�ļ�ɾ���ɹ�!");
		}
	}
}
