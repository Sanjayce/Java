package com.java.design;


/**
 * ��ͨ����ģʽ:����ʽ
 * @author lenovo
 *
 */

public class SingleInstanceDemo1 {
	
	private static SingleInstanceDemo1 instance = new SingleInstanceDemo1();
	
	private SingleInstanceDemo1(){
	}
	
	public static SingleInstanceDemo1 getInstance(){
		return instance;
	}
	
	public void function(){
		System.out.println("��ͨ����ģʽ:����ʽ!");
	}
}
