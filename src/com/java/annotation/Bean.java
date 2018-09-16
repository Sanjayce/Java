package com.java.annotation;


@DivAnnotation(value = "java_annotation")
public class Bean {
	
	@DivAnnotation2(fieldName = "id", lengh = 5, type = "int")
	private int id;
	@DivAnnotation2(fieldName = "name", lengh = 4, type = "String")
	private String name;
	
	@DivAnnotation3(type = "void")
	public void toMothrd(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
