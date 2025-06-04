package com.kh.board.model.service;

import java.util.List;

import com.kh.board.model.vo.Board;

public interface BoardService {
	/**
	 * 로그인용 메서드
	 * 
	 * @param memberId  : 사용자가 전달한 id값
	 * @param MemberPwd : 사용자가 전달한 pwd값
	 * @return 조회된 사용자의 수
	 */
	int login(String memberId, String MemberPwd);

	/**
	 * 게시글 등록용 메서드
	 * 
	 * @param b : 등록할 게시글의 정보가 담긴 객체
	 * @return 등록된 행의 갯수를 반환.
	 */
	int insertBoard(Board b);

	/**
	 * 게시글 목록 조회용 메서드
	 * 
	 * @return 게시글 정보들을 반환
	 */
	List<Board> selectBoardList();

	/**
	 * 게시글 조회용 메서드
	 * 
	 * @param boardNo : 조회할 게시글 글번호
	 * @return 게시글 번호에 해당하는 게시글 반환
	 */
	Board selectBoard(int boardNo);

	/**
	 * 게시글 수정 메서드
	 * 
	 * @param boardNo : 수정할 게시글 번호
	 * @param B       : 수정할 게시글 정보(게시글 제목, 내용만 수정가능)
	 * @return 처리된 행의 갯수를 반환
	 */
	int updateBoard(Board b);

	/**
	 * 게시글 삭제 메서드
	 * 
	 * @param boardNo : 삭제할 게시글 번호
	 * @return 처리된 행의 갯수를 반환
	 */
	int deleteBoard(int boardNo);
}
