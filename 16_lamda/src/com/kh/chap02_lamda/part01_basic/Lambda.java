package com.kh.chap02_lamda.part01_basic;

import com.kh.chap02_lamda.model.functional.LambdaTest1;

public class Lambda {
	/*
	 * 함수형 프로그래밍과 람다식
	 * 
	 * 함수형 프로그래밍(FP)
	 *  - 함수를 기반으로 코드를 작성하고 함수를 호출하여 동작하는 프로그램을 만드는 방식
	 *    즉, 클래스 없이 함수만 작성하여 동작하는 프로그램을 만든다.
	 *  - 객체지향 프로그래밍에 비해서 작성해야하는 코드의 수가 줄어든다.
	 * 
	 * 객체지향 프로그래밍(oop)
	 *  - 객체를 기반으로 객체간의 상호작용을 통해 동작하는 프로그램을 만드는 방식
	 *  - OOP에서는 만들어야하는 기능(함수)이 있는 경우 반드시 클래스를 먼저 만들고, 클래스 내부에
	 *    함수(메서드)를 추가해야 한다.
	 *    
	 * 람다식(Lambda expression)
	 *  - 자바에서 함수형 프로그래밍을 지원하기 위해 JDK8버전부터 추가된 기능
	 *  - 함수이지만, 함수 이름이 없는 익명함수처럼 사용된다.
	 *  - 함수의 작성방식에서 불필요한 부분을 걸러낸 후, 간결하게 표현한 표현식
	 * 
	 * 일반메서드 vs 람다식
	 * 1. 일반메서드(함수)
	 * int add(int x , int y) {
	 * 		return x + y;
	 * }
	 * 
	 * 2. 람다식
	 * (x , y ) -> {
	 * 	return x+y;
	 * };
	 * (x , y ) -> x + y ;
	 *  */
	
	public static void main(String[] args) {
		
		LambdaTest1 lamda1 = new LambdaTest1() {
			@Override
			public int add(int x, int y) {				
				return x+y;
			}
		};
		
		int result = lamda1.add(1, 9);
		System.out.println(result);
		
		/* 
		 * LambdaTest1인터페이스에 들어갈 객체는 반드시 LambdaTest1인터페이스를
		 * 상속받아, 추상메서드를 구현한 클래스여야 한다.
		 * 익명 내부 클래스의 문법처럼 이름없는 클래스의 형태로 객체를 생성해야 하지만, 불필요한 
		 * 코드작성을 줄이는 방식으로 간소화되었다. 
		 * 
		 * 함수형 인터페이스는 고정적으로 1개의 추상메서드만 보관하고 있으므로, 구현해야할
		 * 함수의 이름, 반환형, 매개변수의 자료형등은 생략이 가능.
		 * */
		LambdaTest1 lambda2 = (x , y) -> {return x+y;};
		result = lambda2.add(5, 5);
		System.out.println(result);
	}

}











