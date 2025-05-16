package com.kh.chap01_constant.model.vo;

// 자동차의 색에대한 상수값을 관리할 클래스
public class Color {
	public static final Color BLACK = new Color(0,"black");
	public static final Color RED = new Color(1,"red");
	public static final Color WHITE = new Color(2,"white") {
		public void method() { // 익명 내부 클래스 생성방식
			System.out.println("저는 흰색 메서드 입니다.");
		}
	};
	
	private int color; // 0 , 1 , 2
	private String color2;// 검은색, 빨간, 블루
	
	private Color(int color, String color2) {
		this.color = color;
		this.color2 = color2;
	}
	
	public void method() {
		System.out.println("상수");
	}
	
	
}














