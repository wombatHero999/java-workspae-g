package com.kh.chap3_generic.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap3_generic.model.vo.Child1;
import com.kh.chap3_generic.model.vo.Child2;
import com.kh.chap3_generic.model.vo.Generic;
import com.kh.chap3_generic.model.vo.Generic2;
import com.kh.chap3_generic.model.vo.Parent;

public class Run {
	
	public static void main(String[] args) {
		// 1. 제네릭 등장이전
		//   - 컬렉션에 데이터를 추가할때 항상 Object객체로 저장
		//   - 저장된 데이터를 꺼내서 사용시 "반드시 형변환"이 필요
		//   - 단, 형변환시 잘못된 자료형으로 형변환하거나, 담겨있는 데이터가 형변환하고자 하는 타입이 아닐
		//     경우 에러가 발생할 수 있다.
		List l = new ArrayList(); 
		for(Object o : l) {
			System.out.println((String) o); // o에 담긴 데이터가 문자열이 아닐수도 잇따.
		}
		
		/* 2. 제네릭(JDK 1.5버전에서 제네릭 등장)
			 - 데이터의 자료형을 일반화 시켜서 여러 자료형을 다룰 수 있게 만든 문법
			 - 클래스의 메서드의 반환형, 매개변수, 필드의 자료형들을 "미리 지정하지 않고" 파라미터화 하여 나중에 사용할 수
   			   있게 만드는 방법.
   			 - 제네릭을 사용하면 다양한 타입(자료형)을 저장할 수 있기 때문에 "타입변수"라고 불린다.
   			 - 제네릭을 사용하면 런타임 시점이 아닌 "컴파일"시점에서 에러를 캐치할 수 있으므로 "타입 안전성"
   			   을 확보할 수 있다.
		*/
		
		Generic<Integer, String> g1 = new Generic<>();
		g1.setT(1111);// 컴파일 시점에 T는 Integer로 확정
		g1.setG("String");
		g1.printTest("String");
		g1.printTest(12345);
		g1.<String>printTest("111");
		
		Generic<String, Integer> g2 = new Generic<>();
		//g2.setT(1111); // g2에서 T는 String자료형
		
		// 대입될 데이터의 타입을 미리 정해두지 않고, 컴파일 시점에서 정해주므로 재사용성이 크게 증가한다.
		
		// 3. 제네릭의 extends
		//  - 제네릭에서의 extends는 클래스간의 상속개념이 아닌, 제네릭으로 지정한 자료형을 "제한"
		//    시키는데 사용한다.
		//  - <T extends Parent>  : 타입변수에는 Parent클래스 및 Parent클래스를 상속받은 
		//                          자료형만 제시할 수 있다.
		//  - <T extends Interface> : Interface를 구현한 클래스만 타입변수에 제시 가능.
		Generic2<Parent> parent = new Generic2<>();
		Generic2<Child1> child1 = new Generic2<>();
		// Generic2<String> str = new Generic2<>(); // Parent의 자식이 아니므로 객체 생성 불가. 
		
		parent.setT(new Parent());
		parent.printing();
		
		/* 
		 * 4. 와일드카드(?)
			- Generic에 들어가야할 자료형을 모르는 경우 사용.
			- 와일드카드(?)의 의미는 어떤 자료형이 들어올지 모른다(unknown)의 의미로 사용. ?가 어떤 자료형이든 올수 있따는
			  (any)의 의미가 아니다.
			- ?에는 super와 extends를 사용하여 와일드카드의 범위를 제한할 수 있다.
			- ? extends T : 상한제한 => 와일드 카드의 범위를 T또는 T의 자식들로 제한
			- ? super T   : 하한제한 => 와일드 카드의 범위를 T 또는 T의 조상들로 제한
		*/
		Generic2<?> unknown = new Generic2<>();
		// unknown.setT(new Parent());
		// ?는 자료형의 범위가 정해져 있지 않은 상태(unknwon).
		// ?로 타입변수 사용시 올바른 값이 들어갔는지 검사가 불가능하므로 에러를 발생.
		// ?의 제대로된 사용을 위해선 extends와 super를 활용하여 ?의 범위를 정해줘야 한다.
		
		// 1) extends를 통한 와일드카드 범위 제한
		Generic2<? extends Parent> unknown2 = new Generic2<>();
		// ? 의 범위 : Parent, Parent의 자식들.
		
		// Child1 c = (Child1) new Parent();
		// Child2 p1 = new Child1();
		
		//unknown2.setT(new Parent()); // ?범위에 Parent의 자식클래스도 포함되어있으므로, "대입 불가."
		//unknown2.setT(new Child1()); // ?범위에 Child2도 포함되어있으므로, "대입불가."
		
		Parent p = unknown2.getT(); // ?가 Parent이든, 그 자식이든 다형성에 의해 값을 추출하여 대입 가능.
		// extends를 통한 타입 제한은 데이터를 "가져올때" 사용한다.
		
		// 2) super를 통한 와일드카드 범위 제한 : 하한선 경계 설정.
		//  ? super Parent : 와일드카드의 범위는 Parent, Parent의 조상클래스들   
		Generic2<? super Parent> unknown3 = new Generic2<>();
		// ?의 범위 : Parent와, Object
		
		unknown3.setT(new Parent()); // 다형성의 업캐스팅 발생.
		// Object o = new Parent();
		// Parent p2 = new Parent();
		unknown3.setT(new Child1());
		unknown3.setT(new Child2()); // 최소 자료형이 Parent이기 때문에 대입에 문제 없음.
		// 값을 "대입"할 때는 super를 쓰는게 적절하다. 
		
		// Parent p3= unknown3.getT(); // ?는 Object일수도 있음
		
		Parent p4 = new Parent(); 
		// Parent p5 = new Object(); // 상속관계긴하지만, 저장시 다운캐스팅필요하므로 컴파일 에러 발생
		
		
		
	}
}



















