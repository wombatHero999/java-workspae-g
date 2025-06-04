package com.kh.board.view;

import java.util.List;
import java.util.Scanner;

import com.kh.board.controller.BoardController;
import com.kh.board.model.vo.Board;

public class BoardView {
	private Scanner sc = new Scanner(System.in);
	private BoardController bc = new BoardController();
	String memberId = null;
	/**
	 * 로그인 기능.
	 * 사용자에게 로그인을 할 계정의 ID와, PWD를 입력받고 로그인 요청을 보내는 메소드
	 * 로그인 성공시 mainMenu를 호출, 로그인 실패시 ID,PWD를 다시 입력받음.
	 * 로그인 성공시 memberId에 사용자의 id를 저장.
	 *  */
	public void login() {
		System.out.println("### 게시판 서비스###");
		System.out.println("서비스 이용을 위해 로그인을 진행해주세요.");
		System.out.print("ID");
		String memberId = sc.nextLine();
		
		System.out.print("PWD");		
		String memberPwd = sc.nextLine();
		
		boolean result = bc.login(memberId, memberPwd);
		if(result) {
			this.memberId = memberId;
			mainMenu();
		}else {
			login();
		}
	}
	
	/**
	 * 메인메뉴
	 * 사용자에게 서비스중인 기능목록을 보여준후 , 정수형태로 서비스 번호를 입력받아 원하는 서비스를 제공해주는
	 * 메소드.
	 *  */
	public void mainMenu() {
		
		while(true) {
			System.out.println("### 게시판 서비스 ###");
			System.out.println("1. 게시판 목록 보기 ");
			System.out.println("2. 게시판 상세보기");
			System.out.println("3. 게시판 등록하기");
			System.out.println("4. 게시판 수정하기");
			System.out.println("5. 게시판 삭제하기");			
			System.out.println("9. 끝");		
			System.out.print("메뉴번호 >> ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: selectBoardList(); break;
			case 2: selectBoard(); break;
			case 3: insertBoard(); break;
			case 4: updateBoard(); break;
			case 5: deleteBoard(); break;
			case 9: return;
			}
		}
	}
	/** 
	 * 게시글 목록 조회 메서드
	 * 게시판에 존재하는 게시글 정보를 모두 출력하는 메서드.
	 * 게시글의 번호, 제목, 작성자, 작성시간 출력
	 * */
	public void selectBoardList() {
		System.out.println("게시글 번호\t게시글 제목\t작성자\t작성시간");
		List<Board> list = bc.selectBoardList();
		list.stream().forEach(System.out::println);
		
	}
	
	/** 
	 * 게시글 상세 조회 메서드
	 * 사용자로 하여금 게시글 번호를 입력받아 게시글 정보를 요청 한 후,
	 * 전달 받은 게시글정보를 출력하는 메소드.
	 * 
	 * */
	public void selectBoard() {
		System.out.println("게시글 번호\t게시글 제목\t게시글 작성 날짜");
		List<Board> list = bc.selectBoardList();
		for(Board b : list) {
			System.out.println(b.getBno()+"\t"+b.getTitle()+"\t"+b.getCreateDate());
		}
		System.out.print("검색 게시글 번호 >>> ");
		int bno = sc.nextInt();
		sc.nextLine();
		
		String content = bc.selectBoard(bno);
		if(content != null) {
			System.out.println("게시글 내용");
			System.out.println(content);			
		}else {
			System.out.println("존재하지 않는 게시글입니다.");
		}
	}
	
	/** 
	 * 게시글 등록 메서드
	 * 사용자로 하여금 게시글 제목과, 내용을 입력받아 게시글을 등록요청을 보내는 메소드
	 * */
	public void insertBoard() {
		System.out.print("제목 >>");
		String title = sc.nextLine();
		
		System.out.print("내용 >>");
		String content = sc.nextLine();
		
		int updateCount = bc.insertBoard(title,content,memberId);
		if(updateCount == 1) {
			System.out.println("게시글 등록 성공");
		}else {
			System.out.println("게시글 등록 실패");
		}
	}
	
	/** 
	 * 게시글 수정 메소드
	 * 사용자로 하여금 수정할 게시글 제목 번호과 내용을 입력받아 게시글 수정요청을 보내는 메소드
	 * */
	public void updateBoard() {
		System.out.print("수정할 게시글 번호 : ");
		int bno = sc.nextInt();
		sc.nextLine();
		
		System.out.print("수정할 게시글 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("수정할 게시글 내용 : ");
		String content = sc.nextLine();
		
		int result = bc.updateBoard(bno, title, content, memberId);
		if(result == 1) {
			System.out.println("정보수정 성공!");
		}else{
			System.out.println("정보수정 실패");
		}
		
	}
	
	/** 
	 * 게시글 삭제 메소드
	 * 사용자로 하여금 삭제할 게시글 번호를 입력받아 게시글 삭제 요청을 보내는 메소드
	 * */
	public void deleteBoard() {
		System.out.print("삭제할 게시글 번호 >> ");
		int bno = sc.nextInt();
		sc.nextLine();
		
		int updateCount = bc.deleteBoard(bno);
		if(updateCount == 1) {
			System.out.println("게시글 삭제 성공");
		}else {
			System.out.println("게시글 삭제 실패");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
