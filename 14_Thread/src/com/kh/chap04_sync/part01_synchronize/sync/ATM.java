package com.kh.chap04_sync.part01_synchronize.sync;

import java.util.Random;

public class ATM implements Runnable{
	
	private Account acc;
	
	public ATM(Account acc) {
		this.acc = acc;
	}
	
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (new Random().nextInt(3) + 1) * 100;// 100 200 300
			acc.withdraw(money);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"종료");
	}
	
	
}













