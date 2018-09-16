package com.java.annotation;

/**
 * java中的内置注解/元注解
 *
 */
public class Annotation {

	//修饰方法的注解，重写父类方法
	@Override 
	public String toString() {
		return super.toString();
	}
	
	//修饰方法的注解，表示该方法不建议使用(可以用)
	@Deprecated 
	public void toInt(){
		
	}
	
	//修饰方法的注解，表示强制压制编译的警告信息，value代表参数值
	@SuppressWarnings(value = { }) 
	public void toSuper(){
		
	}

}

