package com.kh.chap05_method.controller;

public class OverloadTest {
	/* 
	 * 메소드 오버로딩(메소드 추가적재)
	 *  - 한 클래스 내에 "같은 이름의 메소드를 여러개" 정의할 수 있는 방법
	 *  - 매개변수의 자료형, 매개변수의 개수 및 순서를 다르게 작성해줘야 한다.
	 *  - 그 외, 매개변수의 이름, 접근제한자, 반환형은 다르더라도 메서드 오버로딩에 영향을 주지 않는다.
	 * */
	
	public void test() {
		
		// 메서드 오버로딩이 뭐였지..? System.out.println();
		// System.out.println();
	}
	
	public void test(int a) {
		
	}
	
	public void test(int a , String s) {
		
	}
	
	public void test(String s, int a) {
		
	}
	
	public void test(String s) {
		
	}
	
	// 에러발생 케이스들
	// 매개변수의 이름은 오버로딩과 상관 없다.
//	public void test(String s1) {
//		
//	}
	
	// 반환형은 메서드 오버로딩과 상관 없다.
//	public String test(String s) {
//		return "ㅋㅋ";
//	}
	
	// 접근제한자는 오버로딩과 상관 없다.
//	private void test(String s) {
//		
//	}

}


















