package com.java.object;

import java.util.Scanner;

public class JavaBasic {
	
	/**
	 * 私有的全局成员变量
	 */
	private  String name = "Sanjay";
	private int age = 20;
	private String sex = "Man";
	
	private static Scanner input = new Scanner(System.in);

	/**
	 * java开发知识一：变量，常量，关键字，循环语句，逻辑运算，赋值运算，字符串
	 * 函数，成员变量，静态变量
	 * @param args
	 */
	public static void main(String[] args) {
		JavaBasic jb1 = new JavaBasic();
		JavaBasic jb2 = new JavaBasic("***");
		JavaBasic jb3 = new JavaBasic("***",25,"***");
		fun1();
		jb1.fun2("i");
		jb2.fun2("love");
		jb3.fun2("java");
		fun3();
		fun4();
		fun5(input.nextInt());
		fun6();
	}
	
	/**
	 * 无参构造函数
	 */
	public JavaBasic(){
		System.out.println("无参构造函数!");
		System.out.println(name+"/"+age+"/"+sex);
	}
	
	/**
	 * 有参构造函数:可以时多个参数，参数类型为任意内型
	 */
	public JavaBasic(String str){
		System.out.println("有参构造函数:"+str);
	}
	
	public JavaBasic(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		System.out.println("有参构造函数:"+name+"/"+age+"/"+sex);
	}
	
	/**
	 * 静态无返回值函数
	 */
	public static void fun1(){
		System.out.println("静态无返回值函数");
	}
	
	/**
	 * 非静态有返回值函数
	 */
	public String fun2(String str){
		System.out.println(" 非静态有返回值函数:"+str);
		return str;
	}
	
	/**
	 * String
	 */
	public static void fun3(){
		String str = "mukewang@163.com";
		System.out.println(str.length());//获取字符串长度
		System.out.println(str.charAt(8));//获取指定位置字符串
		char[] data = str.toCharArray();//字符串转换为字符数组
		//变量数组
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		byte[] data2 = str.getBytes();//字符串转换为字节数组
		System.out.println(new String(data2));//字节数组换为字符串
		//判断指定字符的索引值
		if(str.indexOf("@")!=-1){
			System.out.println("合法邮箱");
		}else{
			System.out.println("非法邮箱");
		}
	}
	/**
	 * StringBuffer,StringBuider：String的包装类
	 */
	public static void fun4(){
		//线程安全，效率较低
		StringBuffer sbf = new StringBuffer();
		sbf.append("string ");
		sbf.insert(7, "buffer");
		System.out.println(sbf.toString());
		//线程不安全，效率较高
		StringBuilder sbu = new StringBuilder();
		sbu.append("string ");
		sbu.insert(7, "buider");
		System.out.println(sbu.toString());
	}
	
	/**
	 * 判断语句if...else
	 * @param date
	 */
	private static void fun5(int date){
		int count=0,scour=0;
		if (date<60) {
			while (date<60) {
				date++;
				count++;
			}
			System.out.println("增加次数:"+count);
			System.out.println("最终分数:"+date);
		}else {
			System.out.println(scour+":分，合格!");
		}
	}
	
	/**
	 * 嵌套for循环
	 */
	public static void fun6() {
		int sum = 0;
		double avg = 0;
		int classNum = 3;
		int scour = 0;
		
		for (int i = 1; i <= classNum; i++) {
			System.out.println("第" + i + "班");
			sum = 0;
			for (int j = 1; j <= classNum; j++) {
				System.out.println("第" + j + "位:");
				scour = input.nextInt();
				sum = sum + scour;
			}
			System.out.println("第" + i + "班，总和:" + sum);
			avg = sum / classNum;
			System.out.println("第" + i + "班，平均值:" + avg);
		}
		
	}
}
