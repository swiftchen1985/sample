package com.jvm.simple;

import java.util.Enumeration;
import java.util.Properties;

class Singleton {
	
	private static Singleton  singleton = new Singleton();
	public static int counter1 ;
	public static int counter2 = 0;
	
	private Singleton() {
		counter1++;
		counter2++;
	}
	
	
	public static  Singleton getInstance() {
		return singleton;
	}
}



public class MyTest01 {
	
	
	
	public static void main(String[] args) {
		Properties pros = System.getProperties();
		Enumeration<?> enums = pros.propertyNames();
		while(enums.hasMoreElements()) {
			String key = (String) enums.nextElement();
			System.out.println(key + "=" + pros.getProperty(key));
		}
		
		System.out.println("===================================");
		Singleton singleton = Singleton.getInstance();
		System.out.println("counter1:" + singleton.counter1);
		//System.exit(0);
		System.out.println("counter2:" + singleton.counter2);
		
		
	}

}
