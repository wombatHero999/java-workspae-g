package com.kh.variable;

public class B_Cast {
	/* 
	 * (자료)형변환 : 값의 자료형을 바꾸는 개념
	 * 
	 * 컴퓨터의 값 처리 규칙
	 * 1. 값 끼리의 연산은 항상 같은 자료형으로만 연산 가능하다.
	 *    =(대입연산자)도 마찬가지로 왼쪽과 오른쪽의 자료형이 같아야한다.
	 *    자료형 변수명 = 값;
	 *    서로 다른 자료형끼리 연산을 수행하고 싶으면 한 쪽을 형변환 해야함.
	 * 
	 * 형변환의 종류
	 * 1. 자동형변환 => 자동으로 형변환이 진행되기 때문에 내가 직접 형변환할 필요가 없다.
	 *       작은 바이트의 자료형 -> 큰 바이트의 자료형 
	 * 2. 강제형변환 => 자동형변환이 불가능한 경우, 내가 직접 형변환 연산자를 사용하여 변환한다.
	 *       큰 바이트의 자료형 -> 작은 바이트의 자료형
	 *    형변환 연산자 ==> (바꿀 자료형) 값     
	 * */
	
	public void autoCasting() {
		
		// 1. int -> double
		int i1 = 10;
		double d1 = /*(double)*/ i1; // 자동형변환 완료
		
		System.out.println("d1 : " + d1);
		
		int i2 = 1000;
		double d2 = 3.3;
		
		double result1 = /* (double) */ i2 + d2;
		// 1000+3.3 => 1000.0+3.3 => 1003.3
		
		// 2. int -> long
		int i3 = 1000;
		long l3 = /* (long) */ i3;
		
		long l4 = /* (long) */ 2000;
		// 다만 너무 큰 리터럴 값을 사용해야 하는 경우 l을 붙여줌.
		
		// 특이케이스 3. long -> float
		// long==> 8byte , float ==> 4byte
		// 정수가 실수에 담길 때에는 큰 사이즈의 정수여도 작은 사이즈의 실수에 대입 가능.
		// 실수는 지수표기법을 사용하기 때문에 long자료형보다 담을 수 있는 값의 범위가 훨씬 크다.
		long l5 = 10000000000L;
		float f5 = /* (float) */ l5;
		
		// 특이케이스 4. char <-> int
		// 양방향 형변환 가능.
		
		char ch = /*(char)*/ 65; // 아스키 코드표의 범위(0~127)
		System.out.println("ch : "+ch);
		
		int num = '민'; // 한글과 같은 기타나라의 언어는 유니코드표(0~65xxx)에 기술되어 있다.
		System.out.println(num);
		
		// 특이케이스 5. byte와 short 연산
		byte b1 = 127;
		byte b2 = 127;
		
		// byte나 short로 연산시 연산결과는 항상 int자료형으로 취급된다.
		byte b3 = (byte)(b1 + b2);// 강제형변환
	}
	
	public void forceCasting() {
		
		// 1. double -> int
		double d1 = 10.89;
		int i1 = (int) d1; // 10.89 -> 10
		System.out.println("i1 : "+i1);
		
		// 2. double(대표자료형) -> float
		float f1 = (float) 4.0;
		float f2 = 4.0f;
		float f3 = (float) d1;
		
		int iNum = 10;
		double dNum = 5.89;
		
		int iSum = iNum + (int) dNum; 
		
		int iSum2 = (int)(iNum + dNum); 
		// iNum = 10 
		// dNum = 5.89
		// 덧셈 연산 시
		// iNum = 10.0 
		// dNum = 5.89
		// iNum+dNUM = 15.89
		// 강제형변환시 => (int) 15.89 ==> 15
	}
	
	
}




