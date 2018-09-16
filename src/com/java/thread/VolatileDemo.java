package com.java.thread;

public class VolatileDemo {

	private volatile int number=0;//volatile保证number值改变时的可见性

	public int getNumber() {

		return this.number;
	}

	public synchronized void fun() {

		this.number++;//synchronized即可保证number值改变时的可见性，也可保证number++后的同步性
	}

	public static void main(String[] args) {
		final VolatileDemo vd = new VolatileDemo();
		for (int i = 1; i <= 500; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					vd.fun();
				}
			}).start();
		}

		// 返回当前线程的线程组中活动线程的数目
		while (Thread.activeCount() > 1) {
			Thread.yield();// 让主线程让出内存资源，使子线程运行
		}
		System.out.println(vd.getNumber());
	}

}
