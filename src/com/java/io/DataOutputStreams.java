package com.java.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreams {
	// д������
	public static void DoS(String file) throws IOException {
		
		File mFile = new File(file);
		if (!mFile.exists()) {
			mFile.createNewFile();
		}else {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
			// ����int����д��
			dos.writeInt(10);
			// ����long����д��
			dos.writeLong(999);
			// ����double����д��
			dos.writeDouble(0.12);
			// ����utf-8����д��
			dos.writeUTF("�й�");
			// ����utf-16����д��
			dos.writeChars("����");
			dos.close();
		}

	}

}
