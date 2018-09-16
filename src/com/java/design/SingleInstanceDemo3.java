package com.java.design;


/**
 * 匿名内部类单例模式
 * @author lenovo
 *
 */

public class SingleInstanceDemo3 {
	
	private SingleInstanceDemo3(){
	}
	
	public static class SingleInstance{
		private static SingleInstanceDemo3 instance = new SingleInstanceDemo3();
		public static SingleInstanceDemo3 getInstance(){
			return instance;
		}
	}
	
	public void function(){
		System.out.println("匿名内部类单例模式!");
	}
}
