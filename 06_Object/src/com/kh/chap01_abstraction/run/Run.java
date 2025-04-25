package com.kh.chap01_abstraction.run;

import com.kh.chap01_abstraction.model.vo.Student;

public class Run {
	//main + ctrl + spacebar
	public static void main(String[] args) {
		/* 
		 * 1. 객체지향언어 : 객체를 중심으로 객체간의 상호작용을 통해 작동하는 프로그래밍 
		 *                방식
		 * 2. 객체 : 클래스를 통해 메모리(heap)에 저장공간이 할당된 데이터.
		 * 
		 * 3. 구현하고자 하는 프로그램상의 목적에 맞는 객체를 만드는 방법
		 * 
		 * 4. 클래스는 객체의 속성과 기능을 담아내는 그릇
		 * 
		 * 5. 추상화 & 캡슐화 과정이 필요 
		 *  - 내가 구현하고자하는 프로그램의 목적에 맞는 객체를 선정 후, 그 객체들이
		 *    가지고 있을 핵심적인 역할의 속성과 기능만 남기는 행위. 
		 * */
		// 추상화
		
		// 1. 학생객체
		// 홍길동 학생 객체 만들기
		Student hong = new Student();
		hong.name = "홍길동";
		hong.age = 20;
		hong.height = 180.5;
		
		Student tae = new Student();
		tae.name = "안태형";
		tae.age = 26;
		tae.height = 175.0;
		
		tae.fight(hong);
		
		System.out.println(hong.name+""+hong.age+""+hong.height);
		System.out.println(tae);
	}
	
}







