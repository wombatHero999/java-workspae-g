package ncs.test;

public class MultiThreadTest {
	public static void main(String[] args) {
		Data data = new Data();
		Thread putThread = new Provider(data);
		Thread getThread = new Customer(data);
		
		putThread.start();
		getThread.start();
	}
}
