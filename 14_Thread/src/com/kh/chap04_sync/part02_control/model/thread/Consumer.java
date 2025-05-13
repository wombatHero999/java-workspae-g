package com.kh.chap04_sync.part02_control.model.thread;

public class Consumer implements Runnable{
	
	private Data data;
	
	public Consumer(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<= 10; i++) {
			data.getData(); // 생상된 데이터를 소비하는 메서드.
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}















