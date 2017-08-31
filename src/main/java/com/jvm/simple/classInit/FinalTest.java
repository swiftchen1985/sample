package com.jvm.simple.classInit;

class Calculate	{
	
	static final int a = 6/2;
	 
	 static {
		 System.out.println("static block");
	 }
}

public class FinalTest { 

	 public static void main(String[] args) {
		System.out.println(Calculate.a);
	}
}
