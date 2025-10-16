package com.example.Threads;

public class RaceConditionDemo {
	
	public static void main(String[] args) {
		
		Task task = new Task();
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.setName("Husband");
		t2.setName("Wife");
		
		t1.start();
		t2.start();
	}

}


class Task implements Runnable {
	
	public static BanckAccount account;
	
	public Task() {
		account = new BanckAccount();
	} 

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " before balance = "+ account.getBalance());
		
		account.withdrawMoney();
		
		System.out.println(Thread.currentThread().getName() + " after balance = "+ account.getBalance());
			
	}
	
}


class BanckAccount {
	
	
	private int balance;
	
	public BanckAccount() {
		balance = 100;
	}
	
	 public int getBalance() {
		return balance;
	}
	
	 synchronized public void withdrawMoney() {
		
		if(balance - 75 >= 0) {
			
			try {
				Thread.currentThread();
				Thread.sleep(0);
			} catch(InterruptedException e) {
				
			}
			
			balance -= 75;
		}
	}
}
