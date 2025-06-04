package com.kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.template.JDBCTemplate;
import com.kh.board.model.vo.Board;

// BoardService 인터페이스를 구현하는 클래스.
// 각 메서드의 설명에 맞게 기능을 작성.
public class BoardServiceImpl implements BoardService{
	
	private BoardDao dao = new BoardDao();
	
	@Override
	public int login(String memberId, String MemberPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.login(conn, memberId, MemberPwd);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int insertBoard(Board b) {
		//DML -> 트랜잭션 처리
		Connection conn = JDBCTemplate.getConnection();
		int updateCount = dao.insertBoard(conn, b);
		
		if(updateCount == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return updateCount;
	}

	@Override
	public List<Board> selectBoardList() {
		Connection conn = JDBCTemplate.getConnection();
		List<Board> list = dao.selectBoardList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}

	@Override
	public Board selectBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Board b = dao.selectBoard(conn, boardNo);
		
		JDBCTemplate.close(conn);
		return b;
	}

	@Override
	public int updateBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int updateCount = dao.updateBoard(conn, b);
		
		if(updateCount == 1){
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return updateCount;
	}

	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int updateCount = dao.deleteBoard(conn, boardNo);
		
		if(updateCount == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return updateCount;
	}

}








