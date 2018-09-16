package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	/**
	 * �ͻ���
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * ���������������
		 */
		DatagramSocket mSocket = new DatagramSocket();
		
		// 1 ���÷��ͷ�������ַ���˿ڣ��Լ�Ҫ���͵�����
		InetAddress mAddress = InetAddress.getLocalHost();
		int port = 8080;
		byte[] buf = "�û�����asds ���룺1234".getBytes();
		// 2 ����DatagramPacket,�������淢�͵ĸ���Ϣ
		DatagramPacket mPacket = new DatagramPacket(buf, buf.length, mAddress,port);
		// 3���������������
		mSocket.send(mPacket);
		
		/**
		 * ���շ���������Ӧ
		 */
		// 1 �������ݱ����ڽ�������
		byte[] buf2 = new byte[1024];
		DatagramPacket mPacket2 = new DatagramPacket(buf2, buf2.length);
		// 2 ���տͻ��˷���������
		mSocket.receive(mPacket2);// �˷����������߳�
		// 3 ��ȡ���յ�����
		String info = new String(buf2, 0, mPacket2.getLength());
		System.out.println("�ͻ���->" + info);
		
		/**
		 * �ر���������ķ���
		 */
		mSocket.close();

	}

}
