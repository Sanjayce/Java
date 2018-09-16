package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
	
	private static ExecutorService service;

	public static void main(String[] args) {
		int count = 1;
		//创建一个线程池
		service = Executors.newCachedThreadPool();
		System.out.println(service.toString());
		//创建一个线程大小的线程池
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
		System.out.println("线程池关闭!");

	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("线程开启....");
	}
}
