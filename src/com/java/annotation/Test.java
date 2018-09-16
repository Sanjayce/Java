package com.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ʹ��java������ƣ�����ע��
 */
public class Test {
	@SuppressWarnings({ "all" })
	public static void main(String[] args) {

		try {
			Class mClass = Class.forName("com.xl.annotation.Bean");
			//��ȡ���ע��
			Annotation[] annotation = mClass.getAnnotations();
			System.out.println(annotation.length);
			DivAnnotation div = (DivAnnotation)mClass.getAnnotation(DivAnnotation.class);
			System.out.println(div.value());
			
			//��ȡ���Ե�ע��
			Field[] df =  mClass.getDeclaredFields();
			System.out.println(df.length);
			Field df2 = mClass.getDeclaredField("id");
			DivAnnotation2 div2 = (DivAnnotation2)df2.getAnnotation(DivAnnotation2.class);
			System.out.println(div2.fieldName()+"/"+div2.type()+"/"+div2.lengh());
			
			//��ȡ����ע��
			Method[]  methods = mClass.getDeclaredMethods();
			System.out.println(methods.length);
			Method  method = mClass.getDeclaredMethod("toMothrd", null);//����������������
			DivAnnotation3 div3 = (DivAnnotation3)method.getAnnotation(DivAnnotation3.class);
			System.out.println(div3.type());
		} catch (Exception e) {
			e.printStackTrace();
		};
	}

}
