package com.java.jdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {
	
	private static String str = "(1* professional 2* desktop 3* server 4* game 5* notebook 6* notebook accessories 7* super)";
	private static String str2 = "(1* Lenovo 2* Razer 3* ASUS 4* SONY 5* apple 6* DELL 7* HP)";
	
	private static String[] strs ={ "professional","desktop","server","game","notebook","notebook accessories","super"};
	private static String[] strs2 ={ "Lenovo", "Razer", "ASUS", "SONY", "apple","DELL","HP"};
	
	public static Scanner input = new Scanner(System.in);
	public static DAOConputer dc= new DAOConputer();
	public static Conputer c = new Conputer();

	public static void main(String[] args) {
		System.out.println("*****Welcome to the digital product inquiry system*****");
		while(true){
			System.out.println();
			System.out.println("1*Select Database     2*Insert Database     3*Updata Database     4*Delete Database     5*Exit");
			int num = input.nextInt();
			if(num == 1){
				onSelect();
			}else if(num == 2){
				onAddData();
			}else if(num == 3){
				onUpdata();
			}else if(num == 4){
				onDelete();
			}else if(num == 5){
				System.out.println("*****Thanks to the digital product inquiry system*****");
				break;
			}else{
				System.out.println("Enter command error, please re-enter!");
				continue;
			}
		}
	}
	
	
	public static void onAddData(){
		System.out.println("Automatically increase the number of digital");
		System.out.println("Added digital model");
		c.setModel(input.next());
		System.out.println("Increased digital category"+str);
		int num = input.nextInt();
		c.setCate(strs[num-1]);
		System.out.println("Increased digital brand"+str2);
		int nums = input.nextInt();
		c.setBrand(strs2[nums-1]);
		System.out.println("Increased digital price");
		c.setPeice(input.nextInt());
		boolean b = dc.insert(c);
		if(b){
			System.out.println("New data success!");					
		}else{
			System.out.println("Program execution error...");
		}
	}
	
	public static void onUpdata(){
		System.out.println("To modify the number of digital");
		c.setId(input.nextInt());
		System.out.println("Modified digital model");
		c.setModel(input.next());
		System.out.println("Modified digital category"+str);
		int num = input.nextInt();
		c.setCate(strs[num-1]);
		System.out.println("Modified digital brand"+str2);
		int nums = input.nextInt();
		c.setBrand(strs2[nums-1]);
		System.out.println("Modified digital price");
		c.setPeice(input.nextInt());
		boolean b = dc.update(c);
		if(b){
			System.out.println("updata data success!");					
		}else{
			System.out.println("Program execution error...");
		}
	}
	
	public static void onDelete(){
		System.out.println("Object to be deleted");
		boolean b =dc.delete(input.nextInt());
		if(b){
			System.out.println("delete data success!");					
		}else{
			System.out.println("Program execution error...");
		}
	}
	
	public static void onSelect(){
		ArrayList<Conputer> list = new DAOConputer().getList();
		for (Conputer conputer : list) {
			System.out.println(
			conputer.getId() + "/" 
		    + conputer.getModel()+ "/" 
			+ conputer.getCate() + "/"
			+ conputer.getBrand() + "/" 
			+ conputer.getPeice());
			System.out.println("------------------------------------------------------");
		}
	}
}
