package com.java.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerManager implements Runnable {

	Socket mSocket;

	public ServerManager(Socket socket) {
		this.mSocket = socket;
	}

	@Override
	public void run() {

		try {
			// 1获取客户端的请求数据
			InputStream mInputStream = mSocket.getInputStream();
			DataInputStream dis = new DataInputStream(mInputStream);
			String line = dis.readUTF();
			System.out.println("服务器:"+line);
			// 2响应客户端请求
			OutputStream mOutStream = mSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(mOutStream);
			dos.writeUTF("请求连接成功!");
			dos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
