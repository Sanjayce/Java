package com.java.thread;

public class ThreadTest {

	/**
	 * java���̼̳߳�Thread������
	 */
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.setName("���߳�");
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
			System.out.println(Thread.currentThread().getName()+"-->��ǰ����"+i+"%");
		}
	}
}
