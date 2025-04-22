package com.kh.variable;

import java.util.Scanner;

public class C_Scanner {
	
	public void inputTest1() {
	
		Scanner sc = new Scanner(System.in);
		// 사용자의 인적사항을 입력받기
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		// 사용자가 입력한 값을 "문자열"로 받아오는 메서드.
		// 1. nextLine() : 사용자가 입력한 값을 "엔터"를 기준으로 "모두" 가져오는 메소드
		// 2. next() : 사용자가 입력한 값을 공백을 기준으로 "한 단어"만 가져오는 메서드.
		// 민[스페이스]경민[엔터]
		String firstname = sc.next(); // 민 
		String lastName = sc.nextLine();// [스페이스]경민
		// nextLine함수는 호출 후 "버퍼"의 값을 비워준다. => [엔터]값 소멸
		
		System.out.print("당신의 나이는 몇 살 입니까 : ");
		int age = sc.nextInt(); // 입력버퍼에 있는 다음값을 Int자료형으로 뽑아쓰겠다.
		
		sc.nextLine(); // 버퍼의 남은 엔터값 비워주기
		
		System.out.print("당신의 주소는 : ");
		// 사용자의 입력값에 공백이 포함될 여지가 있는 경우, 반드시 nextLine()을 쓴다.
		String adress = sc.nextLine();
		
		System.out.println("당신의 이름 : " + firstname+lastName);
		System.out.println("나이 : "+age);
		System.out.println("주소 : "+adress);
	}
	
	public void inputTest2() {
		
		Scanner sc = new Scanner(System.in);
		
		// 문자열을 뽑을 때 => sc.nextLine() / sc.next() 
		// 정수값을 뽑을 때 => sc.nextInt() / nextByte() / nextLong / nextShort
		// 실수값을 뽑을 때 => sc.nextDouble() / sc.nextFloat()
		// 논리형 ->  sc.nextBoolean()
		
		// 문자를 뽑는 메서드는 없다.
		// 문자를 뽑기 위해선, 문자열의 메서드를 이용해야함.
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(M/F) : "); // "M"
//		String str = sc.nextLine();
//		char a = str.charAt(0);
//		char b = str.charAt(1);
		char gender = sc.nextLine().charAt(0); 
		// "M"에서 0번째 위치의 문자 'M'
		// "male"에서 0번째 위치의 문자 => 'm'
		// "0123"
		
		System.out.println(name+"님의 성별은 "+gender+"입니다.");
		/* 
		 * 주의사항
		 * 1) sc.nextXXX() : 메소드들 뒤에 sc.nextLine()메서드가 와야 될 경우
		 *                  sc.nextLine()을 한번 더 호출하여 버퍼를 비워줘야 한다.
		 * 2) 스캐너를 통해 '문자'값을 입력 받아야 될 경우
		 *    sc.nextLine()을 통해 "문자열"을 입력받고, 그 후 charAt(인덱스)를 호출
		 *    한다.
		 * */		
	}
	
	
	
}



