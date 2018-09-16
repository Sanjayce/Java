package com.java.refiection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Refiection {

	@SuppressWarnings("all")
	public static void main(String[] args) {

		String path = "com.xl.bean.Bean";
		try {
			Class<?> mClass = Class.forName(path);
			//获取反射类的类信息
			System.out.println(mClass.getName());//包名+类名
			System.out.println(mClass.getSimpleName());//类名
			System.out.println("*********************");
			//获取反射类的构造函数
			Constructor[] constructors = mClass.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.print(constructor.getName()+" ");
			}
			System.out.println();
			Constructor constructor = mClass.getDeclaredConstructor(null);
			System.out.println(constructor.getName());
			System.out.println("*********************");
			//获取反射类的属性
			Field[] fieids = mClass.getDeclaredFields();
			for (Field field : fieids) {
				System.out.print(field.getName()+" ");
			}
			System.out.println();
			Field fieid = mClass.getDeclaredField("name");
			System.out.println(fieid.getName());
			System.out.println("*********************");

			//获取反射类的方法
			Method[] methods =  mClass.getDeclaredMethods();
			for (Method method : methods) {
				System.out.print(method.getName()+" ");
			}
			System.out.println();
			Method method = mClass.getDeclaredMethod("setId", int.class);
			System.out.println(method.getName());
			System.out.println("*********************");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
