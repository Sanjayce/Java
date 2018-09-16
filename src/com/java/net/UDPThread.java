package com.java.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 开启服务器多线程
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
			 * 响应客户端的请求
			 */
			// 1获取客户端请求时的地址，端口
			InetAddress mAddress = mPacket.getAddress();//通过数据报获取地址
			int port = mPacket.getPort();//通过数据报获取端口号
			byte[] buf2 = "*****登录成功,欢迎使用*****".getBytes();//将字符转换成字节
			// 2 创建DatagramPacket数据报,用来保存发送的各消息
			DatagramPacket mPacket2 = new DatagramPacket(buf2, buf2.length, mAddress, port);
			// 3响应客户端请求
			mSocket.send(mPacket2);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
