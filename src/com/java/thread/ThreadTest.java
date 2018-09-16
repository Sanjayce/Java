package com.java.thread;

public class ThreadTest {

	/**
	 * java多线程继承Thread抽象类
	 */
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.setName("子线程");
		mt.start();
	}

}
class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 1; i <=100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->当前进度"+i+"%");
		}
	}
}
