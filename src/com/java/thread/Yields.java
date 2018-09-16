package com.java.thread;

public class Yields {

	/**
	 * 礼让   让其他线程先执行
	 *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadsds mt =  new MyThreadsds();
		
		Thread t1   = new Thread(mt,"线程A");
		Thread t2   = new Thread(mt,"线程B");
		
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
				System.out.println("线程礼让开始....");
				Thread.currentThread().yield();
			}
			
		}
	}
	
}
