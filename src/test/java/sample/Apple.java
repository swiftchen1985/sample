package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Apple < T extends Fruit>{

	
	public static void main(String[] args) {
		List<Apple> ls = new ArrayList<Apple>();
		ls.add(new Apple());
		
		
		String[] str = new String[] { "a", "b" }; 
		List list = Arrays.asList(str);
		
		
		//str[3]= "gujin";
		
		//list.add("c");
		
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		
		//chm.put("", null);
		
		df.get().format(new Date());
		
		Thread t1 = new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(df.get().format(new Date()));
			}
			
		};
		
		Thread t2 = new Thread(){
			@Override
			public void run() {
				super.run();
				System.out.println(df.get().format(new Date()));
			}
			
		};
		
		t1.start();
		t2.start();
	
 	}
	
	
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
		
			return new SimpleDateFormat("yyyy-MM-dd");
			
		}
	};
}
