package com.java.design;


/**
 * 普通单例模式:懒汉式
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
		System.out.println("普通单例模式:懒汉式!");
	}
}
