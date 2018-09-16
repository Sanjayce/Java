package com.java.thread;

public class ThreadVSRunnableTest {

	/**
	 * 题目要求：模拟火车站窗口买票，一共5张,比较Thread和Runnable的区别
	 */
	public static void main(String[] args) {
		/**
		 * Thread  每过窗口各卖5张 （Thread的单继承原因）
		 */
		 Fun1 f1 = new Fun1();
		 Fun1 f2 = new Fun1();
		 Fun1 f3 = new Fun1();
		 f1.setName("Thread窗口一");
		 f2.setName("Thread窗口二");
		 f3.setName("Thread窗口三");
		 f1.start();
		 f2.start();
		 f3.start();
		/**
		 *  Runnable  所有窗口共买5张 （Runnable的多线程共享同意一变量）
		 */
		Fun2 f4 = new Fun2();
		Thread t1 = new Thread(f4, "Runnable窗口一");
		Thread t2 = new Thread(f4, "Runnable窗口二");
		Thread t3 = new Thread(f4, "Runnable窗口三");
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
			System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩张票"+--tickte);
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
			System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩张票"+--tickte);
			}
		}
	}
}
