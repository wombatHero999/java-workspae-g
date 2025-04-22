package com.kh.operator;

public class G_Triple {
	
	public void method1() {
		/*
		 * 삼항연산자 : 3개의 값을 가지고 연산하는 연산자
		 * [표현법]
		 * 조건식 ? 조건이 true인 경우 결과값 : 조건이 false일 경우 결과값
		 *  */
		int num = 50;
		
		// num의 값이 양수인지 아닌지 판단
		boolean result = num > 0 ? true : false;
		
		System.out.println(num+"은 " + (result ? "양수입니다" : "양수가 아닙니다") );
	}
	
	public void method2() {
		int num = 0;
		
		// num의 값이 양수, 음수, 0중 무엇인지 판단.
		String result = num > 0 ? "양수" : (num == 0 ? "0" : "음수");
		System.out.println(result);
	}

}





