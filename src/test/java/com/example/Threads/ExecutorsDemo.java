package com.example.Threads;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorsDemo {
	
	
	public static void main(String[] args) {
		
		Task2 t1 = new Task2();
		Task2 t2 = new Task2();
		Task2 t3 = new Task2();
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		
		Future f1 = exec.submit(t1);
		Future f2 =exec.submit(t2);
		Future f3 =exec.submit(t3);
		
		try {
			ArrayList<Integer> arr1 = (ArrayList<Integer>)f1.get(0, TimeUnit.MILLISECONDS);
			System.out.println(arr1);
			ArrayList<Integer> arr2 = (ArrayList<Integer>)f1.get();
			System.out.println(arr1);
			ArrayList<Integer> arr3 = (ArrayList<Integer>)f1.get();
			System.out.println(arr1);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		exec.shutdown();
		
		
		
		
	}

}



class Task2 implements Callable {

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		int i = 0;
		
		while(++i <= 100) {
			arr.add(i);
		}
		
		return arr;
	}
	
}