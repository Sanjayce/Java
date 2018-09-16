package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * �������������߳�
 *
 */
public class UDPThread extends Thread {
	
	DatagramSocket mSocket;
	DatagramPacket mPacket;
	

	public UDPThread(DatagramSocket mSocket,DatagramPacket mPacket) {
		this.mSocket = mSocket;
		this.mPacket = mPacket;
	}


	@Override
	public void run() {

		try {
			/**
			 * ��Ӧ�ͻ��˵�����
			 */
			// 1��ȡ�ͻ�������ʱ�ĵ�ַ���˿�
			InetAddress mAddress = mPacket.getAddress();//ͨ�����ݱ���ȡ��ַ
			int port = mPacket.getPort();//ͨ�����ݱ���ȡ�˿ں�
			byte[] buf2 = "*****��¼�ɹ�,��ӭʹ��*****".getBytes();//���ַ�ת�����ֽ�
			// 2 ����DatagramPacket���ݱ�,�������淢�͵ĸ���Ϣ
			DatagramPacket mPacket2 = new DatagramPacket(buf2, buf2.length, mAddress, port);
			// 3��Ӧ�ͻ�������
			mSocket.send(mPacket2);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
