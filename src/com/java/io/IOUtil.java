package com.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * ��ȡָ���ļ����ݣ�����16�������������̨ ����ÿ���10��byte���� ���ֽڶ�ȡ���ʺϴ��ļ������ļ�Ч�ʺܵ�
	 */
	// ��16���Ƶ��ֽڶ�ȡ����
	public static void printHex(String fileName) throws IOException {
		// ����һ���ֽ�������
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int j = 1;
		while ((b = in.read()) != -1) {
			// ��16���Ƶ��ַ�����ʽ��ӡ�ֽ���
			System.out.print(Integer.toHexString(b) + "  ");
			// ÿ10���ֽ�������
			if (j++ % 10 == 0) {
				System.out.println();
			}
		}
		// �ر�IO������
		in.close();
	}

	/**
	 * ������ȡ���Դ��ļ�����Ч�ʸߣ�Ҳ��������õĶ��ļ��ķ�ʽ
	 */
	public static void printHexByByte(String fileName) throws IOException {
		// ����һ���ֽ�������
		FileInputStream in = new FileInputStream(fileName);
		// ����һ���ֽ�����,��СΪ8kb
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
	 * �ļ��������ֽ�������ȡ
	 */
	public static void copeFile(File oldFile, File newFile)throws IOException{
		//�ж��ļ�oldFile
		if(!oldFile.exists()){
			throw new IllegalArgumentException("�ļ�:"+oldFile+"������");
		}
		//�ж�oldFile�Ƿ����ļ�
		if(!oldFile.isFile()){
			throw new IllegalArgumentException(oldFile+"�����ļ�");
		}
		//���������������������
		FileInputStream in = new FileInputStream(oldFile);
		FileOutputStream out = new FileOutputStream(newFile);
		//����һ���ֽ����鲢ָ����С
		byte[] buf = new byte[8*1024];
		int b ;
	    while((b = in.read(buf,0,buf.length))!=-1){
	    	out.write(buf,0,b);
	    	out.flush();//��ü���
	    }
	    in.close();
	    out.close();
	}
	/**
	 * �ļ��������Ի������ֽ�������ȡ
	 */
	public static void copeBuffer(File oldFile, File newFile)throws IOException{
		//�ж��ļ�oldFile
		if(!oldFile.exists()){
			throw new IllegalArgumentException("�ļ�:"+oldFile+"������");
		}
		//�ж�oldFile�Ƿ����ļ�
		if(!oldFile.isFile()){
			throw new IllegalArgumentException(oldFile+"�����ļ�");
		}
		//���������������������
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(oldFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile));
		//����һ���ֽ����鲢ָ����С
		byte[] buf = new byte[8*1024];
		int b ;
	    while((b = in.read(buf,0,buf.length))!=-1){
	    	out.write(buf,0,b);
	    	out.flush();//��ü���
	    }
	    in.close();
	    out.close();
	}
}
