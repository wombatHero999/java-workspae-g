package com.kh.chap02_encapsulation.run;

import com.kh.chap02_encapsulation.model.vo.Student;

public class Run {
	/* 
	 * 캡슐화 
	 *  -추상화를 통해 정의된 속성과 기능들을 묶어서 관리하는 기법 중
	 *   하나로, "데이터의 접근제한"을 원칙으로 외부로부터의 "데이터의
	 *   접근을 막는"역할을 한다.
	 *  -객체 내부의 데이터를 반드시 확인/사용 해야하는 상황이 있을 수
	 *   있으므로, 간접적으로 내부데이터를 처리할 수 있는 메서드를 추가로
	 *   작성한다.   
	 *  
	 *  1) 정보은닉 : private
	 *     필드들을 외부로부터 직접 접근하지 못하도록 할때 사용.
	 *  
	 *  2) setter / getter 메서드
	 *     간접적으로 객체의 필드에 값을 추가하거나, 가져올 수 있는 메
	 *     소드들.
	 * */
	public static void main(String[] args) {
		Student nam = new Student();
		nam.setName("남건후");
		nam.setAge(15);
		nam.setHeight(180.5);
		
		System.out.println(nam.getName());  
		nam.getAge();
		
		System.out.println(nam.information());
	}
}











