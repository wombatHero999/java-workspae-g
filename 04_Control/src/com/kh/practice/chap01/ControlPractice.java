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
		System.out.print("키를 입력하세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게를 입력해주세요 : ");
		double kg = sc.nextDouble();
		
		double BMI = kg / (height * height);
		
		System.out.println("BMI 지수 : "+BMI);
		if(BMI < 18.5) {
			System.out.println("저체중");
		}else if(BMI < 23) {
			System.out.println("정상체중");
		}else if(BMI < 25) {
			System.out.println("과체중");
		}else if(BMI < 30){
			System.out.println("비만");
		}else {
			System.out.println("고도비만");
		}
	}

	public void practice8() {

		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("연산자를 입력 (+,-,*,/,%) : ");
		char ch = sc.nextLine().charAt(0);
		
		if(num1 > 0 && num2 > 0) {
			System.out.println("양수만 입력해주세요.");
			return;
		}
		
		if(!(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%')) {
			System.out.println("잘못입력했습니다. 프로그램을 종료합니다.");
			return;
		}
		System.out.printf("%d %c %d = ", num1,ch,num2);
		switch(ch) {
		case '+' :
			System.out.printf("%d", (num1+num2));
			break;
		case '-' :
			System.out.printf("%d", (num1-num2));
			break;
		case '*' :
			System.out.printf("%d", (num1*num2));
			break;
		case '/' :
			System.out.printf("%f", ((double)num1/num2));
			break;
		case '%' :
			System.out.printf("%d", (num1%num2));
			break;
		}
		
		
	}

	public void practice9() {
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		
		System.out.print("기말 고사 점수 : ");
		int finalTest = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		int report = sc.nextInt();
		
		System.out.print("출석 회수 : ");
		int attend = sc.nextInt();
		
		double mid_final = mid * 0.2;
		double final_final = finalTest * 0.3;
		double report_final = report * 0.3;
		double attend_point = attend * 1.0;
		
		double total = mid_final + final_final + report_final + attend_point;
	
		System.out.println("============== 결과 ================");
		if(attend_point <= 14) {
			System.out.println("Fail [출석 회수 부족("+attend+"/20)]");
			return;
		}
		System.out.println("중간 고사 점수(20) : "+mid_final);
		System.out.println("기말 고사 점수(30) : "+final_final);
		System.out.println("과제 점수(20) : "+report_final);
		System.out.println("출석 점수(20) : "+attend_point);
		System.out.println("총점 : "+total);
		if(total >= 70) {
			System.out.println("PASS");
		}else {
			System.out.println("Fail [점수 미달]");
		}
	}

	public void practice10() {

		System.out.println("실행할 메서드를 번호로 선택하세요(1~9) : ");
		int menu = sc.nextInt();
		
		sc.nextLine();
		
		switch(menu) {
		case 1 : 
			practice1();
			break;
		case 2 :
			practice2();
			break;
		case 3 :
			practice3();
			break;
		case 4 :
		case 5 :		
		}
	}
	
	public void practice11() {
		System.out.print("비밀번호 입력(1000~9999) : ");
		int pwd = sc.nextInt();
		
		if(!(pwd >= 1000 && pwd <= 9999)) {
			System.out.println("자리 수 안 맞음");
			return;
		}
		
		// 1234
		int first = pwd / 1000; // 1.234=> 1
		int second = pwd / 100 % 10; // 12 % 10 => 2
		int third = pwd / 10 % 10; // 123.4 => 123 => 12 / 3
		int fourth = pwd % 10; // 1234 % 10 => 몫 123 나머지 4
		
		// first 와 second, third, fourth
		// second와 third, fourth
		// third와 fourth
		if( first == second || first == third || first == fourth 
				|| second == third || second == fourth
				|| third == fourth) {
			System.out.println("중복 값 있음");
		}else {
			System.out.println("생성 성공");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
