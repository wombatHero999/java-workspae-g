package com.kh.chap01_innerClass.part02_static.model.vo;

public class Member {
	
	private String id;
	private String name;
	private int age;

	public Member() {
		
	}
	
	/*
	 * 빌더패턴
	 *  - 자바의 객체생성방식의 단점을 보완하기 위해 고아된 객체생성 디자인 패턴
	 *  - 정적 내부 클래스로 외부클래스 객체의 필드를 초기화하고, 외부클래스 객체를 최종적으로 생성해서 반환한다.
	 *  - 매개변수 생성자가 많아지는 경우 사용을 고려하는게 좋다.
	 *  
	 * 기존 객체생성 및 초기화 방식
	 *  1) 생성자를 이용한 객체 생성
	 *      - 객체를 생성할 때 매개변수 생성자를 통해 데이터를 초기화 함.
	 *      - 단점으로는, 필드가 많을 수록 만들어야 하는 생성자가 많아질 수 있다. 
	 *      - 생성자 매개변수의 정보를 설명할 수 없기 때문에 잘못된 값이 추가될 수 있다.
	 *      
	 *  2) setter방식을 이용한 객체 초기화
	 *      - 추가해야할 값의 정보를 확인할 수 있기 때문에 가독성은 확보되나, 코드의 길이가 길어지며
	 *        객체의 불변성이 깨질 수 있다.    
	 *  */
	
	public static class Builder{
		private String id;
		private String name;
		private int age;
		
		public Builder() {
			//return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		
		// 빌더메서드
		// 빌더클래스의 초기화된 데이터를 검증과정을 거친 후 , 외부클래스 객체의 필드로 옮기는 메서드
		public Member build() {
			Member m = new Member();
			if(id == null) { //검증과정
				//에러처리
				return null;
			}
			m.id = id;
			m.name = name;
			m.age = age;
			
			return m;
		}
	}
	
}












