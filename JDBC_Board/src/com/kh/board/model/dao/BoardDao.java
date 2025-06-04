package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.template.JDBCTemplate;
import com.kh.board.model.vo.Board;

/** 
 * Service의 요청에 맞는 sql문을 실행할 클래스.
 * 단, sql문은 resources/query.xml에 보관/관리한다.
 * */
public class BoardDao {
	
	Properties prop = new Properties();
	
	public BoardDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int login(Connection conn, String memberId, String memberPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("login");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			
			rset = pstmt.executeQuery();			
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public List<Board> selectBoardList(Connection conn) {
		String sql = prop.getProperty("selectBoardList");
		List<Board> list = new ArrayList<>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			ResultSet rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBno(rset.getInt("bno"));
				b.setCreateDate(rset.getDate("create_date"));
				b.setTitle(rset.getString("title"));
				b.setWriter(rset.getString("writer")); // member_id값
				
				list.add(b);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int insertBoard(Connection conn, Board b) {
		String sql = prop.getProperty("insertBoard");
		int updateCount = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getWriter());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return updateCount;
	}

	public Board selectBoard(Connection conn, int boardNo) {
		String sql = prop.getProperty("selectBoard");
		Board b = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				b.setContent(rset.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return b;
	}

	public int updateBoard(Connection conn, Board b) {
		String sql = prop.getProperty("updateBoard");
		int updateCount = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getWriter());
			pstmt.setInt(4, b.getBno());
			
			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		String sql = prop.getProperty("deleteBoard");
		int updateCount = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, boardNo);
			
			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCount;
	}

}










