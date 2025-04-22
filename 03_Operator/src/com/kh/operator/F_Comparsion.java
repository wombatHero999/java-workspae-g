package com.kh.operator;

public class F_Comparsion {
	
	public void method1() {
		/* 
		 * 비교연산자 / 관계연산자
		 * 두 개의 값을 가지고 비교, 비교연산 결과가 참인 경우 true,
		 * 거짓인 경우 false값을 반환
		 * 
		 * a < b , a > b , a <= b , a >= b
		 * 
		 * a == b , a != b
		 * */
		int a = 10;
		int b = 25;
		
		System.out.println("a > b : "+ (a > b)); // false
		System.out.println("a <= b : "+ (a <= b)); // true
		
		boolean result1 = a == b; // false
		boolean result2 = a != b; // true
		
		System.out.println("a가 짝수입니까 : " + (a % 2 == 0));
		System.out.println("a가 짝수입니까 : " + (a % 2 != 1));
		System.out.println("a가 짝수입니까 : " + !(a % 2 == 1));
	}

}





