package com.kh.operator;

public class E_LogicalNegation {
	/*
	 *  논리부정연산자 ! (단항연산자)
	 *  
	 *  논리값을 반대로 바꿔주는 연산자
	 *  
	 *  !true => false
	 *  !false => true
	 *  */
	public void method() {
		boolean b = true;
		boolean b2= !b; //false
		
		// 논리 부정 연산자는 조건식,계산식의 결과를 반대로 만들 때 사용
		// 나이가 19세 이상, 30세 미만이 아닌 사람 찾기
		// !(age >= 19 && age < 30)
		boolean b3 = !(5 > 3);
	}
	
}




