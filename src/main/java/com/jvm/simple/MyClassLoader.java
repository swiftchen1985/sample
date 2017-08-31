package com.jvm.simple;

public class MyClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Class.forName("java.lang.String");
		System.out.println(clazz1.getClassLoader()); 
		
		
		Class clazz2 = Class.forName("com.jvm.simple.MyClassLoader");
		
		System.out.println(clazz2.getClassLoader());
	}
	
	
}
class C {
	
}