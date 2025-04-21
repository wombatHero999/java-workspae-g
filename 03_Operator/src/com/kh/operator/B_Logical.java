package com.kh.operator;

import java.util.Scanner;

public class B_Logical {
	/*
	 * 논리 연산자 : 논리 값 두개를 비교하는 연산자
	 * 
	 * AND && : a && b -> a와 b가 모두 참(true)일 경우에만 true 반환
	 *          둘중 하나라도 false값이 들어간 경우 false 반환
	 *          
	 * OR  || : a || b -> a와 b 모두 거짓인 경우에만 false반환. 
	 *          둘 중 하나라도 true값이 들어간 경우 true반환.
	 *  */
	public void method1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 하나 입력해 주세요 : ");
		int num = sc.nextInt();
		
		// num의 값이 0보다 크면서, 짝수입니까?
		boolean result = (num > 0) && (num % 2 == 0);
		System.out.println("num이 0보다 크면서, 짝수 입니까 ? "+result);
	}
	
	public void method2() {
		// 입력한 값이 1이상 100이하의 숫자인지 확인.
		// 1 <= x <= 100
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력 : ");
		int num = sc.nextInt();
		
		// 1 <= x <= 100
		// 1 <= x && x <= 100
		boolean result = (1 <= num) && (num <= 100);
		System.out.println("num의 값은 1이상 100이하의 값 입니까 ? "+result);
	}
	
	public void method3() {
		// 사용자가 입력한 값이 'y' 혹은 'Y'인 경우 TRUE, 아니면 FALSE
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계속 진행하시려면 y를 입력해 주세요 : ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = ch == 'y' || ch =='Y';
		
		System.out.println(result);		
	}
	
	public void method4() {
		int num1 = 10;
		// ++ => num1이 가진값을 1 증가 시키는 단항연산자
		// and연산자의 경우 A && B의 조건중 A의 값이 false인 경우
		// 뒤 쪽 조건들은 "무조건" false이기 때문에 뒤쪽 조건식은 실행되지도 않는다.
		boolean result1 = (num1 < 5) && (num1++ > 0);
		
		System.out.println("result1 : "+result1); // false
		System.out.println("num1 : "+num1); // 10
		
		int num2 = 10;
		// or연산자는 A || B중 A가 참일경우 뒤 쪽 조건식은 검사하지 않고 참을 반환.
		boolean result2 = num2 < 20 || ++num2 > 0;
		//result2 ==> true,
		// num2 => 10
	}

}











