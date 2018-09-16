package com.java.thread;

public class ThreadVSRunnableTest {

	/**
	 * ��ĿҪ��ģ���վ������Ʊ��һ��5��,�Ƚ�Thread��Runnable������
	 */
	public static void main(String[] args) {
		/**
		 * Thread  ÿ�����ڸ���5�� ��Thread�ĵ��̳�ԭ��
		 */
		 Fun1 f1 = new Fun1();
		 Fun1 f2 = new Fun1();
		 Fun1 f3 = new Fun1();
		 f1.setName("Thread����һ");
		 f2.setName("Thread���ڶ�");
		 f3.setName("Thread������");
		 f1.start();
		 f2.start();
		 f3.start();
		/**
		 *  Runnable  ���д��ڹ���5�� ��Runnable�Ķ��̹߳���ͬ��һ������
		 */
		Fun2 f4 = new Fun2();
		Thread t1 = new Thread(f4, "Runnable����һ");
		Thread t2 = new Thread(f4, "Runnable���ڶ�");
		Thread t3 = new Thread(f4, "Runnable������");
		t1.start();
		t2.start();
		t3.start();

	}

}

class Fun1 extends Thread {
	int tickte = 5;

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			if(tickte>0){
			System.out.println(Thread.currentThread().getName() + "����һ��Ʊ����ʣ��Ʊ"+--tickte);
			}
		}
	}
}

class Fun2 implements Runnable {
	int tickte = 5;

	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			if(tickte>0){
			System.out.println(Thread.currentThread().getName() + "����һ��Ʊ����ʣ��Ʊ"+--tickte);
			}
		}
	}
}
