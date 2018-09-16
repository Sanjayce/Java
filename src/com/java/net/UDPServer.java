package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	/**
	 * 服务端，基于UDP
	 */

	public static void main(String[] args) throws IOException {

		/**
		 * 接收客户端发送的请求
		 */
		// 1 创建一个DatagramSocket对象，并指定端口号
		DatagramSocket mSocket = new DatagramSocket(8080);
		System.out.println("*****服务器开启，等待客户端*****");
		while (true) {
			// 2 创建数据报用于接收数据
			byte[] buf = new byte[1024];
			DatagramPacket mPacket = new DatagramPacket(buf, buf.length);
			// 3 接收客户端发来的数据
			mSocket.receive(mPacket);// 此方法会阻塞线程
			// 4 读取接收的数据
			String info = new String(buf, 0, mPacket.getLength());
			System.out.println("服务器->" + info);
			
			UDPThread thread = new UDPThread(mSocket, mPacket);
			thread.start();
		}

	}
}
