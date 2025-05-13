package com.kh.chap03_control.run;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Run run = new Run();
		run.test2();
	}
	
	public void test2() {
		/* 
		 * 일시정지를 푸는 메서드
		 *  1) notify() / notifyAll() : 동기화된 블럭안에서 대기중인 쓰레드를 깨우는 역할을 한다.
		 *     임계영역에 접근할 수 있는 key를 부여한다. 
		 *  
		 *  2) interrupt() : sleep()이나, join()에 의해 일시정지된 스레드를 (깨우는 역할)실행 대기상태로 
		 *    만든다.(에러 강제 발생)
		 * */
		Thread cnt = new Thread(()->{
			for(int i = 100; i >= 0; i--) {
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
			System.out.println("쓰레드 종료");
		});
		
		cnt.start();
		
		// 
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("종료하시려면 exit를 입력해주세요.");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				cnt.interrupt();
				break;				
			}
		}
	}
	
	
	public void test1() {
		/* 스레드 컨트롤 메서드
		   작업중인 스레드를 "일시정지"(TIME_WAITING)시키는 메서드
		    1) Thread.sleep(ms) : 지정된 시간동안 스레드를 일시정지상태로 변환.
		       지정된 시간이 끝나면 실행대기상태(Runnable)로 변경.
		    
		    2) wait() : 동기화된 블럭안에서만 사용되며, 지정된시간이 지나거나, 다른스레드가
		       호출하기 전까지 대시키는 메서드.
		       
		    3) join() : 지정된 시간동안 다른스레드를 실행시키고, 현재 스레드는 대기시키는 메서드.
		       지정된 시간이 지나거나, 다른 스레드의 작업이 완료되면 현재스레드가 다시 가동된다.
		       
		    4) IO Block(입출력메서드)
		*/
		// 0.05초간 일시정지하는 스레드.
		Thread a = new Thread(()->{
			for(int i =0; i< 100; i++) {
				System.out.print("-");
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"끝");
		});
		
		a.setName("a쓰레드");
		
		Thread b = new Thread(()->{
			for(int i =0; i< 100; i++) {
				System.out.print("|");
				
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"끝");
		});
		b.setName("b쓰레드");
		
		a.start();
		b.start();
	}
	
	
	
	
}












