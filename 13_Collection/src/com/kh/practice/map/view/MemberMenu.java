package com.kh.practice.map.view;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("========== KH 사이트 =========="); 
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 :");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				joinMembership();
				break;
			case 2:
				logIn();
				memberMenu();
				break;
			case 3:
				sameName(); 
				break;
			case 9: System.err.println("종료"); return;
			default: System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	public void memberMenu() {
		while(true) {
			System.out.println("******* 회원 메뉴 ******* ");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기 ");
			System.out.println("3. 로그아웃 ");
			System.out.print("메뉴 번호 선택 :");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				System.out.println("로그아웃");
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			
			}
			
		}
		
	}
	public void joinMembership() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		boolean result = mc.joinMembership(id, new Member(password, name));
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	public void logIn() {
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비번 : ");
		String password = sc.nextLine();
		
		String name = mc.logIn(id, password);
		if(name != null) {
			System.out.println(name+"님 환영합니다");
		}else {
			System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			logIn();
		}
	}
	public void changePassword() {
//		아이디와 비밀번호, 변경할 비밀번호를 받아 mc의 chagePassword()로 보냄. 
//		  받은 결과 값이 true면 “비밀번호 변경에 성공했습니다.”,  
//		  false면 “비밀번호 변경에 실패했습니다. 다시 입력해주세요.” 출력 후 반복
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비번 : ");
		String password = sc.nextLine();
		
		System.out.print("변경할 비번 : ");
		String changePassword = sc.nextLine();
		
		boolean result = mc.changePassword(id, password, changePassword);
		
		if(result) {
			System.out.println("변경 성공");
		}else {
			System.out.println("변경 실패");
			changePassword();
		}
		
		
	}
	public void changeName() {
//		  변경할 이름을 받아 mc의 chageName()로 id와 함께 넘기고  
//		  “이름 변경에 성공하였습니다.” 출력 
//		  만일 logIn()로부터 저장되어 있는 이름을 받지 못 했다면  
//		  “이름 변경에 실패했습니다. 다시 입력해주세요” 출력 후 반복
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("비번 : ");
		String password = sc.nextLine();
		
		String name = mc.logIn(id, password);
		if(name == null) {
			System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
			changeName();
			return;
		}
		
		System.out.println("현재 저장된 이름 : "+name);
		
		System.out.print("변경할 이름 : ");
		String newName = sc.nextLine();
		
		mc.changeName(id, newName);		
		System.out.println("변경성공!");
	}
	public void sameName() {
//		검색할 이름을 받고 mc의 sameName()메소드로 넘김. 
//		반환 값을 가지고 entrySet()을 이용하여 ‘이름-아이디’ 형식으로 출력
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		TreeMap tm = mc.sameName(name);
		Set<Entry<String,Member>> entrySet = tm.entrySet();
		for(Entry<String,Member> entry : entrySet) {
System.out.println(entry.getValue().getName()+"-"+entry.getKey());
		}
		
	}
	
	
	
}















