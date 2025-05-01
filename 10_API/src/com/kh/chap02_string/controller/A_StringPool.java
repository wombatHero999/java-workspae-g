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
	
	
	public void method2() {
		String str1 = "hello"; // 상수풀에 저장된 적이 없으므로 상수풀에 주소값 할당
		String str2 = "hello"; // 상수풀에 저장된 데이터이므로 상수풀내의 주소값을 그대로 할당(얕은복사)
		String str3 = "hello"; // 상수풀에 저장된 데이터이므로 상수풀내의 주소값을 그대로 할당(얕은복사)
		
		str2 += "world"; // "helloworld"문자열이 상수풀에 있나 검사 후 , 주소값 할당
		
		/*
		 * 자바에서는 문자열 리터럴을 사용시 문자열리터럴을 상수풀에 보관한다.
		 * 
		 * jvm 문자열상수풀 동작방식
		 * 1. 프로그램실행 도중 문자열 리터럴을 만나면, 문자열 리터럴값이 상수풀에 보관되어 있나 검사
		 * 2. 만약 상수풀에 저장된 리터럴이 아니라면, 문자열의 hashcode값을 주소값으로 상수풀에 저장. => str1
		 * 3. 만약 이미 상수풀에 저장되어있떤 문자열이라면 저장된 주소값을 반환시킨다. => str2
		 *  */		
		
		// str1 == str2 // false
		System.out.println(str1 == str2); // true ==> 동일한 주소값에 데이터가 저장.
		
		System.out.println(str1.hashCode());
		System.out.println(str3.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str3));
	}
	
	/*
	 * 자바에서 가장 많이 사용되는 객체가 String
	 * String이 메모리영역에서 차지하는 비중이 크기 때문에 메모리부족 이슈가 종종 발생.
	 * 이 메모리 부족이슈를 해결하기 위해 나온 것이 문자열 상수풀.
	 * 
	 * 단, 문자열 상수풀로도 감당이 불가능할 정도로 문자열 연산이 빈번한 경우, 문자열(String)보다는
	 * 문자열기반 가변클래스인 (StringBuilder, StringBuffer)를 사용하는 것을 권장.
	 *  */
	
	
	
	
	
	
	
}







