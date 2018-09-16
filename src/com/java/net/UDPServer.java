package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	/**
	 * ����ˣ�����UDP
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * ���տͻ��˷��͵�����
		 */
		// 1 ����һ��DatagramSocket���󣬲�ָ���˿ں�
		DatagramSocket mSocket = new DatagramSocket(8080);
		System.out.println("*****�������������ȴ��ͻ���*****");
		while (true) {
			// 2 �������ݱ����ڽ�������
			byte[] buf = new byte[1024];
			DatagramPacket mPacket = new DatagramPacket(buf, buf.length);
			// 3 ���տͻ��˷���������
			mSocket.receive(mPacket);// �˷����������߳�
			// 4 ��ȡ���յ�����
			String info = new String(buf, 0, mPacket.getLength());
			System.out.println("������->" + info);
			
			UDPThread thread = new UDPThread(mSocket, mPacket);
			thread.start();
		}

	}
}
