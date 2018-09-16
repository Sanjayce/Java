package com.java.thread;

public class RunnableTest {

	/**
	 * java多线程调用Runnable接口类
	 */
	public static void main(String[] args) {
		MyThread2 mt2 = new MyThread2();
		Thread t = new Thread(mt2, "子线程1");
		Thread t2 = new Thread(mt2, "子线程2");
		t.start();
		try {
			Thread.sleep(2000);
			t2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
class MyThread2 implements Runnable{

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