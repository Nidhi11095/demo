package com.example.Threads;

public class MyFirstTask implements Runnable {

	@Override
	public void run() {
		
		func1();

	}
	
	private void func1() {
		System.out.println("inside func1");
		
		func2();
	}
	
	private void func2() {
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("inside func2");
		func3();
	}
	
	private void func3() {
		System.out.println("inside func3");
	}

}
