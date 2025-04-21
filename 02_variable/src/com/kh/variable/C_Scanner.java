package com.kh.variable;


public class C_Scanner {
	
	public void inputTest1() {
	
		Scanner sc = new Scanner(System.in);
		// 사용자의 인적사항을 입력받기
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		// 사용자가 입력한 값을 "문자열"로 받아오는 메서드.
		// 1. nextLine() : 사용자가 입력한 값을 "엔터"를 기준으로 "모두" 가져오는 메소드
		// 2. next() : 사용자가 입력한 값을 공백을 기준으로 "한 단어"만 가져오는 메서드.
		String name = sc.next();
		
		System.out.println("당신의 이름 : " + name);
	}
}
