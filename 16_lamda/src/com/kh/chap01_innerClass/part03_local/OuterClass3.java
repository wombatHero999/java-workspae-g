package com.kh.chap01_innerClass.part03_local;

public class OuterClass3 {

	private String str ="필드";
	private static String staticStr = "정적필드";
	
	public Runnable getRunnable(int num) {
		
		/* 지역 내부 클래스
		 *  - 지역변수처럼 메서드 내부에서 클래스를 정의하여 사용하는 것.
		 *  - 메서드 안에서만 사용가능하며, 메서드가 호출될 때 생성된다.
		 *  - 지역내부클래스안에서 사용되는 지역변수는 "상수"(final)처럼 취급된다.
		 *    (메모리효율성)
		 * 
		 * 메모리복습
		 * 1) stack
		 *  - 메서드 호출시 스택에는 메서드프레임이 쌓인다.
		 *  - 메서드 프레임 내부에는 지역변수를 위한 저장공간이 할당.
		 *  - 메소드 종료시에는 메서드프레임이 제거되면서 지역변수의 저장공간도 함께 소멸된다.
		 * 
		 * 2) static키워드가 붙은 변수는 static메모리 영역에 저장공간이 할당.
		 *    static final(상수) -> static메모리 내부의 constant pool에 저장공간이 추가.
		 *    final 키워드만 붙은 변수 -> static메모리 내부의 constant pool에 저장공간이 할당. 
		 */
		int local = 1;
		// local = 2;
		// 지역변수는 지역내부클래스에서 사용되는 경우, final예약어가 붙은 것처럼 취급된다.
		// 이유는, stack메모리에서 지역변수의 저장공간이 소멸된 후 , 참조를 유지하기 위해.
		class LocalInnerClass implements Runnable{
			private int innerNum = 10;
			
			@Override
			public void run() {
				System.out.println(local); // 메서드 소멸시 지역변수의 저장공간도 함께 소멸.
				// local = 2; 
				System.out.println(num);
				System.out.println(innerNum);
				System.out.println(str);
				System.out.println(staticStr);
			}
		}
		
		return new LocalInnerClass();
	}
	
	
}















