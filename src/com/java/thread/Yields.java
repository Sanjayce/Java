package com.java.thread;

public class Yields {

	/**
	 * ����   �������߳���ִ��
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadsds mt =  new MyThreadsds();
		
		Thread t1   = new Thread(mt,"�߳�A");
		Thread t2   = new Thread(mt,"�߳�B");
		
		t1.start();
		t2.start();
		
	}

}


class MyThreadsds implements Runnable{

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		for (int i = 0; i <5; i++) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			
			if(i == 2){
				System.out.println("�߳����ÿ�ʼ....");
				Thread.currentThread().yield();
			}
			
		}
	}
	
}
