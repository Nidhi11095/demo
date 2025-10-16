package com.example.Threads;

public class MyFirstThread {
	
	public static void main(String[] args) {
		
		Runnable task = new MyFirstTask();
		
		Thread t1 = new Thread(task);
		
		t1.start();
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread");
		
	}

}
