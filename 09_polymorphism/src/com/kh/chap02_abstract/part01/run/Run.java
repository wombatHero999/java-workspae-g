package com.kh.chap02_abstract.part01.run;

import com.kh.chap02_abstract.part01.model.vo.*;

public class Run {
	public static void main(String[] args) {
		
		// 추상 클래스는 객체 생성이 불가능.
		// Sports s = new Sports();
		
		Sports s; // 참조변수로는 사용 가능.
		s = new Football(); 
		
		Sports[] arr = new Sports[2];
		arr[0] = s;
		arr[1] = new Basketball();
		
		for(int i = 0; i<arr.length; i++) {
			arr[i].rule();
		}
		
		/*
		 * 추상클래스 정리
		 *  - 추상클래스란 미완성된 부분이 존재하는 클래스임을 의미.(abstract class)
		 *  - 미완성된 클래스이기 때문에 "객체 생성 불가"(단, 참조 변수로 사용 가능)
		 *  - 추상메소드가 포함된 경우 , 클래스는 반드시 추상 클래스로 정의해야 한다.
		 *  - 추상클래스는 "일반 필드, 일반 메서드, 생성자, 추상메서드"로 이루어져 있다.
		 *  
		 * 추상메서드
		 *  - 미완성된 메서드로 메서드 몸통부({})가 구현되어있지 않은 메서드
		 *  - 추상메서드는 자식클래스에서 오버라이딩을 통해 완성된다.
		 *    (자식클래스에서 오버라이딩 하지 않은 경우 에러가 발생한다)
		 *  - 추상메서드를 통해 클래스간의 통일성을 확보할 수 있다.
		 *  */
	}
}


















