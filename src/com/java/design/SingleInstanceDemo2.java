package com.java.design;


/**
 * ��ͨ����ģʽ:����ʽ
 * @author lenovo
 *
 */

public class SingleInstanceDemo2 {
	
	private static SingleInstanceDemo2 instance;
	
	private SingleInstanceDemo2(){
	}
	
	public static synchronized SingleInstanceDemo2 getInstance(){
		if(instance == null){
			instance = new SingleInstanceDemo2();
		}
		return instance;
	}
	
	public void function(){
		System.out.println("��ͨ����ģʽ:����ʽ!");
	}
}
