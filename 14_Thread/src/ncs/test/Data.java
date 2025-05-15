package ncs.test;

public class Data {
	private int value;
	private boolean isEmpty = true;
	
	public Data() {
		
	}
	
	public synchronized void setValue(int value) {
		try {
			if(isEmpty != true) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.value = value;
		isEmpty = false;
		notify();
	}
	
	public synchronized int getValue() {
//		value 값을 꺼냄 단, isEmpty 가 false 가 될때까지 기다림, false 가 되면 value를 꺼내고,
//		isEmpty 를 true 로 바꾸고 대기상 태의 스래드를 실행시킴
		if(isEmpty == true) {
			try {
				throw new EmptyException("현재 입력된 값이 없습니다. 잠시 기다리세요...");
			}catch(EmptyException e) {
				//System.out.println("현재 입력된 값이 없습니다. 잠시 기다리세요...");
				System.out.println(e.getMessage());
				try {
					wait();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
		isEmpty = true;
		notify();
		
		return value;
	}
	
	
}



















