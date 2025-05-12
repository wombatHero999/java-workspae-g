package com.kh.practice.set.view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {

	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("========== KH 추첨 프로그램 =========="); 
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색 ");
			System.out.println("9. 종료 ");
			System.out.print(" 메뉴 번호 선택 :");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				insertObject();
				break;
			case 2 :
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				return;
			}
		}
	}
	
	public void insertObject() {
		System.out.print("추가할 추첨 대상 수 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < num; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("핸드폰 번호 : ");
			String phone = sc.nextLine();
			
			Lottery l = new Lottery(name, phone);
			
			boolean result = lc.insertObject(l);
			
			if(!result) {
				System.out.println("중복된 대상입니다. 다시 입력해주세요..");
				i--;
			}
		}
		System.out.println("추가완료");
		
	}
	public void deleteObject() {
		System.out.print("삭제할 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("삭제할 전화번호 : ");
		String phone = sc.nextLine();
		
		Lottery l = new Lottery(name, phone);
		boolean result = lc.deleteObject(l);
		
		if(result) {
			System.out.println("삭제 완료.");
		}else {
			System.out.println("존재하지 않는 대상입니다.");
		}
		
	}
	public void winObject() {
		//lc에서 받아온 Set객체를 println()메소드를 통해 출력
		System.out.println(lc.winObject());
	}
	
	public void sortedWinObject() {
		//lc에서 받아온 Set객체를 Iterator를 통해 출력
		TreeSet<Lottery> ts = lc.sortedWinObject();
		
		Iterator<Lottery> lter = ts.iterator();
		while(lter.hasNext()) {
			System.out.println(lter.next());
		}
	}
	
	public void searchWinner() {
//		검색할 대상의 이름과 핸드폰 번호를 받고 매개변수 있는 Lottery 생성자를 이용해 
//		객체에 정보를 담아 lc에 객체를 보냄. 
//		받은 결과에 따라 true면 “축하합니다. 당첨 목록에 존재합니다.”, 
//		false면 “안타깝지만 당첨 목록에 존재하지 않습니다.” 출력 
		System.out.print("검색 이름 : ");
		String name = sc.nextLine();
		
		System.out.print("검색 핸드폰 : ");
		String phone = sc.nextLine();
		
		Lottery l = new Lottery(name, phone);
		boolean result = lc.searchWinner(l);
		
		if(result) {
			System.out.println("당첨");
		}else {
			System.out.println("안타깝다");
		}
		
	}
	
	
}


















