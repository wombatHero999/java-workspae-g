package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;

	public BookMenu() {
		// 파일이 없을 때 만들어주기 위해 BookController(bc)에 makeFile() 호출
		bc.makeFile();
		// 필드에 있는 bArr에 bc의 fileRead() 반환 값 대입
		bArr = bc.fileRead();
	}

	public void mainMenu() {
		while(true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch (menu) {
			case 1:
				fileSave();
				break;
			case 2:
				fileRead();
				break;
			case 9:
				return;
			default:
			}
		}

	}

	public void fileSave() {
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 명 :  ");
		String author = sc.nextLine();
		
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String date = sc.nextLine();
		
		System.out.print("할인율 : ");
		double discount = sc.nextDouble();
		sc.nextLine();
		
		String[] arr = date.split("-");
		Calendar c = new GregorianCalendar(
				Integer.parseInt(arr[0]),
				Integer.parseInt(arr[1]) - 1, 
				Integer.parseInt(arr[2]));
		
		Book b = new Book(title, author, price, c, discount);
			
		// 입력 받은 출판날짜를 split()를 통해 년, 월, 일로 나누고 Calendar에 담음 
		// 각 요소와 새로 만든 Calendar를 Book 객체에 담고  
		// 비어있는 Book객체 배열(bArr)에 담아 bc에 fileSave()에 매개변수로 전달
		for(int i = 0; i<bArr.length; i++) {
			if(bArr[i] == null) {
				bArr[i] = b;
				break;
			}
		}
		
		bc.fileSave(bArr);
	}

	public void fileRead() {
		Book[] arr = bc.fileRead();
		for(Book b : arr) {
			if(b != null)
				System.out.println(b);
		}
	}

}













