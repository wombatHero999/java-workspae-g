package com.kh.chap04_sync.part02_control.run;

import com.kh.chap04_sync.part02_control.model.thread.Consumer;
import com.kh.chap04_sync.part02_control.model.thread.Data;
import com.kh.chap04_sync.part02_control.model.thread.Provider;

public class Run {
	
	public static void main(String[] args) {
		Data data = new Data();
		Thread provider = new Thread(new Provider(data));
		Thread consumer = new Thread(new Consumer(data));
		
		provider.start(); // 데이터 생성이 안된 상태.
		consumer.start();
		
		// join() : 지정된 시간동안 , join메서드에 의해 호출된 스레드가 작업을 완료할 때 까지 현재 쓰레드를 대기상태로 
		// 만드는 메서드.
		try {
			provider.join(); // 메인스레드 대기.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인스레드 작업 완료.");
	}
	
}

















