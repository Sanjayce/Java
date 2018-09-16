package com.java.design;


/**
 * 普通单例模式:饿汉式
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
		System.out.println("普通单例模式:饿汉式!");
	}
}
