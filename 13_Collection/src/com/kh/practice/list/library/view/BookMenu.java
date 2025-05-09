package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);

	private BookController bc = new BookController();

	public void mainMenu() {
		while(true) {
			System.out.println("== Welcome KH Library ==");
			System.out.println("******* 메인 메뉴 ******* ");
			System.out.println("1. 새 도서 추가   ");
			System.out.println("2. 도서 전체 조회 ");
			System.out.println("3. 도서 검색 조회  ");
			System.out.println("4. 도서 삭제   ");
			System.out.println("5. 도서 명 오름차순 정렬  ");
			System.out.println("9. 종료  ");
			System.out.print("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch (menu) {
			case 1:
				insertBook();
				break;
			case 2:
				selectList();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				ascBook();
				break;
			case 9 :
				return;
			}
		}
	}

	public void insertBook() {
		System.out.print("1. 도서명 입력받기 (String title) ");
		String title = sc.nextLine();
		
		System.out.print("2. 저자명 입력받기 (String author) ");
		String author = sc.nextLine();
		
		System.out.print("3. 장르 입력받기 (int category) (1.인문 / 2.자연과학 / 3.의료 / 4.기타)  ");
		int category = sc.nextInt();
		sc.nextLine();
		
		System.out.print("4. 가격 입력받기 (int price) ");
		int price = sc.nextInt();
		sc.nextLine();
		
		Book bk = new Book(title, author, 
			category == 1 ? "인문" :
			(category == 2 ? "자연과학" :
			(category == 3 ? "의료" : "기타")) , price);
			
		bc.insertBook(bk);
	}

	public void selectList() {
		ArrayList<Book> bookList = bc.selectList();
		
		if(bookList.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
			return;
		}
		
		for(Book b : bookList) {
			System.out.println(b);
		}
	}

	public void searchBook() {
		System.out.print("키워드 : ");
		String keyword = sc.nextLine();
		
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		if(searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		for(Book b : searchList) {
			System.out.println(b);
		}
	}

	public void deleteBook() {
		System.out.print("삭제할 도서명 : ");
		String title = sc.nextLine();
		
		System.out.print("삭제할 저자명 : ");
		String author = sc.nextLine();
		
		Book remove = bc.deleteBook(title, author);
		
		if(remove == null) {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
			return;
		}
		
		System.out.println("성공적으로 삭제되었습니다.");
		System.out.println("삭제된 도서 : "+remove);
	}

	public void ascBook() {
		int result = bc.ascBook();
		
		if(result == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
	}

}








