package com.kh.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	/* 
	 * switch문
	 *  - if문과 동일한 조건문
	 *  - if문은 조건식을 복잡하게 기술할 수 있음. 값의 범위를 제시.
	 *    하지만, switch은 확실한 하나의 값만 기술(동등비교만 수행가능)
	 * [표현법]
	 *  switch(동등비교할 계산식, 변수) {
	 *  case 값1 : 실행할 코드; // switch문의 변수와 값1이 동등한 경우
	 *                       // 실행하는 코드
	 *             break; // 코드 실행후 switch문을 탈출하는 역할 연산자.
	 *             // break가 없다면 아래쪽으로 코드 순차적으로 실행.
	 *  case 값2 :
	 *  
	 *  case 값n :
	 *  ...
	 *  default  : 위의 값들중 일치하는 값이 없는 경우 실행할 코드를 기술
	 *             //break;
	 *  }
	 *  
	 *  switch의 장점 -> case를 통해 내가 실행하기를 원하는 코드로 즉시 이동
	 *  하기 때문에 연산속도가 if ~ else if문 보다 빠르다.
	 *  
	 *  switch문 의 사용처
	 *   - 항상 동일한 속도로 연산이 수행되어야 하는 경우
	 *     ex) 키보드 입력, 마우스 입력
	 *   - 가독성 측면에서 if ~ else if문보다 더 뛰어난 경우
	 *     ex) 동등비교 조건식을 5회 이상 사용하는 경우 switch문 사용 권장
	 * */
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		// 1~3사이의 정수값을 입력받아
		System.out.print("1 ~ 3 사이의 정수 입력 : ");
		int num = sc.nextInt();
		
		if(num == 1) System.out.println("빨간불");
		else if(num == 2) System.out.println("파란불");
		else if(num == 3) System.out.println("초록불");
		else System.out.println("잘못 입력했습니다..");
		
		switch(num) {
		case 1 : 
			System.out.println("빨간불"); 
			break;
		case 2 :
			System.out.println("파란불");
			break;
		case 3 : 
			System.out.println("초록불");
			break;
		default :
			System.out.println("잘못 입력");
		}
		
	}
	
	public void method2() {
		
		System.out.println("KH 과일가게");
		System.out.print("구매할 과일(사과, 망고, 바나나) : ");
		String fruit = sc.nextLine();
		int price = 0;
		
		switch(fruit) {
		case "사과" :
			price = 1000;
			break;
		case "망고" : case "바나나" :
			price = 3000;
			break;
		default : 
			System.out.println("저희 가게에서 판매하는 과일이 아니네요..");
			return; // 메서드 종료
		}
		
		System.out.printf("%s의 가격은 %d원입니다.", fruit, price);
	}
	
}







