package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	/**
	 * 客户端
	 */
	public static void main(String[] args) throws IOException {
		/**
		 * 向服务器发送请求
		 */
		DatagramSocket mSocket = new DatagramSocket();
		
		// 1 设置发送服务器地址，端口，以及要发送的数据
		InetAddress mAddress = InetAddress.getLocalHost();
		int port = 8080;
		byte[] buf = "用户名：asds 密码：1234".getBytes();
		// 2 创建DatagramPacket,用来保存发送的各消息
		DatagramPacket mPacket = new DatagramPacket(buf, buf.length, mAddress,port);
		// 3向服务器发送请求
		mSocket.send(mPacket);
		
		/**
		 * 接收服务器的响应
		 */
		// 1 创建数据报用于接收数据
		byte[] buf2 = new byte[1024];
		DatagramPacket mPacket2 = new DatagramPacket(buf2, buf2.length);
		// 2 接收客户端发来的数据
		mSocket.receive(mPacket2);// 此方法会阻塞线程
		// 3 读取接收的数据
		String info = new String(buf2, 0, mPacket2.getLength());
		System.out.println("客户端->" + info);
		
		/**
		 * 关闭向服务器的发送
		 */
		mSocket.close();

	}

}
