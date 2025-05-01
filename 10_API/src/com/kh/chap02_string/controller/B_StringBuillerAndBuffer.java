package com.kh.chap02_string.controller;

public class B_StringBuillerAndBuffer {
	/* 
	 * StringBuilder And StringBuffer
	 *  - 문자열 기반 가변클래스
	 *  - 문자열의 메모리 부족 이슈를 해결하기 위해 만들어진 클래스
	 *  - 두 클래스는 동일한 메서드를 가지고 있다
	 *  - 차이점은 "동기화 여부" 하나.
	 *  - StringBuilder는 동기화를 지원하지 않기 때문에 "멀티스레드 환경"에서도 좋은 성능을 보인다.
	 *  - StringBuffer는 동기화를 지원하기 때문에 "멀티스레드 환경"에서 스레드 안정성을 보장할 수 있다.
	 *    단, 성능이 좋지 못하다. 
	 * */
	public void method() {
		String str = "Hello";
		str += "World"; // 주소값 2개 사용
		
		StringBuilder sb1 = new StringBuilder(); // 
		sb1.append("Hello"); // Hello
		sb1.append("World"); // HelloWorld // 주소값 1개 사용
		
		StringBuffer sb2 = new StringBuffer("Hello"); //Hello
		sb2.append("World!!!");//HelloWorld!!!
		
		// StringBuilder 메서서들
		// index위치의 문자를 제거.
		sb2.deleteCharAt(sb2.length() -1);
		
		//W문자를 제거하고 싶다면? 인덱스 위치를 알아야함.
		//sb2.deleteCharAt( sb2.indexOf("Wo") ); // 처음 나오는 W
		
		// 특점 범위의 데이터를 삭제하는 방법
		// delete(시작인덱스, 종료인덱스)
		sb2.delete(sb2.indexOf("W"), sb2.length());
		
		System.out.println(sb2);
	}
	
	
	
	
	
	
}

















