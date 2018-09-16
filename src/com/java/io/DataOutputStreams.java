package com.java.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreams {
	// 写入数据
	public static void DoS(String file) throws IOException {
		
		File mFile = new File(file);
		if (!mFile.exists()) {
			mFile.createNewFile();
		}else {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
			// 采用int编码写出
			dos.writeInt(10);
			// 采用long编码写出
			dos.writeLong(999);
			// 采用double编码写出
			dos.writeDouble(0.12);
			// 采用utf-8编码写出
			dos.writeUTF("中国");
			// 采用utf-16编码写出
			dos.writeChars("美国");
			dos.close();
		}

	}

}
