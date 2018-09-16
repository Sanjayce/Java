package com.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddresss {

	/**
	 * InetAddress��
	 */
	public static void main(String[] args) {

		try {
			// ��ȡ�������͵�ַ
			InetAddress address = InetAddress.getLocalHost();// ��ȡ��������
			System.out.println(address);
			System.out.println("****************************");
			
			String name = address.getHostName();// ��ȡ������
			String ip = address.getHostAddress();// ��ȡ������ַ
			System.out.println("��������" + name + "\n" + "������ַ��" + ip );
			System.out.println("****************************");
			
			// ͨ��������ַ��ȡ������
			InetAddress address2 = InetAddress.getByName(name);
			String name2 = address2.getHostName();
			System.out.println("��������" + name2);
			System.out.println("****************************");
			
			// ͨ����������ȡ������ַ
			InetAddress address3 = InetAddress.getByName(ip);
			String ip3 = address3.getHostAddress();
			System.out.println("������ַ��" + ip3);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
