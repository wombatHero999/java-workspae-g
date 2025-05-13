package com.kh.chap04_sync.part01_synchronize.run;

import com.kh.chap04_sync.part01_synchronize.sync.ATM;
import com.kh.chap04_sync.part01_synchronize.sync.Account;

public class Run {
	public static void main(String[] args) {
		Account acc = new Account(); // 공유자원
		
		Thread ATM1 = new Thread(new ATM(acc), "ATM 1");
		Thread ATM2 = new Thread(new ATM(acc), "ATM 2");
		
		ATM1.start();
		ATM2.start();
		
		System.out.println("메인스레드 종료");
	}
}


















