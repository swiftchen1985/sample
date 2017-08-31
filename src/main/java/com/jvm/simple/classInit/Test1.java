package com.jvm.simple.classInit;

class Parent {
	static int a = 3;
	
	static {
		System.out.println("parent static block");
	}
}
class Child extends Parent{
	static int b = 4;
	static {
		System.out.println("child static block");
	}
}


public class Test1 {

	static {
		System.out.println("test1 static block");
	}
	
	public static void main(String[] args) {
		System.out.println(Parent.a);
		
		System.out.println(Child.b);
	}
}
