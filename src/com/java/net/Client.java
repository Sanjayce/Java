package com.java.net;

public class Client {
	private static ClientManager mClient;

	public static void main(String[] args) {
		mClient = new ClientManager();
		mClient.start();
	}
}
