package com.kh.chap01_math.run;

public class Run {
	
	public static void main(String[] args) {
		// Math 클래스의 메서드들
		System.out.println("파이 : "+Math.PI);
		
		double num1 = 4.349;
		
		// 올림 / 반올림 / 내림
		//ceil / round / floor
		System.out.println("올림 : "+Math.ceil(num1));
		System.out.println("반올림 : "+Math.round(num1));
		System.out.println("내림 : "+Math.floor(num1));
		
		// 절대값 구하기
		int num2 = -10;
		System.out.println("절대값 : "+Math.abs(num2));
		
		// 최소값 / 최대값
		System.out.println("최소값 : "+Math.min(5, 10));
		System.out.println("최대값 : "+Math.max(5, 10));
		
		// 루트 
		System.out.println("4의 제곱근 : "+Math.sqrt(4));
		
		// 제곱
		System.out.println("2의 10제곱 : "+Math.pow(2, 10));
	}
}








