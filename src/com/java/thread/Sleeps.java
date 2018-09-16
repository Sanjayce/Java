package com.java.thread;

public class Sleeps {

	/**
	 *ÐÝÃß
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyT mt = new MyT();
		Thread t = new Thread(mt, "line");
		t.start();
	}

}

class MyT implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()+i);
		}
	}

}
