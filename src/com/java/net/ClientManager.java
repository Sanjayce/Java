package com.java.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientManager extends Thread{
	
	private Socket mSocket;
	
	@Override
	public void run() {
		try {
			// 1创建Socket对像
		    mSocket = new Socket("127.0.0.1",8080);
			// 2向服务器发送请求
			OutputStream mOutStream = mSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(mOutStream);
			dos.writeUTF("请求连接");
			dos.flush();
			// 3 获取服务器响应请求的数据
			InputStream mInputStream = mSocket.getInputStream();
			DataInputStream dis = new DataInputStream(mInputStream);
			String line = dis.readUTF();
			System.out.println("客户端:"+line);
			//4关闭流操作
			dis.close();
			mInputStream.close();
			dos.close();
			mOutStream.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
