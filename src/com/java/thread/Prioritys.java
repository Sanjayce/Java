package com.java.thread;

public class Prioritys {

	/**
	 * �̵߳����ȼ���ֵ
	 */
	public static void main(String[] args) {
		
		
		
		System.out.println(Thread.currentThread().getPriority());
		
		
		
		
		Thread t1 = new Thread(new MyThreadsd(),"�߳�A");
		Thread t2 = new Thread(new MyThreadsd(),"�߳�B");
		Thread t3 = new Thread(new MyThreadsd(),"�߳�C");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}

class MyThreadsd implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i <5; i++) {
			
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			
		}
	}
	
}
