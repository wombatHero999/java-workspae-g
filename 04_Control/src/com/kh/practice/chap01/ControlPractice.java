package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1 :
			System.out.print("입력");
			break;
		case 2 :
			System.out.print("수정");
			break;
		case 3 : 
			System.out.print("조회");
			break;
		case 4 :
			System.out.print("삭제");
			break;
		case 7 :
			System.out.print("종료");
			break;
		default :
			System.out.print("없는");
		}
		System.out.println(" 메뉴입니다.");
	}

	public void practice2() {
		System.out.print("수자를 한개 입력 하세요 : ");
		int num = sc.nextInt();
		
		if(!(num > 0)){
			System.out.println("양수가 아니다.");
			return;
		}
		
		if(num % 2 == 0 ) {
			System.out.println("짝수다");
		}
		else {
			System.out.println("홀수다");
		}
	}

	public void practice3() {
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		
		int total = kor + math + eng;
		double avg = total / 3.0;
		
		boolean pass = kor >= 40 && math >= 40 && eng >= 40
				&& avg >= 60;
		
		if(!pass) {
			System.out.println("불합격");
			return;
		}
		System.out.println("국어 : "+kor);
		System.out.println("수학 : "+math);
		System.out.println("영어 : "+eng);
		
		System.out.println("합격");
//		if(pass) {
//			System.out.println("국어 : "+kor);
//			System.out.println("수학 : "+math);
//			System.out.println("영어 : "+eng);
//			
//			System.out.println("합격");
//		}else {
//			System.out.println("불합격");
//		}
	}

	public void practice4() {
		System.out.print("1 ~ 12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		String season = "";
		
		switch(month) {
		case 1 : case 12 : case 2 :
			season = "겨울";
			break;
		case 3 : case 4 : case 5 :
			season ="봄";
			break;
		case 6 , 7 , 8:
			season ="여름";
			break;
		case 9 : case 10 : case 11 :
			season ="가을";
			break;
		default : 
			//season ="해당하는 계절이 없습니다";
			System.out.printf("%d월은 잘못 입력된 달입니다. ", month);
			return;
		}
		System.out.printf("%d월은 %s입니다.", month, season);
	}

	public void practice5() {
		// myId , myPassword12
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String pwd = sc.nextLine();
		
		if(id.equals("myId") && pwd.equals("myPassword12")){
			System.out.println("로그인 성공");
			return;
		}
		
		if(!id.equals("myId")) {
			System.out.println("아이디가 틀렸습니다.");
		}else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}

	public void practice6() {
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String grade = sc.nextLine();
		
		switch(grade) {
		case "관리자" :
			System.out.print("회원 관리, 게시글 관리 ");
		case "회원"  :
			System.out.print("게시글 작성, 댓글작성 ");
		case "비회원" : 
			System.out.print("게시글 조회");
			break;
		default :
			System.out.println("존재하지 않는 등급입니다.");
		}
	}

	public void practice7() {

	}

	public void practice8() {

	}

	public void practice9() {

	}

	public void practice10() {

	}
}
