package com.kh.chap3_generic.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap3_generic.model.vo.Generic;

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
		
	}
}



















