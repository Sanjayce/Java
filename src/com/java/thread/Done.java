package com.java.thread;

public class Done {

	/**
	 *��ֹ�߳�
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
		t.interrupt();//��ֹ�߳�
	}

}


class MyThreas implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("1 ����run()����");
		try {
			Thread.sleep(3000);
			System.out.println("2 �Ѿ����������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("3 ���߱���ֹ");
			return;
		}
	}
	
}