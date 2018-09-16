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
			// 1����Socket����
		    mSocket = new Socket("127.0.0.1",8080);
			// 2���������������
			OutputStream mOutStream = mSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(mOutStream);
			dos.writeUTF("��������");
			dos.flush();
			// 3 ��ȡ��������Ӧ���������
			InputStream mInputStream = mSocket.getInputStream();
			DataInputStream dis = new DataInputStream(mInputStream);
			String line = dis.readUTF();
			System.out.println("�ͻ���:"+line);
			//4�ر�������
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
