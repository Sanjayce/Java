package com.java.io;

import java.io.IOException;

public class DataOutputInputStreamMain {

	public static void main(String[] args) {

		String file = "dos.dat";
		try {
			DataOutputStreams.DoS(file);
			DataInputStreams.DIS(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
