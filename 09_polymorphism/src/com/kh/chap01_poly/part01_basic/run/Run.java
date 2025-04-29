package com.kh.chap01_poly.part01_basic.run;

import com.kh.chap01_poly.part01_basic.model.vo.*;

public class Run {
	
	public static void main(String[] args) {
		
		System.out.println("1. 부모타입 참조변수로 부모 객체를 다루기");
		Parent p1 = new Parent();
		p1.printParent();
		
		System.out.println("2. 자식타입 참조변수로 자식 객체 다루기.");
		Child1 c1 = new Child1();
		c1.printParent(); // 메서드 상속
		c1.printChild1();
		
		System.out.println("3. 부모타입 참조변수로 자식객체 다루기");
		Parent p2 = new Child1(); // 다형성
		Parent p3 = /* (Parent) */ new Child2(); // 업캐스팅
		// 자식에서 부모클래스로 자동형변환 ==> 업캐스팅
		// 상속 관계에서만 적용된다.
		
		 ((Child1) p2).printChild1(); // 다운캐스팅
		 // p2 참조변수로는 Parent에 있는 메서드에만 접근이 가능하므로, Child1 클래스로 강제형변환
		 // 시켜 주어야, Child1내부의 메서드에 접근 가능하다.
		 
		 /* 
		  * 상속구조의 클래스에서는 형변환이 가능하다.
		  * 
		  * 1. UpCasting
		  *  - 자식타입의 객체가 부모타입으로 형변환 되는 경우
		  *  - 형변환 연산자를 생략해도 자동으로 추가 된다.
		  * 
		  * 2. DownCasting
		  *  - 부모타입의 참조변수가 자식타입의 자료형으로 형변환 되는 경우
		  *  - 여러개의 자식타입 중 하나를 직접 기술 해줘야하므로 개발자가 형변환 연산자를
		  *    명시적으로 작성해 줘야한다.
		  * */
		 
		 // 다형성을 사용하는 이유
		 //  - 생산성, 유지보수성에 크게 기여를 하기 때문에 사용
		 //  - 부모타입으로부터 파생된 여러가지 타입의 자식 객체들을 부모 클래스 하나로 다룰 수 있기 때문에.
		 
		 // System.out.println(p1);
		 
		 // 자식객체들을 부모타입 레퍼런스배열로 다루기.
		 Parent[] arr = new Parent[4];
		 arr[0] = new Child1(1, 2, 4);
		 arr[1] = new Child2(5,7,4);
		 arr[2] = new Child2(8,9,10);
		 arr[3] = new Child1(7,7,7);
		 
		 for(int i =0; i<arr.length; i++) {
			 // 각 인덱스에 초기화된 자식객체 내부의 printChild메서드 호출하기.
			 
			 // instanceof 연산자를 사용
			 // 현재 참조변수가 어떤 클래스로 생성되었는지 확인할 수 있는 연산자
//			 if (arr[i] instanceof Child1) {
//				 ((Child1)arr[i]).printChild1();				 
//			 }
//			 else if(arr[i] instanceof Child2) {
//				 ((Child2)arr[i]).printChild2();	
//			 }
			 
			 arr[i].print(); 
			 /*
			  * 동적바인딩 : 프로그램이 실행되기 전에는 컴파일 단계에서 참조변수의 클래스의 메서드를 실행한다 라고 나와
			  * 있지만, 실제 실행시에는 자식객체 내부의 오버라이딩된 메서드를 찾아가서 실행하는 것.
			  *  */
		 }
		
	}

}
















