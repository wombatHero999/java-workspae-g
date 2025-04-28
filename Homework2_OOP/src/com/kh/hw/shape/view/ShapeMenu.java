package com.kh.hw.shape.view;

import java.util.Scanner;

import com.kh.hw.shape.controller.SquareController;
import com.kh.hw.shape.controller.TriangleController;

public class ShapeMenu {
	
	private Scanner sc = new Scanner(System.in);
	private SquareController scr = new SquareController();
	private TriangleController tc = new TriangleController();
	

	public void inputMenu() {
		while(true) {
			System.out.println("===== 도형 프로그램 ===== ");
			System.out.println("3. 삼각형 ");
			System.out.println("4. 사각형 ");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 :  ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 3: 
				triangleMenu();
				break;
			case 4:
				squareMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void triangleMenu() {
		while(true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: 
				inputSize(3, 1);
				break;
			case 2:
				inputSize(3, 2);
				break;
			case 3:
				printInformation();
				break;
			case 9:
				System.out.println("메인으로");
				return;
			default : 
				System.out.println("잘못된 번호입니다.");
			}
		}
		
	}

	public void squareMenu() {
		
	}
	
	public void inputSize(int type, int menuNum) {
		
		if(type == 3 && menuNum == 1) {
			System.out.print("높이 : ");
			double height = sc.nextDouble();
			
			System.out.print("너비 : ");
			double width = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("삼각형 면적 : "+tc.calcArea(height, width));
		}
		else if(type == 3 && menuNum == 2) {
			System.out.print("색깔을 입력하세요 : ");
			String color = sc.nextLine();
			
			tc.paintColor(color);
			System.out.println("색이 수정되었습니다.");
		}
		
	}
	
	public void printInformation(int type) {
		if(type == 3) {
			String result = tc.print();
			System.out.println(result);
		}else {
			System.out.println(scr.print());
		}
	}
}













