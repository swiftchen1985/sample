package com.concurrent;

import java.util.Arrays;

public class ConcurrentTest {

	public static void main(String[] args) {
		System.out.println("当前可用的CPU："+Runtime.getRuntime().availableProcessors());
		
		System.out.println("当前虚拟机总内存：" + Runtime.getRuntime().totalMemory()/(1024*1024));
		
		System.out.println("最大内存：" + Runtime.getRuntime().maxMemory()/(1024*1024));
		
		System.out.println("可用内存：" + Runtime.getRuntime().freeMemory()/(1024*1024));
		
		
		
		String str = "a,b,c,,";
		String[] ary = str.split(",");
		//预期大于3，结果是3
		System.out.println(ary.length);
		System.out.println(Arrays.toString(ary));
		
		Thread t = null;
		for (int i = 0;i< 1000;i++) {
			t = new Thread() {
				@Override
				public void run() {
					super.run();
					System.out.println("当前线程名称："+ Thread.currentThread().getName()); 
				}
			};
			t.start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
