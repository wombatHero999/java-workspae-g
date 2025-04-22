package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candys = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + candys / people);
		System.out.println("남는 사탕 개수 : " + candys % people);
	}
	
	public void practice2() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년 : ");
		int classes = sc.nextInt();
		
		System.out.print("반 : ");
		int grade = sc.nextInt();
		
		System.out.print("번호 : ");
		int number = sc.nextInt(); // 
		
		sc.nextLine();// 버퍼비워주기
		
		System.out.print("성별 : ");
		char ch = sc.nextLine().charAt(0);//
		String gender = ch == 'M' ? "남학생" : "여학생";
		
		System.out.print("성적(소숫점 아래 둘째자리까지) : ");
		double point = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은%.2f이다.",
				classes, grade, number, name, gender, point );
	}
	
	public void practice3() {
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : 
			(age <= 19 ? "청소년" : "성인");
		System.out.println(result);
	}
	
	public void practice4() {
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int total = kor + eng + math;
		double avg = total / 3.0;
		
		boolean result = kor >= 40 && eng >= 40 && math >= 40 && avg >= 60;
		
		System.out.println(total);
		System.out.println(avg);
		System.out.println( result ? "합격" : "불합격");
	}
	
	public void practice5() {
		System.out.print("주민번호 입력(- 포함) : ");
		String res = sc.nextLine();
		// 132456-2123456
		// 0123456789.....
		
		char ch = res.charAt(7); // '1' ==> 49
		String gender = ch == '1' || ch == '3' ? "남자" : "여자";
		
		System.out.println(gender);
	}
	
	public void practice6() {
		System.out.print("정수 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 : ");
		int input = sc.nextInt();
		
		boolean result = input <= num1 || input > num2;
		
		System.out.println(result);		
	}
	public void practice7() {
		System.out.print("입력 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 3 : ");
		int num3 = sc.nextInt();
		
		// num1 == num2 == num3
		boolean result = 
				num1 == num2 &&
				num1 == num3 &&
				num2 == num3;
		
		System.out.println(result);
		
	}
	public void practice8() {
		System.out.print("a사원의 연봉 : ");
		int employeeA = sc.nextInt();
		double totalResultA = employeeA + (employeeA * 0.4);
		
		System.out.print("b사원의 연봉 : ");
		int employeeB = sc.nextInt();
		double totalResultB = employeeB * 1.0;
		
		System.out.print("c사원의 연봉 : ");
		int employeeC = sc.nextInt();
		double totalResultC =employeeC + (employeeC * 0.15); 
		// employeeC * 1.15;
		// employeeC + (employeeC * 0.15);
		
		System.out.println("A사원 연봉/연봉+a : "+employeeA+"/"+totalResultA);
		System.out.println(totalResultA >= 3000 ? "3000 이상" : "3000 미만");
		
		System.out.println("B사원 연봉/연봉+a : "+employeeB+"/"+totalResultB);
		System.out.println(totalResultB >= 3000 ? "3000 이상" : "3000 미만");
		
		System.out.println("C사원 연봉/연봉+a : "+employeeC+"/"+totalResultC);
		System.out.println(totalResultC >= 3000 ? "3000 이상" : "3000 미만");
	}
	
	
	
	
	
	
	
	
	
	
	
}
