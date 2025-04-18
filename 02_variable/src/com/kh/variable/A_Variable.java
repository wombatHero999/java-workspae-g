package com.kh.variable;

public class A_Variable {
	
	public void printVariable() {
		
		System.out.println("==== 변수 X =====");
		
		System.out.println("시급 : 8500");
		System.out.println("근무시간 : 6");
		System.out.println("근무일수 : 5");
		
		System.out.println("민경민 : "+ 8500 * 6 * 5 +"원");
		System.out.println("민경민2 : "+ 8500 * 6 * 5 +"원");
		System.out.println("민경민3 : "+ 8500 * 6 * 5 +"원");
		System.out.println("민경민4 : "+ 8500 * 6 * 5 +"원");
		System.out.println("민경민5 : "+ 8500 * 6 * 5 +"원");
			
		System.out.println("==== 변수 사용 후 ====");
		
		// 변수 선언
		int pay = 8500;
		int time = 6;
		int day = 5;
		
		System.out.println("시급 : "+pay);
		System.out.println("근무시간 : "+time);
		System.out.println("근무일수 : "+day);
		
		System.out.println("민경민 : "+ pay * time * day +"원");
		
		/* 
		 * 변수를 사용하는 이유
		 * 1. 가독성 확보 
		 * 2. 재사용성 증대
		 * 3. 유지보수성 증대
		 * 4. 메모리 효율성 증대
		 * */		
	}
	
	public void declareVariable() {
		/* 
		 * 변수의 선언
		 * [표현법]
		 * 자료형 변수명;
		 * 
		 * 자료형 : 어떤 값을 담아낼지, 어떤 크기의 값을 담아낼지에 따라
		 *         다르게 지정해야 하는 부분
		 * 변수명 : 변수의 이름을 지정하는 부분.
		 * 
		 * 변수명 명명규칙
		 * 1. 변수명은 소문자로 시작하게끔 작명한다
		 * 2. 낙타등표기법을 사용한다(camel case)
		 * ex) String userFirstName => 이어쓰기한 단어의 첫글자를 대문자로 바꿈
		 * 
		 * 주의점
		 * 1. 변수의 선언은 클래스아래, 메소드 내부에서만 가능.
		 * 2. 같은 영역 안에서 동일한 이름의 변수명 사용 불가.
		 * 3. 해당 영역 안에서 선언한 변수는 해당 영역에서만 사용 가능
		 */
		
		// 1. 논리형 변수 선언
		boolean isTrue;
		
		// 2. 숫자형
		// 2_1. 정수형
		byte bNum; // 1byte
		short sNum;// 2byte
		int iNum;// 4byte ==> 정수 대표자료형
		long lNum;// 8byte
		
		// 2_2. 실수형
		float fNum; // 4byte 소수점 7자리까지 표현
		double dNum; // 8byte 소수점 15자리까지 표현 ==> 실수 대표자료형
		
		// 3. 문자형
		char ch; // 2byte
		
		// 4. 문자열(참조자료형) => 기본자료형에 포함되지 않는다.
		String str;
		
		// 변수에 값 대입 == 초기화 완료
		isTrue = true;
		
		// 값과 값의 연산
		bNum = 1;
		sNum = 2;
		iNum = 4;
		lNum = 8L; // L추가시 정수값을 Long으로 해석
		
		// 실수형
		fNum = 4.0f; // 실수형 리터럴값을 float에 저장시 반드시 f를 붙여줘야함.
		dNum = 8.0;
		
		//문자형
		ch = 'A';
		str = "ABCCC";
		
		System.out.println(ch);
	}
	
	public void initVariable() {
		// 변수에 값을 대입 == 초기화
		boolean isTrue = false; // 초기화 완료
		byte bNum = 1;
		
		int longInteger = 999_999_999;
		bNum = 15;
	}
	
	public void constant() {
		
		final int age = 20;
		
		//age = 21;
		
		//상수값을 저장하는 변수는 무조건 "대문자"를 활용한다.
		final int AGE = 21;
	}
	
	
	
	
	
	
}





