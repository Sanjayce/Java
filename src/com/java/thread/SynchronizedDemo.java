package com.java.thread;

public class SynchronizedDemo {

	/**
	 * Synchronizedʵ���߳̿ɼ��Ժ�ͬ��
	 */
	public static void main(String[] args) {
		SynchronizedDemo sd = new SynchronizedDemo();
		sd.new ReadWriteThread(true).start();
		sd.new ReadWriteThread(false).start();

	}
	private int result =0;
	private int number =1;
	private boolean ready = false;
	
	/**
	 * 
	 */
	public synchronized void write(){
		ready = true;
		number = 2;
	}
	
	public synchronized void read(){
		if(ready){
			result = number*3;
		}
		System.out.println("resultֵΪ:"+result);
	}
	
	
	public class ReadWriteThread extends Thread{
		private boolean flag;
		
		public ReadWriteThread(boolean flag) {
			super();
			this.flag = flag;
		}

		@Override
		public void run() {
			if(flag){
				write();
			}else{
				read();
			}
			
		}
	}

}
