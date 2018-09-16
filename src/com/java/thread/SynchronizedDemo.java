package com.java.thread;

public class SynchronizedDemo {

	/**
	 * Synchronized实现线程可见性和同步
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
		System.out.println("result值为:"+result);
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
