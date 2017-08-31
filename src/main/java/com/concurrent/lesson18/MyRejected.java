package com.concurrent.lesson18;

import java.net.HttpURLConnection;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejected implements RejectedExecutionHandler{

	
	public MyRejected(){
	}
	
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("........");
		System.out.println("?" + r.toString());
		

	}

}
