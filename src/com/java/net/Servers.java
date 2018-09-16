package com.java.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servers {
	
	/**
	 * 服务器端，基于TCP通信
	 */
	
	private static ExecutorService service;
	
	public static void main(String[] args) {

		//线程池
		service = Executors.newCachedThreadPool();
		
		int count = 1;
		try {
			// 1 创建一个ServerSocket
			ServerSocket mServerSocket = new ServerSocket(8080);
			System.out.println("服务器开启,客户端链接...");
			while (true) {
				// 2 监听客服端连接状态
				Socket mSocket = mServerSocket.accept();
				// 3 获取客户端的请求数据,添加客服端线程到线程池中，方便统一管理
				service.execute(new ServerManager(mSocket));
				System.out.println("客户端"+count+"连接成功");
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
