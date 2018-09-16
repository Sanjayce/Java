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
			//��ȡ�����������Ϣ
			System.out.println(mClass.getName());//����+����
			System.out.println(mClass.getSimpleName());//����
			System.out.println("*********************");
			//��ȡ������Ĺ��캯��
			Constructor[] constructors = mClass.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				System.out.print(constructor.getName()+" ");
			}
			System.out.println();
			Constructor constructor = mClass.getDeclaredConstructor(null);
			System.out.println(constructor.getName());
			System.out.println("*********************");
			//��ȡ�����������
			Field[] fieids = mClass.getDeclaredFields();
			for (Field field : fieids) {
				System.out.print(field.getName()+" ");
			}
			System.out.println();
			Field fieid = mClass.getDeclaredField("name");
			System.out.println(fieid.getName());
			System.out.println("*********************");

			//��ȡ������ķ���
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
