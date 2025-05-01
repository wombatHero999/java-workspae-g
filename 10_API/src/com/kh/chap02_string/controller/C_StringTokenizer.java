package com.kh.chap02_string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizer {
	
	// StringTokenizer : 문자열을 구분자를 기준으로 토큰단위로 분리시키는 클래스.
	public void method() {
		
		String str = "Java,Oracle,JDBC,HTML,Server";
		
		// 구분자를 통해 문자열을 분리시키는 방법
		// 1. String의 split()메서드를 이용하는 방법
		//    문자열.split(구분자) : String[]
		//    너무 큰 문자열을 구분할 경우, 메모리 부족 에러가 발생할 수 있다.
		String[] arr = str.split(",");//["java" , "oracle" , "jdbc" , ...]
		
		for(String s : arr) {
			System.out.println(s);
		}
		
		System.out.println("=================================================");
		// 2. StringTokenizer클래스를 이용하는 방법
		//    StringTokenizer stn = new StringTokenizer(문자열,구분자);
		StringTokenizer stn = new StringTokenizer(str, ",");
		
		System.out.println("분리된 문자열의 갯수 : "+stn.countTokens());
		
		// stn.countTokens() 현재, 남은 토큰의 갯수를반환하기 때문에 일반 반복문에서 사용 불가.
//		for(int i =0; i<stn.countTokens(); i++) {
//			System.out.println("현재 토큰의 문자열 : "+stn.nextToken());
//		}
		
		// stn.hasMoreTokens() => 토큰갯수가 0보다 큰지 확인하는 함수.
		while( /* stn.countTokens() > 0 */ stn.hasMoreTokens() ) {
			System.out.println("현재 토큰의 문자열 : "+stn.nextToken());
		}
		
		// StringTokenizer는 재사용이 불가능 하다.
		System.out.println("현재 토큰의 문자열 : "+stn.nextToken());
	}
	
}













