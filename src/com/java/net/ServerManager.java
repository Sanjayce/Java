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
			// 1��ȡ�ͻ��˵���������
			InputStream mInputStream = mSocket.getInputStream();
			DataInputStream dis = new DataInputStream(mInputStream);
			String line = dis.readUTF();
			System.out.println("������:"+line);
			// 2��Ӧ�ͻ�������
			OutputStream mOutStream = mSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(mOutStream);
			dos.writeUTF("�������ӳɹ�!");
			dos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
