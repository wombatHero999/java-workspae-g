package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();

	public void mainMenu() {
		while(true) {
			System.out.println("===== 메뉴 ===== ");
			System.out.println("1. 원 ");
			System.out.println("2. 사각형 ");
			System.out.println("9. 끝내기 ");
			System.out.print("메뉴번호");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				circleMenu();
				break;
			case 2:
				rectangleMenu();
				break;
			case 9:
				System.out.println("시스템을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

	public void circleMenu() {
		while(true) {
			System.out.println("===== 원 메뉴 ===== ");
			System.out.println("1. 원 둘레 ");
			System.out.println("2. 원 둘레 ");
			System.out.println("9. 메인으로 ");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1: calcCircum();
				break;
			case 2: calcCircleArea();
				break;
			case 9: 
				return;
			}
		}
	}

	public void rectangleMenu() {

	}

	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		
		String result = cc.calcCircum(x, y, radius);
		System.out.println(result);
		// 데이터를 CircleController(cc)의 calcCircum()의 매개변수로 보내 반환 값 출력
	}

	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		
		String result = cc.calcArea(x, y, radius);
		System.out.println(result);
	}

	public void calcPerimeter() {

	}

	public void calcRectArea() {

	}

}
