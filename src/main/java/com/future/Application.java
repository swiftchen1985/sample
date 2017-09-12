package com.future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
 
public class Application {
    public static void main(String[] args) throws Exception {
    	MarkTag mt01 = new MarkTag();
        FutureTask<MarkTag> futureTask =  new FutureTask<MarkTag>(new RealData(mt01));
        ExecutorService executor = Executors.newFixedThreadPool(1); //使用线程池
        executor.submit(futureTask);
        Thread.sleep(2000);
        System.out.println("数据=" + futureTask.get().getName());
        
        System.out.println("end....");
    }
}