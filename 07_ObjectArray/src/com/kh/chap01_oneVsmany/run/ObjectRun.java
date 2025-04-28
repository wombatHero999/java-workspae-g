package com.kh.chap01_oneVsmany.run;

import java.util.Scanner;

import com.kh.chap01_oneVsmany.model.vo.Book;

public class ObjectRun {
	
	public static void main(String[] args) {
		// 1. 기본생성자 호출 후 setter를 통해 초기화
		Book bk1 = new Book();
		bk1.setTitle("Do It 자바프로그래밍");
		bk1.setAuthor("나자바");
		bk1.setPrice(20000);
		bk1.setPublisher("이지스퍼블리싱");
		
		// 2. 매개변수 생성자로 객체 생성 후 초기화
		Book bk2 = new Book("C언어","민경민",19000, "이지스퍼블리싱");
		
		// 3. 사용자가 입력한 값들로 객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 : ");
		String author = sc.nextLine();
		
		System.out.print("출판사 : ");
		String publisher = sc.nextLine();
		
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		Book bk3 = new Book(title, author, price, publisher);
		
		for(int i = 0; i<3; i++) {
			if(i == 0 ) {
				System.out.println(bk1.information());
			}else if(i == 1) {
				System.out.println(bk2.information());
			}else {
				System.out.println(bk3.information());
			}
		}
		
		// 객체만 있는 상태에서 작업하는게 비효율적이므로, 이 객체들을 배열에 넣어서 관리하독 하자.
		// 객체 배열
		Book[] arr = new Book[3];
		
		arr[0] = bk1;
		arr[1] = bk2;
		arr[2] = bk3;
		
		for(Book book : arr) {
			System.out.println(book.information());
		}
		// 사용자에게 검색할 도서 제목을 입력받아 전체 도서목록들 중 일치하는 제목의 도서 찾기.
		
		sc.nextLine();
		
		System.out.print("검색할 책의 제목 : ");
		String searchTitle = sc.nextLine();
		
		// book객체 내부의 책의 제목?
		// bk1의 책의 제목과, 검색할 책의 제목이 일치하는가? 라는 조건식.
		for(int i =0; i<arr.length;i++) {
			if(arr[i].getTitle().equals(searchTitle)) {
				System.out.println(arr[i].information());
			}
		}
		//bk1.getTitle().equals(searchTitle)
		
	}

}















