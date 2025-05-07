package com.kh.view;

import java.util.Scanner;

import com.kh.controller.GameController;
import com.kh.model.vo.Characters;
import com.kh.model.vo.Monster;

public class GameMenu {
	
	private Scanner sc = new Scanner(System.in);
	private GameController gc = new GameController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("======= 메뉴 =======");
			System.out.println("1. 캐릭터 생성");
			System.out.println("2. 게임 시작");
			System.out.println("3. 캐릭터 정보 확인");
			System.out.println("4. 게임 종료");
			System.out.print("메뉴번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				createCharacter();
				break;
			case 2:
				gameStart();
				break;				
			case 3:
				characterInfo();
				break;
			case 4: 
				System.out.println("게임을 종료합니다.");
				return;
			default: 
				System.out.println("잘못된 번호입니다.");
			}
		}
		
	}

	private void characterInfo() {
		System.out.println("캐릭터 정보 : ");
		// gameController의 getCharacter()함수를 호출하여 캐릭터 정보 출력
		System.out.println(gc.getCharacter());
	}

	private void gameStart() {		
		while(true) {
			System.out.println("출전할 몬스터를 선택하세요 : ");
			System.out.println("1. 고블린(lv1) : 초보용");
			System.out.println("2. 오크(lv10) : 중수용");
			System.out.println("3. 드래곤(lv100) : 고수용");
			System.out.print("몬스터 선택 : ");
			
			int num = sc.nextInt();			
			sc.nextLine();
			
			// 존재하지 않는 번호를 입력시 재입력
			if(!(num >=1 && num <= 3)) {
				System.out.println("존재하지 않는 몬스터입니다. ");
				continue;
			}
			
			// GameController의 createMonster()함수를 호출하여 몬스터 반환 후 저장
			// GameController의 getCharacter()함수를 호출하여 내 정보 반환 후 저장
			
			Monster m = gc.createMonster(num);			
			Characters myCh = gc.getCharacter();
			System.out.println("전투를 시작합니다 !");
			
			//캐릭터의 체력이 0보다 큰 경우 전투를 진행 
			while(true) {
				System.out.println(myCh.getName()+"의 턴!");				
				System.out.println("1. 공격");
				System.out.println("2. 스킬(5레벨이상 사용가능)");
				System.out.println("3. 도망치기");			
				System.out.print(">>> ");
				int cmd = sc.nextInt();
				sc.nextLine();
				
				switch(cmd) {
				case 1:
					myCh.attack(m);
					break;
				case 2: 
					if(myCh.getLevel() < 5) {
						System.out.println("레벨 부족으로 스킬을 사용할 수 없습니다.");
						continue;
					}
					myCh.useSkill(m);	
					break;
				case 3:
					System.out.println("전투에서 도망갑니다.");
					return;
				}
				// 캐릭터의 공격 후 , 몬스터의 체력이 0이하라면 전투에서 승리 후 메인메뉴로 돌아가기 
				// 0보다 크다면 몬스터가 내 캐릭터를 공격.
				// 공격후 내 체력이 0밑으로 떨어진다면 전투 종료.
				// 전투 종료시 캐릭터의 hp를 maxHp만큼 회복
				if(m.getHp() <= 0) {
					System.out.println(m.getName()+" 처치! 전투에서 승리했습니다!!");
					System.out.println(m.getExp()+" 경험치를 획득했습니다!");					
					myCh.setExp(myCh.getExp()+m.getExp());
					break;
				}else {
					m.attack(myCh);
				}
				
				if(myCh.getHp() <= 0) {
					System.out.println("전투에서 패배했습니다!");
					break;
				}
			}
			myCh.setHp(myCh.getHp());
			return;
		}
		
	}

	private void createCharacter() {
		// gameController의 getCharacter의 반환값이 null이 아니라면 
		// "이미 캐릭터가 생성되었습니다" 출력 후 메인메뉴로
		if(gc.getCharacter() != null) {
			System.out.println("이미 캐릭터가 생성되었습니다. 메인메뉴로 돌아갑니다.");
			return;
		}
		
		System.out.print("직업을 선택하세요(1. 전사 , 2. 궁수, 3. 마법사) : ");
		int job = sc.nextInt();
		sc.nextLine();
		
		// 존재하지 않는 직업 선택시 직업을 재선택
		if(!(job >= 1 && job <= 3)) {
			System.out.println("존재하지 않는 직업입니다. 1-3번의 직업을 선택해 주세요.");
			createCharacter();
			return;
		}
		
		System.out.print("캐릭터 이름을 입력하세요 : ");
		String name= sc.nextLine();
		
		// 직업과, name을 gameController의 createCharacter함수에 담아서 전달.
		Characters c = gc.createCharacter(job, name);
		
		System.out.printf("%s 캐릭터 %s가 생성되었습니다. (LV:%d , 공격력:%d, 체력:%d)\n",
				job == 1 ? "전사" : job == 2 ? "궁수":"마법사", c.getName(),c.getLevel(), c.getAtk(), c.getHp() );
	}
	
	
}
















