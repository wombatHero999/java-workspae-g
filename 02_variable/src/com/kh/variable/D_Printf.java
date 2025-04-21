package com.kh.variable;

public class D_Printf {
	
	public void printfTest() {
		/*
		 *  println() => 값 출력 후 자동 개행(\n)
		 *  print() => 값 만 출력한 후 종료
		 *  printf("출력할 형식", 형식에 맞는 값들 ...)
		 *   => f는 format을 의미.
		 *   => 형식에 맞춰서 값들을 출혁한 후 종료 (줄바꿈 x)
		 *   문자열에 추가 가능한 형식
		 *   %d : 정수
		 *   %f : 실수
		 *   %c : 문자
		 *   %s : 문자열
		 *  */
		// 정수 테스트
		int iNum1 = 10;
		int iNum2 = 20;
		
		// iNum1 : xx, iNum2 : xx 을 출력해보자
		// println문을 활용하여 출력문 만들기
		System.out.println("iNum1 : "+iNum1+", iNum2 : "+iNum2);
		// printf문 사용
		System.out.printf("iNum1 : %d, iNum2 : %d\n", iNum1, iNum2);
		
		// 실수 테스트
		double dNum = 4.27546789;
		System.out.printf("dNum : %f", dNum);
		// %f => 소수점 아래 6번째 까지만 출력
		
		System.out.printf("dNum : %.1f", dNum);
		// 소숫점 아래 첫번째 짜리만 출력하고 싶다면? %.1f
	}
}




