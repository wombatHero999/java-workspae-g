package com.kh.chap01_innerClass.part02_static;

public class OuterClass2 {
	private String str ="필드";
	private static String staticStr = "정적필드";
	
	/* 
	 * 정적 내부 클래스
	 *  - 외부클래스가 로드되는 시점에서 정적 내부클래스도 함께 static영역으로 저장공간을 할당받는다.
	 *  - 외부클래스와 종속적이지 않다.
	 *  - 하나의 클래스 파일에 다양한 클래스를 설계할 때 사용.(DTO)
	 *  - 외부클래스와 무관하게 다른클래스에서도 이용할 내부클래스는 정적내부클래스로 사용(Builder)
	 * 
	*/
	public static class staticInnerClass{ // OuterClass2.staticInnerClass
		int num = 100;
		static int num2 = 100;
		
		public void test() {
			//System.out.println(str);
			System.out.println(staticStr);
			System.out.println(num);
			System.out.println(num2);
		}
		
		public static void sTest() {
			//System.out.println(str);
			System.out.println(staticStr);
			//System.out.println(num);
			System.out.println(num2);
		}
	}
	
	
}












