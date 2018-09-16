package com.java.thread;

public class Jions {

	/**
	 * 调用某线程的该方法，将当前线程与该线程“合并”，即等待该线程结束，在恢复当前线程的运行。
	 */
	public static void main(String[] args) {

		MyTs mt = new MyTs();
		Thread t = new Thread(mt, "线程");
		t.start();

		for (int i = 0; i <= 20; i++) {
			if (i > 10) {
				try {

					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("main线程-->" + i);
		}
	}
}

class MyTs implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}
	}

}
