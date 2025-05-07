package com.kh.exception.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_CheckedException {
	/*
	 * CheckedException은 반드시 예외처리를 해줘야 되는 예외들
	 * (예측 불가능한 곳에서 에러가 발생할 수 있기 때문에, 반드시 예외처리를 해줘야 한다)
	 * => 외부매체와 입출력시
	 *  */
	
	public void method1() throws IOException {
		
		// Scanner와 비슷한 값을 일력받을 수 있는 객체
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자열을 입력해주세요 : ");
		
		// 1. try ~ catch문을 활용한 예외처리
//		try {
//			// readLine메서드 사용시 IOException에 대한 예외처리를 반드시 해줘야 컴파일에러가 없어진다.
//			String str = br.readLine();
//			
//		}catch(IOException e) {
//			System.out.println("IO에러발생");
//		}
		
		// 2. throws : 현재 메서드에서 예외를 처리하지 않고, 현재 메서드를 호출하는 메서드로 예외를 throw하겠다.
		//             예외처리를 위임한다.
		String str = br.readLine(); 
		System.out.println("문자열의 길이 : "+str.length());
	}
	
	public void method2() throws IOException {
		//try {
			method1();
		//}
		//catch(IOException e){
		//	e.printStackTrace();
		//}
	}
	
	/*
	 * RuntimeException : 예외가 프로그램 실행 도중 발생(런타임 에러) => 예외처리가 필수가 아니다. 
	 *                    조건문을 활용하여 에러를 해결할 수 있다.
	 * IOException : 예외가 프로그램 실행 전 발생(컴파일 에러) => 예외처리가 필수다. 반드시
	 *               예외처리 구문(try~catch, throws)으로 예외를 해결해줘야 한다.
	 *  */

}

















