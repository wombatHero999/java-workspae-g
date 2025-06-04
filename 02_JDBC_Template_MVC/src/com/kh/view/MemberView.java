package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

// view : 사용자가 보게될 시각적인 요소를 담당
public class MemberView {
	private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in); 
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** 회원 관리 프로그램 *****");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 검색");
			System.out.println("4. 회원 이름 키워드 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------");
			System.out.print("이용할 메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : insertMember(); break;
			case 2 : selectAll(); break;
			case 3 : selectByUserId(); break;
			case 4 : selectByUserName(); break;
			case 5 : updateMember(); break;
			case 6 : deleteMember(); break; // 탈퇴할 회원의 ID 입력받아서 탈퇴처리하기
			case 0 : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("잘못된 메뉴를 선택했습니다. 다시 입력해주세요.");
			}
		}
	}

	private void deleteMember() {
		// TODO Auto-generated method stub
		
	}

	private void updateMember() {
		// TODO Auto-generated method stub
		
	}
	
	// 이름으로 회원정보검색
	private void selectByUserName() {
		System.out.print("회원 이름 키워드 검색 : ");
		String keyword = sc.nextLine();
		
		mc.selectByUserName(keyword);
	}

	private void selectByUserId() {
		// TODO Auto-generated method stub
		
	}

	private void selectAll() {
		// TODO Auto-generated method stub
		
	}
	
	private void insertMember() {
		// 회원가입 페이지
		System.out.println("## 회원추가 페이지 ##");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine(); 
		
		System.out.print("비번 : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("핸드폰 : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		mc.insertMember(memberId, memberPwd, memberName, gender, age, email, address, phone );
	}

	public void displaySuccess(String string) {
		System.out.println(string);
	}

	public void displayFail(String string) {
		System.out.println(string);
	}

	public void displayNodata(String string) {
		System.out.println(string);
	}

	public void displayListData(List<Member> list) {
		list.stream()
			.forEach(System.out::println);
	}
	
}















