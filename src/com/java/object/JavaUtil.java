package com.java.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * java开发知识三：包装类(Integer,String,boolean,Date,Calnder,DateForMat)，集合(list,set,map)，泛型<T>，数组
 * @param args
 */

public class JavaUtil {

	private static String[] name = new String[] { "A", "B", "C" };
	private static String[][] name1 = new String[][] { { "A1", "A2", "A3" },{ "B1", "B2", "B3" }, { "C1", "C2", "C3" } };


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		oneArray();
		twoArray();
		System.out.println(show("返回值泛型"));
		Demo demo1 = new Demo("构造泛型");
		System.out.println(demo1.getValue());
		Demo demo2 = new Demo(100);
		System.out.println(demo2.getValue());
		Demo4 demo4 = new Demo4("接口泛型");
		System.out.println(demo4.getInfo());
		//list
		ListTest list = new ListTest();
		list.testAdd();
		list.testGet();
		list.iterators();
		list.forEach();
		list.removeList();
		//set
		SetTest set = new SetTest();
		set.testAdd();
		set.testSet();
		//map
		MapTest map = new MapTest();
		map.testPut();
		map.testKeySet();
		map.testEntrySet();
		map.testMapContainsKeyOrValue();
	}
	//一维数组
	private static void oneArray(){
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i]);
		}
	}
	//二维数组
	private static void twoArray(){
		for (int i = 0; i < name1.length; i++) {
			for (int j = 0; j < name1.length; j++) {
				System.out.print(name1[i][j]);
			}
		}
		System.out.println();
	}
	//泛型
	private static <T>T show(T t){
		return t;
	}
}

/**
 * 
 *接口泛型
 * @param <T>
 */
interface Gen<T> {
	public void show();
}

class Demo4 implements Gen<String> {

	private String info;

	public Demo4(String infos) {
		this.info = infos;
	}

	public String getInfo() {
		return info;
	}

	@Override
	public void show() {
		
	}

}

/**
 * 构造函数泛型
 */
class Demo<T>{
	private T value;
	
	public Demo(T values){
		this.value = values;
	}
	
	public T getValue() {
		return value;
	}
}

/**
 * 数据封装
 */

class Course {

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course(String name){
		this.name = name;
	}
	
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

class Student implements Comparable<Student>{

	private String stuId;
	private String stuName;

	public Set<Course> mCourses;

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Student(String stuId, String stuName) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.mCourses = new HashSet<Course>();
	}

	public int compareTo(Student o) {
		return this.stuId.compareTo(o.stuId);
	}
}

/**
 * List集合
 */

class ListTest {

	private List<Course> courseToSelcet;

	public ListTest() {
		this.courseToSelcet = new ArrayList<Course>();
	}

	/**
	 * 添加
	 */
	public void testAdd() {
		
		//单个添加到集合中
		Course c1 = new Course("1", "c");
		Course c2 = new Course("2", "c++");
		Course c3 = new Course("3", "c#");
		courseToSelcet.add(c1);
		courseToSelcet.add(c2);
		courseToSelcet.add(c3);
		//多个添加到集合中
		Course[] course = { new Course("1", "java"),new Course("2", "python") };
		courseToSelcet.addAll(Arrays.asList(course));
	}

	/**
	 * for遍历
	 */
	public void testGet() {
		int size = courseToSelcet.size();
		for (int i = 0; i < size; i++) {
			Course temp0 = (Course) courseToSelcet.get(i);
			System.out.println(temp0.getId() + ":" + temp0.getName());
		}

	}

	/**
	 * 迭代器遍历
	 */
	public void iterators() {
		@SuppressWarnings("rawtypes")
		Iterator it = courseToSelcet.iterator();
		while (it.hasNext()) {
			Course temp = (Course) it.next();
			System.out.println(temp.getId() + ":" + temp.getName());
		}
	}

	/**
	 * forEach遍历
	 */

	public void forEach() {
		for (Course obj : courseToSelcet) {
			System.out.println(obj.getId() + ":" + obj.getName());
		}
	}

	/**
	 * 移除
	 */

	public void removeList() {
		courseToSelcet.removeAll(courseToSelcet);
	}
}

/**
 * set集合
 */
class SetTest {

	public List<Course> courseToSelcet;

	public SetTest() {
		courseToSelcet = new ArrayList<Course>();
	}

	/**
	 * 添加
	 */
	public void testAdd() {
	
		Course c1 = new Course("1", "c");
		courseToSelcet.add(c1);
		Course c2 = new Course("2", "c++");
		courseToSelcet.add(1, c2);
		
		Course[] course = { new Course("3", "java"),new Course("4", "python") };
		courseToSelcet.addAll(Arrays.asList(course));
	}

	/**
	 * 迭代器遍历
	 */
	public void iterators() {
		@SuppressWarnings("rawtypes")
		Iterator it = courseToSelcet.iterator();
		while (it.hasNext()) {
			Course temp = (Course) it.next();
			System.out.println(temp.getId() + ":" + temp.getName());
		}
	}

	/**
	 * for遍历
	 */

	public void testSet() {
		Student stu = new Student("1", "lenovo");
		System.out.println(stu.getStuId() + "--" + stu.getStuName());
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("输入ID:");
			String courseid = input.next();
			for (Course cr : courseToSelcet) {
				if (cr.getId().equals(courseid)) {
					stu.mCourses.add(cr);
				}
			}
		}
		testSetForEach(stu);
	}

	/**
	 * forEach遍历
	 */
	private void testSetForEach(Student stu) {
		for (Course cr : stu.mCourses) {
			System.out.println(cr.getId() + ":" + cr.getName());
		}
	}
}

/**
 * Map集合
 */
class MapTest {

	public Map<String, Student>map;
	private Scanner input;
	
	public MapTest(){
		this.map =  new HashMap<String, Student>();
		input = new Scanner(System.in);
	}
	
	/**
	 * put
	 */
	public void testPut(){
		int k=0;
		while(k<3){
			System.out.println("ID:");
			String id = input.next();
			Student st = map.get(id);
			if(st == null){
				System.out.println("NAME:");
				String name = input.next();
				Student newstudent = new Student(id, name);
				map.put(id, newstudent);
				System.out.println(map.get(id).getStuName());
				k++;
			}else{
				System.out.println("数据已添加!");
				continue;
			}
		}
		
	}
	
	/**
	 * KeySet()
	 */
	
	public void testKeySet(){
		Set<String> keySet = map.keySet();
		System.out.println(map.size());
		for (String str : keySet) {
			if(str != null){
				System.out.println(str.toString()+"--"+map.get(str).getStuName());
			}
		}		
	}
	
	/**
	 * entrySet()
	 */
	public void testEntrySet(){
		Set<Map.Entry<String,Student>>mSet = map.entrySet();
		System.out.println(map.size());
		for (Map.Entry<String, Student> entry : mSet) {
			if(entry!=null){
				System.out.println(entry.getKey()+"--"+entry.getValue().getStuName());
			}
		}
	}
	/**
	 * ContainsKey/ContainsValue
	 */
	public void testMapContainsKeyOrValue(){
		System.out.println("ID");
		String id = input.next();
		if(map.containsKey(id)){
			System.out.println(map.get(id).getStuName());
		}else{
			System.out.println("*****");
		}
		System.out.println("NAME:");
		String name = input.next();
		Student stu = new Student(null,name);
		if(map.containsValue(stu)){
			System.out.println(stu.getStuName());
		}else{
			System.out.println("*****");
		}
	}
}