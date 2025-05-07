package com.kh.practice.numRange.controller;

import com.kh.practice.numRange.exception.NumRangeException;

public class NumberController {
	
	public NumberController() {
		
	}
	
	public boolean checkDouble(int num1, int num2) throws NumRangeException{
		// 매개변수로 들어온 두 값이 1~100 사이 일 때 num1이 num2의 배수면 true,   
		  // 배수가 아니라면 false 반환 
		
		if(!(num1 >= 1 && num1 <= 100) || !(num2 >= 1 && num2 <= 100)) {
			throw new NumRangeException("1부터 100사이의 값이 아닙니다.");
		}
		return num1 % num2 == 0;
		// 1~100사이가 아니라면 NumRangeException발생, 에러 메시지는 출력 값 참고 
	}
}













