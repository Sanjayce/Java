package com.java.design;


/**
 * �����ڲ��൥��ģʽ
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
		System.out.println("�����ڲ��൥��ģʽ!");
	}
}
