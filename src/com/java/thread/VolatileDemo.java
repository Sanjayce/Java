package com.java.thread;

public class VolatileDemo {

	private volatile int number=0;//volatile��֤numberֵ�ı�ʱ�Ŀɼ���

	public int getNumber() {

		return this.number;
	}

	public synchronized void fun() {

		this.number++;//synchronized���ɱ�֤numberֵ�ı�ʱ�Ŀɼ��ԣ�Ҳ�ɱ�֤number++���ͬ����
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

		// ���ص�ǰ�̵߳��߳����л�̵߳���Ŀ
		while (Thread.activeCount() > 1) {
			Thread.yield();// �����߳��ó��ڴ���Դ��ʹ���߳�����
		}
		System.out.println(vd.getNumber());
	}

}
