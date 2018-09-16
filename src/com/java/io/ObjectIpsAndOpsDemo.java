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
 * 对象序列化与反序列化
 *
 */
public class ObjectIpsAndOpsDemo {

	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		File file = new File("object.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		System.out.println("1对象序列化  2对象反序列化");
		int a = input.nextInt();

		if (a == 1) {
			// 序列化
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			Student stu = new Student("9527", "sanjay", 22);
			oos.writeObject(stu);
			System.out.println("对象序列化写入成功");
			oos.flush();
			oos.close();
		}

		if (a == 2) {
			// 反序列化
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			try {
				Student stu = (Student) ois.readObject();
				System.out.println(stu);
				System.out.println("对象反序列化读取成功");
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
	private transient int age;// 该元素不会进行虚拟机默认的序列化,也可以自己完成这个元素的序列化

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
		s.defaultWriteObject();// 把虚拟机能默认序列化的元素进行序列化操作
		s.writeInt(age);// 自己完成age的序列化
	}

	private void readObject(java.io.ObjectInputStream s)
			throws java.io.IOException, ClassNotFoundException {
		s.defaultReadObject();// 把虚拟机能默认反序列化的元素进行反序列化操作
		this.age = s.readInt();// 自己完成age的反序列化操作
	}
}