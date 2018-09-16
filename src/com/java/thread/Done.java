package com.java.thread;

public class Done {

	/**
	 *终止线程
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyThreas mt = new MyThreas();
		Thread t = new Thread(mt);
		t.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.interrupt();//终止线程
	}

}


class MyThreas implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("1 进入run()方法");
		try {
			Thread.sleep(3000);
			System.out.println("2 已经完成了休眠");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("3 休眠被终止");
			return;
		}
	}
	
}