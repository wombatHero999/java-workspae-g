package com.kh.chap01_innerClass.part01_instance;

public class OuterClass {
	
	private String str = "외부클래스 필드";
	private static String staticStr = "외부클래스 스태틱 필드";
	private InnerClass inner;
	
	public OuterClass() {
		inner = new InnerClass();
	}
	
	/* 
	 * 인스턴스 내부 클래스
	 *  - 외부 클래스에서만 생성하여 사용하는 객체를 선언할 때 보통 사용.
	 *  - 외부클래스의 보조적인역할의 클래스를 정의한다.
	 *  - ex) HashMap 내부의 Node, keySet, EnterySet. 컬렉션클래스들의 보조적인 역할을
	 *    하는 클래스들.
	 *  - 인스턴스 내부 클래스들은 반드시 "외부 클래스"에 의해 생성된다.
	 * */
	/* public*/ private class InnerClass {
		private int num = 100; // 필드
		public static int sNum = 100; // 정적변수 선언 가능
		// 정적변수를 자주 사용하지 않는다.
		
		private void privateMethod() {
			System.out.println(num);
			System.out.println(str);
			System.out.println(staticStr);
			System.out.println(sNum);
		}
	}
	
	public void method() {
		inner.privateMethod();
	}

}






