package com.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.io.OutputStreamWriter;
/**
 * 1 д���ļ�����ȡ�ļ�  2 д������������ȡ������   3д������������ȡ������
 */
public class BufferedReaderAndBufferedWriterDemo {
	public static void main(String[] args) throws IOException {

		FileInputStream in = new FileInputStream("JavaIO.txt");
		InputStreamReader isr = new InputStreamReader(in);
		FileOutputStream out = new FileOutputStream("JavaIO2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out);
		
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(osw);
		
		//PrintWriter pw  = new PrintWriter("JavaIO2.txt");

		String c;
		while ((c = br.readLine()) != null) {
			System.out.println(c);
			bw.write(c);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();

	}

}
