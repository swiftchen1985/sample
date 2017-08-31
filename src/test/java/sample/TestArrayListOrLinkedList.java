package sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestArrayListOrLinkedList {

	private static int CAPACITY = 10000;
	
	@Test
	public void testInsertArrayList() {
		List<Integer> arrayList = new ArrayList<Integer>();
		 for (int i = 0; i < CAPACITY; i++)  {
		        arrayList.add(i);
		 }
		long startTime = System.currentTimeMillis();
	    for (int i = 0; i < CAPACITY; i++){
	        System.out.println(arrayList.get(i));
	    }
	    System.out.println("ArrayList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	@Test
	public void testInsertLinkedList() {
		List<Integer> linkedList = new LinkedList<Integer>();
	    
	    for (int i = 0; i < CAPACITY; i++){
	        linkedList.add(i);
	    }
	    long startTime = System.currentTimeMillis();
	    for (int i = 0; i < CAPACITY; i++){
	        System.out.println(linkedList.get(i));
	    }
	    System.out.println("LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	@Test
	public void testIteratorArrayList() {
		List<Integer> arrayList = new ArrayList<Integer>();
	    
	    for (int i = 0; i < CAPACITY; i++){
	    	arrayList.add(i);
	    }
	    long startTime = System.currentTimeMillis();
	    for (Integer i : arrayList){
	        System.out.println(i);
	    }
	    System.out.println("LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	
	@Test
	public void testIteratorLinkedList() {
		List<Integer> linkedList = new LinkedList<Integer>();
	    
	    for (int i = 0; i < CAPACITY; i++){
	        linkedList.add(i);
	    }
	    long startTime = System.currentTimeMillis();
	    for (Integer i : linkedList){
	        System.out.println(i);
	    }
	    System.out.println("LinkedList遍历速度：" + (System.currentTimeMillis() - startTime) + "ms");
	}
}
