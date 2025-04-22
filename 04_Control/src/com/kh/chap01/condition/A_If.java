package com.kh.chap01.condition;

import java.util.Scanner;

public class A_If {
	/*
	 * 프로그램의 실행 순서.
	 * 
	 * 선택적으로 특정 라인을 실행시키고자 할때 => 제어문.
	 * 반복적으로 실행해야 하는 코드 => 반복문.
	 * 반복문 내부 흐름을 제어하는 경우 => 분기문.
	 *  
	 * if(조건문)
	 * 조건문 : 조건식을 활용하여 true/false값이 나오도록 설정하는 식
	 *  */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		/* 
		 * 단독 if문
		 * [표현법]
		 * if(조건식) 조건식이 참일 때 실행할 코드 하나
		 * */
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if (num > 0) { // {} 코드 여러줄을 하나로 묶어서 실행하는 연산자
			System.out.println("양수다");
			System.out.println("양수다");
			System.out.println("양수다");
		}
		
		if (num <= 0) System.out.println("양수가 아니다");
	}
	
	public void method2() {
		/* 
		 * if ~ else 문
		 * [표현법]
		 * if(조건식) {
		 * 	조건식의 결과가 참이라면 실행할 코드들;
		 * } else {
		 *  조건식의 결과가 거짓이라면 실행할 코드들;
		 * }
		 * */
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if (num > 0) { // {} 코드 여러줄을 하나로 묶어서 실행하는 연산자
			System.out.println("양수다");
		}else {
			System.out.println("양수가 아니다");
		}
	}
	
	
}







