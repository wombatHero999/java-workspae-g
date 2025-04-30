package com.kh.chap02_string.controller;

public class A_StringPool {
	// String는 불변클래스(변하지 않는 클래스)
	// String은 기존에 담겨있던 값이 수정되는 순간 원래 담겨있던 공간(주소값)에서 수정되지 않는다.
	// String은 새로운 값이 추가되는 순간 새로운 저장공간이 할당된다.
	
	// 문자열 상수 풀(String constant pool)
	//  - 문자열 데이터가 담기는 영역으로, heap메모리영역상에 고정적으로 할당되어 있다.(jdk7 이상)
	
	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		// str1 == str2 ==> false
		System.out.println(str1 == str2);// false
		System.out.println(str1.equals(str2));// true
		System.out.println(str1.hashCode()); // 상수풀의 주소값으로 사용
		System.out.println(str2.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
	
	
}







