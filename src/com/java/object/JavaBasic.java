package com.java.object;

import java.util.Scanner;

public class JavaBasic {
	
	/**
	 * ˽�е�ȫ�ֳ�Ա����
	 */
	private  String name = "Sanjay";
	private int age = 20;
	private String sex = "Man";
	
	private static Scanner input = new Scanner(System.in);

	/**
	 * java����֪ʶһ���������������ؼ��֣�ѭ����䣬�߼����㣬��ֵ���㣬�ַ���
	 * ��������Ա��������̬����
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
	 * �޲ι��캯��
	 */
	public JavaBasic(){
		System.out.println("�޲ι��캯��!");
		System.out.println(name+"/"+age+"/"+sex);
	}
	
	/**
	 * �вι��캯��:����ʱ�����������������Ϊ��������
	 */
	public JavaBasic(String str){
		System.out.println("�вι��캯��:"+str);
	}
	
	public JavaBasic(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		System.out.println("�вι��캯��:"+name+"/"+age+"/"+sex);
	}
	
	/**
	 * ��̬�޷���ֵ����
	 */
	public static void fun1(){
		System.out.println("��̬�޷���ֵ����");
	}
	
	/**
	 * �Ǿ�̬�з���ֵ����
	 */
	public String fun2(String str){
		System.out.println(" �Ǿ�̬�з���ֵ����:"+str);
		return str;
	}
	
	/**
	 * String
	 */
	public static void fun3(){
		String str = "mukewang@163.com";
		System.out.println(str.length());//��ȡ�ַ�������
		System.out.println(str.charAt(8));//��ȡָ��λ���ַ���
		char[] data = str.toCharArray();//�ַ���ת��Ϊ�ַ�����
		//��������
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		byte[] data2 = str.getBytes();//�ַ���ת��Ϊ�ֽ�����
		System.out.println(new String(data2));//�ֽ����黻Ϊ�ַ���
		//�ж�ָ���ַ�������ֵ
		if(str.indexOf("@")!=-1){
			System.out.println("�Ϸ�����");
		}else{
			System.out.println("�Ƿ�����");
		}
	}
	/**
	 * StringBuffer,StringBuider��String�İ�װ��
	 */
	public static void fun4(){
		//�̰߳�ȫ��Ч�ʽϵ�
		StringBuffer sbf = new StringBuffer();
		sbf.append("string ");
		sbf.insert(7, "buffer");
		System.out.println(sbf.toString());
		//�̲߳���ȫ��Ч�ʽϸ�
		StringBuilder sbu = new StringBuilder();
		sbu.append("string ");
		sbu.insert(7, "buider");
		System.out.println(sbu.toString());
	}
	
	/**
	 * �ж����if...else
	 * @param date
	 */
	private static void fun5(int date){
		int count=0,scour=0;
		if (date<60) {
			while (date<60) {
				date++;
				count++;
			}
			System.out.println("���Ӵ���:"+count);
			System.out.println("���շ���:"+date);
		}else {
			System.out.println(scour+":�֣��ϸ�!");
		}
	}
	
	/**
	 * Ƕ��forѭ��
	 */
	public static void fun6() {
		int sum = 0;
		double avg = 0;
		int classNum = 3;
		int scour = 0;
		
		for (int i = 1; i <= classNum; i++) {
			System.out.println("��" + i + "��");
			sum = 0;
			for (int j = 1; j <= classNum; j++) {
				System.out.println("��" + j + "λ:");
				scour = input.nextInt();
				sum = sum + scour;
			}
			System.out.println("��" + i + "�࣬�ܺ�:" + sum);
			avg = sum / classNum;
			System.out.println("��" + i + "�࣬ƽ��ֵ:" + avg);
		}
		
	}
}
