package com.kh.chap04_sync.part02_control.model.thread;

public class Provider implements Runnable {

	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			data.setData();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

















