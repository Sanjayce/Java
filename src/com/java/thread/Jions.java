package com.java.thread;

public class Jions {

	/**
	 * ����ĳ�̵߳ĸ÷���������ǰ�߳�����̡߳��ϲ��������ȴ����߳̽������ڻָ���ǰ�̵߳����С�
	 */
	public static void main(String[] args) {

		MyTs mt = new MyTs();
		Thread t = new Thread(mt, "�߳�");
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

			System.out.println("main�߳�-->" + i);
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
