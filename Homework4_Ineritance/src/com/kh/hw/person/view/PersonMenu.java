package com.kh.hw.person.view;

import java.util.Scanner;

import com.kh.hw.person.controller.PersonController;
import com.kh.hw.person.model.vo.Student;

public class PersonMenu {

	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();

	public void mainMenu() {
		while(true) {
			int[] personCount = pc.personCount();
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 "+personCount[0]+"명입니다. ");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 "+personCount[1]+"명입니다. ");
			
			// M과 N에 들어가는 숫자는 PersonController(pc)클래스에 있는  
			// personCount()메소드의 반환 값을 이용하여 출력 
			
			System.out.println("1. 학생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기 ");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
		
	}

	public void studentMenu() {
		while(true) {
			System.out.println("1. 학생 추가  ");
			System.out.println("2. 학생 보기  ");
			System.out.println("9. 메인으로   ");
			
			int count = pc.personCount()[0];
			if(count == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화 되지 않습니다.");
			}
			System.out.println("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 2 :
				printStudent();
				break;
			case 9 :
				System.out.println("메인으로");
				return;
			case 1 :
				if(count != 3) {
					insertStudent();
					break;
				}
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}

	public void employeeMenu() {

	}

	public void insertStudent() {
		while(true) {
			System.out.print("학생 이름 : ");
			String name = sc.nextLine();
			
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			sc.nextLine();
			
			System.out.print("학생 전공 : ");
			String major = sc.nextLine();
			
			pc.insertStudent(name, age, grade, major);
			
			int count = pc.personCount()[0];
			if(count != 3) {
				System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
				char ch = sc.nextLine().toLowerCase().charAt(0);
				if(ch == 'n') {
					break;
				}
			}else {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생메뉴로 갑니다.");
				break;
			}
		}
	}

	public void printStudent() {
		// pc의 printStudent() 메소드의 반환 값을 이용하여 학생 객체 배열에 저장된 
		// 모든 데이터 출력  
		
		Student[] arr = pc.printStudent();
		
		for(Student s : arr) {
			if(s != null)
				System.out.println(s);
		}
		
		
	}

	//
	public void insertEmployee() {

	}

	public void printEmployee() {

	}

}







