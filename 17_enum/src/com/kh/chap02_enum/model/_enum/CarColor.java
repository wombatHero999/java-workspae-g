package com.kh.chap02_enum.model._enum;

import java.util.Arrays;

public enum CarColor {
	/* 
	 * Enum -> Enumeration(열거)의 약자. 클래스 내부의 상수값들을 열거하여 enum이라는 명칭을 사용
	 * 객체단위 상수값들을 간결하게 다루기 위한 클래스가 enum.
	 * 
	 * */
	BLACK(0){
		@Override
		public void printTest() {
			System.out.println("검은색입니다.");
		}
	}, // public static final CarColor BLACK = new CarColor();
	RED(1){
		@Override
		public void printTest() {
			System.out.println("빨간색입니다.");
		}
	}, 
	WHITE(2){
		@Override
		public void printTest() {
			System.out.println("흰색입니다.");
		}
	};
	// 묵시적으로 public static final CarColor가 붙어있다.
	private int color;
	
	private CarColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	// values() : enum내부의 상수값들을 모아서 배열로 반환해주는 메서드
	// enum내부의 필드값을 통해 enum을 찾을 수 있는 메서드
	public static CarColor valueOf(int color) {
		return Arrays.stream(values())
			.filter( _enum -> _enum.color == color)
			.findFirst()
			.orElseThrow(() -> new RuntimeException("일치하는 컬러가 없습니다."));		
	}
	
	public static CarColor valueOf2(int color) {
		switch(color){
		case 0 :
			return BLACK;
		case 1 :
			return RED;
		case 2 :
			return WHITE;
		default :
			throw new RuntimeException("일치하는 색이 없습니다.");
		}
	}
	
	public abstract void printTest();
}


















