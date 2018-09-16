package com.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 * �������л��뷴���л�
 *
 */
public class ObjectIpsAndOpsDemo {

	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		File file = new File("object.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		System.out.println("1�������л�  2�������л�");
		int a = input.nextInt();

		if (a == 1) {
			// ���л�
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			Student stu = new Student("9527", "sanjay", 22);
			oos.writeObject(stu);
			System.out.println("�������л�д��ɹ�");
			oos.flush();
			oos.close();
		}

		if (a == 2) {
			// �����л�
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			try {
				Student stu = (Student) ois.readObject();
				System.out.println(stu);
				System.out.println("�������л���ȡ�ɹ�");
				ois.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}

class Student implements Serializable {

	private static final long serialVersionUID = -2392212781921755900L;
	private String code;
	private String name;
	private transient int age;// ��Ԫ�ز�����������Ĭ�ϵ����л�,Ҳ�����Լ�������Ԫ�ص����л�

	public Student(String code, String name, int age) {
		super();
		this.code = code;
		this.name = name;
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", age=" + age+ "]";
	}

	private void writeObject(java.io.ObjectOutputStream s)
			throws java.io.IOException {
		s.defaultWriteObject();// ���������Ĭ�����л���Ԫ�ؽ������л�����
		s.writeInt(age);// �Լ����age�����л�
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// ���������Ĭ�Ϸ����л���Ԫ�ؽ��з����л�����
		this.age = s.readInt();// �Լ����age�ķ����л�����
	}
}