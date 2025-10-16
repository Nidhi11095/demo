package com.example.Threads;

public class VolatileDemo1 {
	
	public static volatile boolean stop;
	
	
	public static void main(String[] args) {
		
		 new Thread( new Runnable () {
				public void run() {
					
					while(!stop) {
						System.out.println("inside while");
					}
				}
		}
				).start();
		
		try {
			Thread.currentThread();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stop = true;
		
		if(stop) {
			System.out.println("stopped");
		}
	}
	
	
	

}
