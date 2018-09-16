package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
	
	private static ExecutorService service;

	public static void main(String[] args) {
		int count = 1;
		//����һ���̳߳�
		service = Executors.newCachedThreadPool();
		System.out.println(service.toString());
		//����һ���̴߳�С���̳߳�
		//service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*50);
		while(count<100){
			service.execute(new MyRunnable());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
		System.out.println(service.toString());
		service.shutdown();
		System.out.println("�̳߳عر�!");

	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("�߳̿���....");
	}
}
