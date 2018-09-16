package com.java.thread;

public class Alives {

	
	/**
	 * 判断线程是否还活着
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadas mt = new MyThreadas();

		Thread t = new Thread(mt, "线程");
		System.out.println("线程开始执行之前-->" + t.isAlive());
		t.start();

		System.out.println("线程开始执行之后-->" + t.isAlive());
		for (int i = 0; i < 3; i++) {
			System.out.println("main-->" + i);
		}

		System.out.println("代码执行之后-->" + t.isAlive());

	}

}

class MyThreadas implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 3; i++) {
			System.out.println("线程 i="+i);
		}
	}

}
