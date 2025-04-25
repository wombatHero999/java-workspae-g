package com.kh.chap04_constructor.model.vo;

public class User {
	
	// 필드부
	private String userId;
	private int age;
	private char gender;
	
	// 생성자부
	/*
	 * 생성자 작성방법
	 * 
	 * 접근제한자 클래스명(매개변수){
	 * 	 // 생성자를 통해 객체 생성시 초기화시킬 필드값들을 나열
	 * }
	 * 
	 * 작성목적
	 * 1. 객체를 생성하기 위한 목적.
	 * 2. 객체 생성과 객체 내부의 필드값을 초기화할 목적.
	 *  
	 * 주의사항
	 * 1. 클래스명과 동일하게 작성해야한다.
	 * 2. 반환형이 존재하지 않는다.
	 * 3. 여러개 생성이 가능하지만, 매개변수가 중복 되면 안된다.
	 * 4. 매개변수 생성자를 명시적으로 작성하게 되면 jvm이 기본생성
	 * 자를 자동으로 만들어주지 않는다.  
	 *  */
	 // 기본생성자(매개변수가 빈 생성자)
	 public User() {
		 // 객체를 생성할 목적으로만 사용.
		 // 이 기본생성자는 작성하지 않아도 오류가 나지 않음.
		 // JVM이 자동으로 만들어 줬기 때문에 문제가 없던 것.
		 // 단, 내가 생성자를 한개 이상 만들어둔 경우 JVM이
		 // 자동생성 해주지 않는다.
	 }
	 
	 public User(String userId, int age, char gender) {
		 this.userId = userId;
		 this.age = age;
		 this.gender = gender;
	 }
	
	
	
	// 메서드부
	

}












