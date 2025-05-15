package ncs.test;

import java.util.Random;

public class Provider extends Thread {
	private Data data;
	
	public Provider(Data data) {
		this.data = data;
	}
	
	@Override
	public void run() {
//		data의 value에 1부터 100
//		사이의 정수를 기록하는 
//		작업 10번 실행한다. 
//		한번 기록하고 0.1초 중지 
		
		for(int i =0; i<10;i++) {
			int random = new Random().nextInt(100) + 1;
			data.setValue(random);
			System.out.println("값이 입력되었습니다.");
			System.out.println("put value : "+random);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}

























