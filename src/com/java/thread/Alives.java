package com.java.thread;

public class Alives {

	
	/**
	 * �ж��߳��Ƿ񻹻���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadas mt = new MyThreadas();

		Thread t = new Thread(mt, "�߳�");
		System.out.println("�߳̿�ʼִ��֮ǰ-->" + t.isAlive());
		t.start();

		System.out.println("�߳̿�ʼִ��֮��-->" + t.isAlive());
		for (int i = 0; i < 3; i++) {
			System.out.println("main-->" + i);
		}

		System.out.println("����ִ��֮��-->" + t.isAlive());

	}

}

class MyThreadas implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 3; i++) {
			System.out.println("�߳� i="+i);
		}
	}

}
