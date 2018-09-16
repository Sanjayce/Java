package com.java.design;

public class MainClass {

	public static void main(String[] args) {
		SingleInstanceDemo1.getInstance().function();
		SingleInstanceDemo2.getInstance().function();
		SingleInstanceDemo3.SingleInstance.getInstance().function();
		SingleInstanceDemo4.INSTANCE.function();
	}

}
