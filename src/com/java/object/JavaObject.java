package com.java.object;

import com.java.object.HerbivorousAnimal.Cattle;
import com.java.object.HerbivorousAnimal.Sheep;
import com.java.object.Predator.Cat;
import com.java.object.Predator.Dog;

public class JavaObject {

	/**
	 * java开发知识二：面向对象(封装，继承，多态)，类(内部类，外部类，匿名内部类，抽象类，接口)
	 * @param args
	 */
	public static void main(String[] args) {
		//继承,多继承
		Animal mAnimal = new Animal();
		mAnimal.Predators();
		mAnimal.HerbivorousAnimals();
		
		Cat mCat = new Predator().new Cat();
        mCat.eat();
        mCat.sleep();
		
		Dog mDog = new Predator().new Dog();
        mDog.eat();
		mDog.paly();
		
		Cattle mCattle = new HerbivorousAnimal().new Cattle();
		mCattle.eat();
		mCattle.Power();
		
		Sheep mSheep = new HerbivorousAnimal().new Sheep();
		mSheep.eat();
		mSheep.Volce();
		//封装
		User user = new User(10001,"admin","12345","2018-9-16");
		System.out.println(user.get_id());
		System.out.println(user.getUser_name());
		System.out.println(user.getPass_word());
		System.out.println(user.getDate());
		//多态:继承，方法重写，父类引用指向子类对象
		Telephone telephone1 = new Keyphone();
		telephone1.Call();
		telephone1.Massges();
		Telephone telephone2 = new Smartphone();
		telephone2.Call();
		telephone2.Massges();
		IPlayGame iPlayGame1 = new PSP4();
		iPlayGame1.play();
		IPlayGame iPlayGame2 = new Smartphone();
		iPlayGame2.play();
	}

}

/**
 * 外部类
 *
 */
class Animal {

	public Animal(){
		System.out.println("Animal()");
	}
	
	public void Predators(){
		System.out.println("父类：Predators()");
	}
	public void HerbivorousAnimals(){
		System.out.println("父类：HerbivorousAnimals()");
	}
}

/**
 * 外部类,继承:extends
 *
 */
class HerbivorousAnimal extends Animal {
	
	public HerbivorousAnimal(){
		super();
		System.out.println("子类：HerbivorousAnimal()");
	}
	
	public void eat(){
		System.out.println("HerbivorousAnimal-->eat()");
	}
	
	/**
	 * 内部类;继承:extends
	 *
	 */
	public class Cattle extends HerbivorousAnimal {

		public Cattle() {
			super();
			System.out.println("Cattle()");
		}

		@Override
		public void eat() {
			System.out.println("Cattle-->eat()");
		}
		
		public void Power(){
			System.out.println("Cattle-->Power()");
		}
	}
	
	public class Sheep extends HerbivorousAnimal {

		public Sheep() {
			super();
			System.out.println("Sheep()");
		}

		@Override
		public void eat() {
			System.out.println("Sheep-->eat()");
		}

		public void Volce(){
			System.out.println("Sheep-->Volce()");
		}
    }
	
}

/**
 * 外部类,继承:extends
 *
 */
class Predator extends Animal {

	public Predator(){
		super();
		System.out.println("子类：Predators()");
	}
	
	public void eat(){
		System.out.println("Predator-->eat()");
	}
	
	public class Cat extends Predator {

		public Cat() {
			super();
			System.out.println("Cat()");
		}

		@Override
		public void eat() {

			System.out.println("Cat-->eat()");
		}
		
		public void sleep(){
			System.out.println("Cat-->sleep()");
		}
		
	}
	
	public class Dog extends Predator {

		public Dog() {
			super();
			System.out.println("Dog()");
		}

		@Override
		public void eat() {

			System.out.println("Dog-->eat()");
		}
		
		public void paly() {
			System.out.println("Dog-->paly()");
		}

	}
}

/**
 * 外部类,封装
 *
 */

class User{
	private int _id;
	private String user_name;
	private String pass_word;
	private String date;
	
	public User() {
		
	}

	public User(int _id, String user_name, String pass_word, String date) {
		super();
		this._id = _id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.date = date;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [_id=" 
	            + _id + ", user_name=" 
				+ user_name + ", pass_word="
				+ pass_word + ", date=" 
				+ date + "]";
	}
}

/**
 * 外部类,抽象类abstract，接口interface
 *
 */
abstract class Telephone {

	public abstract void Call();
	public abstract void Massges();
}

class Keyphone extends Telephone {

	@Override
	public void Call() {
		System.out.println("Keyphone-->Call()");
	}

	@Override
	public void Massges() {
		System.out.println("Keyphone-->Massges()");
	}
}

interface IPlayGame {

	public void play();
}

class PSP4 implements IPlayGame {

	@Override
	public void play() {
		System.out.println("PSP4-->play()");
	}

}

class Smartphone extends Telephone implements IPlayGame{

	@Override
	public void play() {
		System.out.println("Smartphone-->play()");
	}

	@Override
	public void Call() {
		System.out.println("Smartphone-->Call()");
	}

	@Override
	public void Massges() {
		System.out.println("Smartphone-->Massges()");
	}


}

