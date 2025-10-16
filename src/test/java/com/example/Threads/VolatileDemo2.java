package com.example.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo2 {
	
	public static void main(String[] args) {
		
		Task1 task1 = new Task1();
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task1);
		
		t1.setName("Thread1");
		t2.setName("Thread2");
		
		t1.start();
		t2.start();
	}

}



class Task1 implements Runnable {
	
	public static AtomicInteger id = new AtomicInteger();
	public static int val = 0;

	@Override
	public void run() {
		
		
		System.out.println(Thread.currentThread().getName() + "  id = " + getNewId());
		
	}
	
	public int getNewId() {
		
		return id.incrementAndGet();
		
//		try {
//			Thread.currentThread().sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return id.get();
		
	}
	
	public int getNewIdNew() {
		return val++;
	}
	
}
