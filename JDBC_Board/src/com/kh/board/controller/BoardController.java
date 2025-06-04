package com.kh.board.controller;

import java.util.List;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.service.BoardServiceImpl;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Member;

/* 
 * View요청에 맞는 Service를 선택하여 메서드를 실행 한 후 결과값을 돌려주는 클래스.
 * */
public class BoardController {
	
	// service 변수 선언 및 초기화
	private BoardService bs = new BoardServiceImpl();
	
	// view의 login요청을 담당할 메서드
	public boolean login(String memberId, String memberPwd) {
		//Member m = new Member(memberId, memberPwd);
		int result = bs.login(memberId, memberPwd); 
		
		if(result == 1) return true;
		else return false; 
	}

	// view의 selectBoardList요청을 담당할 메서드
	public List<Board> selectBoardList() {
		List<Board> list = bs.selectBoardList();
		return list;
	}
	public int insertBoard(String title, String content, String memberId) {
		Board b = new Board();
		b.setTitle(title);
		b.setContent(content);
		b.setWriter(memberId);
		
		return bs.insertBoard(b);
	}

	public String selectBoard(int bno) {
		Board b = bs.selectBoard(bno);
		
		return b.getContent();
	}

	public int updateBoard(int bno, String title, String content, String memberId) {
		
		Board b = new Board();
		b.setBno(bno);
		b.setContent(content);
		b.setTitle(title);
		b.setWriter(memberId);
		
		return bs.updateBoard(b);
	}

	public int deleteBoard(int bno) {
		return bs.deleteBoard(bno);
	}

	
	
			
}





