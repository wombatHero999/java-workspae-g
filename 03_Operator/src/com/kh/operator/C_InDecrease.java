package com.kh.operator;

public class C_InDecrease {
	/* 
	 * 증감연산자(단항연산자) ++ , --
	 * ++ : 변수에 담긴 값을 1 증가시키는 연산자
	 *      ++변수 (전위연산)
	 *      변수++ (후위연산)
	 * -- : 변수에 담긴 값을 1 감소시키는 연산자     
	 * 
	 * 전위연산 -> 선 증감 후 처리
	 * 후위연산 -> 선 처리 후 증감
	 * */
	
	public void method1() {
		// 전위연산
		int num = 10;
		System.out.println(num); // 10
		System.out.println(++num); // 11
		System.out.println(++num); // 12
		//선 증감 후 처리
		num = num +1; System.out.println(num);
		System.out.println(++num); // 13
		System.out.println(num); // 13
		
		// 후위연산
		System.out.println("===============================");
		int num2 = 10;
		System.out.println(num2); // 10
		System.out.println(num2++); // 10 출력 후 1 증가.
		// 선 처리 후 증감.
		//System.out.println(num2); num2 = num2+1;
		System.out.println(num2++);// 11
		System.out.println(num2++);// 12(13)
		System.out.println(++num2);// 14
		
		System.out.println(num2);
	}
	
	public void method2() {
		int a = 10;
		int b = ++a;
		//a = a +1; int b = a;
		System.out.println("a : "+a); // 10 | 11 
		System.out.println("b : "+b); // 11 | 11 
		
		int c = 10;
		int d = c++;
		//int d = c; c = c + 1;
		System.out.println("c : "+c);// 11 | 10
		System.out.println("d : "+d);// 10 | 11
	}
	
	public void method3() {
		int num1 = 20;
		int result1 = (num1++) * 3; // 60 ,61 , 63
		//int result1 = 20 * 3; num1 = num1+1;
		
		int num2 = 20;
		int result2 = ++num2 * 3; // 60 ,61 , 63
		// num2 = num2 + 1; 21 * 3
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("result1 : "+result1);// 60
		System.out.println("result2 : "+result2);// 63
	}

	
}




