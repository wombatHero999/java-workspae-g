package com.kh.chap01_abstraction.model.vo;

public class Student {
	// 속성 / [필드부]
	public String name;
	public int age;
	public double height;
	
	// 생성자 / 생성자부
	
	// 기능 / 메서드부
	public void study() {
		System.out.println("공부를 합시다");
	}
	
	public void fight(Student s) {
		String str = this.name + "학생과 "+s.name+"학생이 싸웁니다";
		System.out.println(str);
	}
	
}










