package com.kh.exception.controller;

public class C_CustomException extends RuntimeException{
	// 예외클래스 직접 생성하기.
	//  - 나만의 예외클래스를 만든 후, 예외클래스를 상속받는다.
	//  - super키워드를 통해 에러문자열을 부모 예외클래스에게 전달한다.
	public C_CustomException() {
		
	}
	
	public C_CustomException(String msg) {
		super(msg);
	}
}















