package com.java.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servers {
	
	/**
	 * �������ˣ�����TCPͨ��
	 */
	
	private static ExecutorService service;
	
	public static void main(String[] args) {

		//�̳߳�
		service = Executors.newCachedThreadPool();
		
		int count = 1;
		try {
			// 1 ����һ��ServerSocket
			ServerSocket mServerSocket = new ServerSocket(8080);
			System.out.println("����������,�ͻ�������...");
			while (true) {
				// 2 �����ͷ�������״̬
				Socket mSocket = mServerSocket.accept();
				// 3 ��ȡ�ͻ��˵���������,��ӿͷ����̵߳��̳߳��У�����ͳһ����
				service.execute(new ServerManager(mSocket));
				System.out.println("�ͻ���"+count+"���ӳɹ�");
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
