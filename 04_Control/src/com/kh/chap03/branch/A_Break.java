package com.kh.chap03.branch;

import java.util.Scanner;

public class A_Break {
	/*
	 * break : 코드 실행 중 break문을 만나게 되면 현재 속해있는 가장 가까운
	 *         반복문을 빠져나가는 구문.
	 *  */
	public void method1() {
		// 매번 반복적으로 랜덤값(1~100)을 출력
		// 단, 출력한 랜덤값이 3의 배수인 경우 반복을 종료.
		
		while(true) {
			int random = (int)(Math.random() * 100 +1);
			System.out.println("random : "+random);
			
			if(random % 3 == 0) {
				break;
			}
		}
	}
	
	Scanner sc = new Scanner(System.in);
	
	public void method2() {
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다..");
				break;
			}
			
			System.out.println(str+"의 글자수 : "+str.length());
		}
	}
	
	public void method3() {
		// 매번 반복적으로(무한반복) 사용자에게 양수를 입력받아 1~사용자가 입력한 값까지 출력
		// 단, 사용자가 양수를 입력한 경우 반복을 종료.
		while(true) {
			System.out.print("양수 입력 : ");
			int num = sc.nextInt();
			
			for(int i = 1; i <= num; i++) {
				System.out.print(i+" ");
			}
			
			if(num > 0) break;
		}
		
	}
	
	public void temp() {
		
		loop1:
		for(int j = 1; j<=10; j++) { 
			loop2:
			for(int i = 1; i<= 10; i++) {
				if(i == 5) {
					break loop1;
				}
				System.out.println(i);
			}
			System.out.println();
		}
	}
	
	
	
}





