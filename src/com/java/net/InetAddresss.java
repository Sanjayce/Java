package com.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddresss {

	/**
	 * InetAddress类
	 */
	public static void main(String[] args) {

		try {
			// 获取本机名和地址
			InetAddress address = InetAddress.getLocalHost();// 获取本机属性
			System.out.println(address);
			System.out.println("****************************");
			
			String name = address.getHostName();// 获取本机名
			String ip = address.getHostAddress();// 获取本机地址
			System.out.println("本机名：" + name + "\n" + "本机地址：" + ip );
			System.out.println("****************************");
			
			// 通过本机地址获取本机名
			InetAddress address2 = InetAddress.getByName(name);
			String name2 = address2.getHostName();
			System.out.println("本机名：" + name2);
			System.out.println("****************************");
			
			// 通过本机名获取本机地址
			InetAddress address3 = InetAddress.getByName(ip);
			String ip3 = address3.getHostAddress();
			System.out.println("本机地址：" + ip3);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
